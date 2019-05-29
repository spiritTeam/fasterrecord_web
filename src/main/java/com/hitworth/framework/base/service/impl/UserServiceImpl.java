package com.hitworth.framework.base.service.impl;

import com.energylabel.fastrecord.dao.SysUserCategoryDAO;
import com.energylabel.fastrecord.vo.EnergyLabelUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.dao.RoleDAO;
import com.hitworth.framework.base.dao.UserDAO;
import com.hitworth.framework.base.model.Role;
import com.hitworth.framework.base.model.User;
import com.hitworth.framework.base.service.UserService;
import com.hitworth.framework.base.util.*;
import com.hitworth.framework.base.vo.EnergyLabelUserVO;
import com.hitworth.framework.base.vo.NewTree;
import com.hitworth.framework.base.vo.SysUserCategoryVO;
import com.hitworth.framework.base.vo.TreeNodeVO;
import com.hitworth.framework.base.vo.UserRole;
import com.hitworth.framework.base.vo.UserType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * user serviceImpl
 * <p/>
 * 项目名称：base_spring_framework 类名称：UserServiceImpl 类描述： 创建人：huangx 创建时间：2015年1月27日 下午7:17:30
 * 修改人：huangx 修改时间：2015年1月27日 下午7:17:30 修改备注：
 */
@Service("userService")
public class UserServiceImpl implements UserService {
  private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
  @Autowired
  private UserDAO userDAO;
  @Autowired
  private RoleDAO roleDAO;
  @Autowired
  private SysUserCategoryDAO sysUserCategoryDAO;

  @Override
  public void insertUser(User user) {
    validate(user);
    User initUser = findUserByLoginName(user.getLoginName());
    if (initUser != null) throw new BusinessException(10003);

    // 不进行唯一判断
    /*
     * initUser = findUserByEmail(user.getEmail()); if (initUser != null) throw new
     * BusinessException(10013);
     */

    init(user);
    userDAO.insertUser(user);
  }

  @Override
  public void deleteUser(Integer userId) {
    userDAO.deleteUserRole(userId);
    userDAO.deleteUser(userId);

  }

  @Override
  public void deleteUser(Integer userId, String loginName) {
    if (UserUtil.getLoginName().equals(loginName)) throw new BusinessException(10006);
    deleteUser(userId);

  }

  @Override
  public void updateUser(User user) {

    validate(user);

    // 不进行唯一判断
    /*
     * User oldUser = userDAO.findUserById(user.getId()); if
     * (!oldUser.getEmail().equals(user.getEmail())) {
     * 
     * User otherUser = findUserByEmail(user.getEmail()); if (otherUser != null) throw new
     * BusinessException(10013); }
     */

    init(user);
    userDAO.updateUser(user);


  }


  @Override
  public void updateRoleschecked(int userId, String roleIds) {

    logger.info("roleIds:" + roleIds);
    // 删除旧关系
    userDAO.deleteUserRole(userId);

    if (StringUtils.isEmpty(roleIds)) return;
    // 建立新关系
    String[] ids = roleIds.split(",");
    for (String roleId : ids) {
      userDAO.insertUserRole(userId, Integer.valueOf(roleId));
    }

  }


  @Override
  public void updatePassword(String loginName, String oldPassword, String password) {
    if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(password)) {
      throw new BusinessException(10007);
    }
    if (password.length() > 20) throw new BusinessException(10104);
    User user = findUserByLoginName(loginName);
    if (user == null) throw new BusinessException(10004);
    String passwordHash = new Md5PasswordEncoder().encodePassword(oldPassword, loginName);
    if (!passwordHash.equalsIgnoreCase(user.getPassword())) throw new BusinessException(10005);
    user.setPassword(new Md5PasswordEncoder().encodePassword(password, loginName));
    userDAO.updatePassword(user);
  }


  @Override
  public void updateState(int id, int state) {
    state = state == ConstantUtil.OK ? ConstantUtil.FAIL : ConstantUtil.OK;
    userDAO.updateState(id, state);

  }


  @Override
  public User findUserByLoginName(String loginName) {
    logger.info("loginName:" + loginName);
    List<User> list = userDAO.findUserByLoginName(loginName);
    if (list.size() > 0) return list.get(0);
    return null;
  }


  @Override
  public PageInfo<User> findUserList(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<User> list = userDAO.finduserList();
    PageInfo<User> page = new PageInfo<User>(list);
    return page;
  }

  @Override
  public PageInfo<User> findUserList(User user, int pageNum, int pageSize) {

    PageHelper.startPage(pageNum, pageSize);
    List<User> list = userDAO.findUserListByQuery(user);
    PageInfo<User> page = new PageInfo<User>(list);
    return page;
  }


  @Override
  public List<UserRole> findRoleList(int userId) {

    List<UserRole> userRoles = new ArrayList<UserRole>();
    List<Role> roles = roleDAO.findAllEffectiveRoles();
    List<Integer> myRoles = userDAO.findRolesByUserId(userId);

    for (Role role : roles) {
      UserRole userRole = new UserRole();
      userRole.setId(role.getId());
      userRole.setName(role.getRoleName());
      for (Integer myid : myRoles) {
        if (role.getId().equals(myid)) userRole.setChecked(true);
      }
      userRoles.add(userRole);
    }

    return userRoles;
  }

  @Override
  public List<NewTree> findRoleList2(int userId) {
    List<NewTree> userRoles = new ArrayList<NewTree>();

    List<Role> roles = roleDAO.findAllEffectiveRoles();
    List<Integer> myRoles = userDAO.findRolesByUserId(userId);

    for (Role role : roles) {
      NewTree userRole = new NewTree();
      userRole.setId(role.getId());
      userRole.setTitle(role.getRoleName());
      for (Integer myid : myRoles) {
        if (role.getId().equals(myid)) userRole.setChecked(true);
      }
      userRoles.add(userRole);
    }

    return userRoles;
  }


  /**
   * 参数检查
   *
   * @param @param user
   * @return void 返回类型
   * @throws @Title: validate
   * @Description: 参数检查
   */
  private void validate(User user) {

    if (StringUtils.isEmpty(user.getLoginName())) throw new BusinessException(10101);

    Pattern p = Pattern.compile("^[a-zA-Z]\\w{4,15}$");
    Matcher m = p.matcher(user.getLoginName());
    if (!m.matches()) throw new BusinessException(10102);

    if (StringUtils.isEmpty(user.getPassword())) throw new BusinessException(10103);

    if (user.getPassword().length() > 20) throw new BusinessException(10104);

    if (StringUtils.isEmpty(user.getDisplayName())) throw new BusinessException(10105);

    if (user.getDisplayName().length() > 20) throw new BusinessException(10106);


    // 邮箱验证
    if (StringUtils.isEmpty(user.getEmail())) throw new BusinessException(10107);

    p = Pattern.compile(
        "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    m = p.matcher(user.getEmail());
    if (!m.matches()) throw new BusinessException(10108);

    // 手机号验证
    if (StringUtils.isEmpty(user.getContactPhone())) throw new BusinessException(10109);
    p = Pattern.compile("^[1][0-9]{10}$");
    m = p.matcher(user.getContactPhone());
    if (!m.matches()) throw new BusinessException(10110);

    // 用户类型验证
    boolean typeCheck = false;
    for (UserType userType : UserType.values()) {
      if (userType.toString().equals(user.getType())) {
        typeCheck = true;
        break;
      }
    }

    if (!typeCheck) throw new BusinessException(10123);


  }

  /**
   * 初始化信息填充
   *
   * @param @param user
   * @return void 返回类型
   * @throws @Title: init
   * @Description: 初始化信息填充
   */
  private void init(User user) {
    user.setState(ConstantUtil.OK);
    user.setInsertTime(new Timestamp(System.currentTimeMillis()));
    user.setPassword(
        new Md5PasswordEncoder().encodePassword(user.getPassword(), user.getLoginName()));
  }

  @Override
  public User findUserByEmail(String email) {
    return userDAO.findUserByEmail(email);
  }

  @Override
  public void findAndsendRestMail(HttpServletRequest req, String loginName) {

    // 超过10次不再接受请求
    HttpSession session = req.getSession();
    if (session.getAttribute("sys_try_time") == null) session.setAttribute("sys_try_time", 0);
    int tryTimes = (int) session.getAttribute("sys_try_time") + 1;
    session.setAttribute("sys_try_time", tryTimes);
    if (tryTimes > 10) {
      throw new BusinessException(10016);
    }


    if (StringUtils.isEmpty(loginName)) throw new BusinessException(10101);
    User user = findUserByLoginName(loginName);
    if (user == null) throw new BusinessException(10004);

    long time = System.currentTimeMillis();
    String lastTime = (String) session.getAttribute("sys_time");
    if (!StringUtils.isEmpty(lastTime)) {
      long last = Long.valueOf(lastTime).longValue();
      if (time - last < 60 * 1000) throw new BusinessException(10015);
    }

    session.setAttribute("sys_time", String.valueOf(time));


    String url = ConfigUtil.getConfigContent("config/properties/sys_config", "email_url");
    String authInfo = Encodes.encodeBase64(Encodes
        .encodeHex(HmacUtil.hmacSha1((user.getLoginName() + time).getBytes(),
            ConfigUtil.getConfigContent("config/properties/sys_config", "email_key").getBytes()))
        .getBytes());
    logger.info(authInfo);
    url = MessageFormat.format(url, authInfo, user.getLoginName(), String.valueOf(time));
    MailUtil.sendMail(user.getEmail(),
        FreeMakerUtil.format(
            ConfigUtil.getConfigContent("config/properties/sys_config", "email_temp"),
            user.getEmail(), url, url, DateUtil.dateToStr(new Date())));

  }

  @Override
  public boolean findAndresetCheck(HttpServletRequest req, String loginName, long time,
      String authInfo) {

    // 非空检查
    if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(authInfo)) return false;
    // 时间检查
    long timeNew = System.currentTimeMillis();
    long timeDif = timeNew - time;
    if (timeDif > 10 * 60 * 1000 || timeDif <= 0) return false;
    // 授权检查
    try {
      if (Arrays
          .equals(
              HmacUtil.hmacSha1((loginName + time).getBytes(),
                  ConfigUtil.getConfigContent("config/properties/sys_config", "email_key")
                      .getBytes()),
              Encodes.decodeHex(new String(Encodes.decodeBase64((authInfo)), "UTF-8")))) {
        req.getSession().setAttribute("loginName", loginName);
        logger.info("login success session");
        return true;
      }
    } catch (UnsupportedEncodingException e) {
      logger.error("UnsupportedEncodingException error");
      e.printStackTrace();
    }


    return false;
  }

  @Override
  public void updateAndreset(HttpServletRequest req, String password) {
    if (StringUtils.isEmpty(password)) throw new BusinessException(10007);
    if (password.length() > 20) throw new BusinessException(10104);
    String loginName = (String) req.getSession().getAttribute("loginName");
    if (StringUtils.isEmpty(loginName)) throw new BusinessException(10014);
    User user = findUserByLoginName(loginName);
    if (user == null) throw new BusinessException(10004);
    user.setPassword(new Md5PasswordEncoder().encodePassword(password, loginName));
    userDAO.updatePassword(user);
  }

  @Override
  public List<TreeNodeVO> getOrgsWithUserRelated(int userId) {
    return userDAO.getOrgsWithUserRelated(userId);
  }

  @Override
  public void insertOrg(Integer userId, Integer orgId) {
    userDAO.deleteOrg(userId);
    userDAO.insertOrg(userId, orgId);
  }

  @Override
  public EnergyLabelUser getEnergyLabelUser(Integer fastRecordUserId) {
    EnergyLabelUser energyLabelUser = new EnergyLabelUser();
    energyLabelUser = userDAO.getEnergyLabelUser(fastRecordUserId);
    List<SysUserCategoryVO> sysUserCategoryVOList =
        sysUserCategoryDAO.findSysUserCategoryByUserId(energyLabelUser.getEnergyLabeluserId());
    List<String> productTypeList=energyLabelUser.getProductTypeList();
    for (int i = 0; i < sysUserCategoryVOList.size(); i++) {
      productTypeList.add(sysUserCategoryVOList.get(i).getEcModelTitle());
    }
    return energyLabelUser;
  }

  @Override
  public void updateEnergyLabelUser(EnergyLabelUserVO energyLabelUserVO) {
    userDAO.updateEnergyLabelUser(energyLabelUserVO);
    if (energyLabelUserVO.getSysUserCategoryList().size() > 0) {
      sysUserCategoryDAO.batchInsertSysUserCategory(energyLabelUserVO.getSysUserCategoryList());
    }
  }

  @Override
  public EnergyLabelUser getEnergyLabelUserByUserName(String userName) {
    EnergyLabelUser energyLabelUser = new EnergyLabelUser();
    energyLabelUser = userDAO.getEnergyLabelUserByUserName(userName);
    return energyLabelUser;
  }

}
