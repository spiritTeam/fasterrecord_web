package com.hitworth.framework.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hitworth.framework.base.vo.EnergyLabelUserVO;
import com.hitworth.framework.base.vo.NewTree;
import com.hitworth.framework.base.vo.SecurityUser;
import com.hitworth.framework.base.vo.TreeNodeVO;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.energylabel.fastrecord.util.HttpsUtils;
import com.energylabel.fastrecord.vo.EnergyLabelUser;
import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.model.User;
import com.hitworth.framework.base.service.UserService;
import com.hitworth.framework.base.util.BusinessException;
import com.hitworth.framework.base.util.PageUtil;
import com.hitworth.framework.base.util.ResponseUtil;
import com.hitworth.framework.base.util.UserUtil;
import com.hitworth.framework.base.vo.UserRole;


/**
 * 
 * User action 项目名称：base_spring_framework 类名称：UserController 类描述： 创建人：huangxiong 创建时间：2015年2月6日
 * 下午1:20:14 修改人：huangxiong 修改时间：2015年2月6日 下午1:20:14 修改备注：
 * 
 * @version
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
  private static final Logger logger = Logger.getLogger(UserController.class);

  @Autowired
  UserService userService;
  @Value("${beian_domain}")
  private String beianDomain;

  /**
   * 新增用户
   * 
   * @Title: add @Description: 新增用户 @param @param user 用户对象 @return Object 返回类型 @throws
   */
  @RequestMapping(value = "/add")
  public @ResponseBody Object add(User user) {
    userService.insertUser(user);
    return ResponseUtil.success();
  }


  /**
   * 删除用户
   * 
   * @Title: delete @Description: 删除用户 @param @param id userId @param @param loginName 账号 @return
   *         Object 返回类型 @throws
   */
  @RequestMapping(value = "/delete")
  public @ResponseBody Object delete(@RequestParam(value = "id") int id,
      @RequestParam(value = "loginName") String loginName) {
    userService.deleteUser(id, loginName);
    return ResponseUtil.success();
  }


  /**
   * 更新用户信息
   * 
   * @Title: update @Description: 更新用户信息 @param @param user 用户对象 @return Object 返回类型 @throws
   */
  @RequestMapping(value = "/update")
  public @ResponseBody Object update(User user) {
    userService.updateUser(user);
    return ResponseUtil.success();
  }

  @RequestMapping(value = "/mail")
  public @ResponseBody Object sendRestMail(HttpServletRequest req,
      @RequestParam("loginName") String loginName) {

    userService.findAndsendRestMail(req, loginName);

    return ResponseUtil.success();
  }


  /**
   * 
   * @Title: resetCheck @Description: 检查参数是否正确 @param @param req request @param @param loginName
   *         用户名 @param @param time 时间 @param @param authInfo 加密串 @param @return @return String
   *         返回类型 @throws
   */
  @RequestMapping(value = "/resetCheck")
  public String resetCheck(HttpServletRequest req, @RequestParam("loginName") String loginName,
      @RequestParam("time") long time, @RequestParam("authInfo") String authInfo) {

    // 正确通过
    if (userService.findAndresetCheck(req, loginName, time, authInfo)) {
      return "resetPassword";
    } else {
      // 检查失败
      return "redirect:/html/index/accessDenied.html";

    }

  }

  /**
   * 
   * @Title: reset @Description: 重置密码 @param @param req @param @param
   *         loginName @param @return @return Object 返回类型 @throws
   */
  @RequestMapping(value = "/reset")
  public @ResponseBody Object reset(HttpServletRequest req,
      @RequestParam("password") String password) {
    userService.updateAndreset(req, password);
    return ResponseUtil.success();
  }



  /**
   * 用户角色分配
   * 
   * @Title: checkRoles @Description: 用户角色分配 @param @param id userID @param @param roleIds
   *         角色ID集合 @return Object 返回类型 @throws
   */
  @RequestMapping("/checkRoles")
  public @ResponseBody Object checkRoles(@RequestParam(value = "id") int id,
      @RequestParam(value = "roleIds") String roleIds) {

    userService.updateRoleschecked(id, roleIds);
    return ResponseUtil.success();
  }


  /**
   * 冻结、解冻用户
   * 
   * @Title: frozen @Description: 冻结、解冻用户 @param @param id userId @param @param state 用户当前状态 @return
   *         Object 返回类型 @throws
   */
  @RequestMapping(value = "/frozen", method = RequestMethod.POST)
  public @ResponseBody Object frozen(@RequestParam("id") int id, @RequestParam("state") int state) {
    userService.updateState(id, state);
    return ResponseUtil.success();

  }


  /**
   * 修改密码
   *
   * @Title: changePwd @Description: 修改密码 @param @param oldPassword 旧密码 @param @param password
   *         新密码 @return Object 返回类型 @throws
   */
  @RequestMapping(value = "/password", method = RequestMethod.POST)
  public @ResponseBody Object changePwd(@RequestParam("oldPassword") String oldPassword,
      @RequestParam("password") String password) {
    String loginName = UserUtil.getLoginName();
    userService.updatePassword(loginName, oldPassword, password);
    return ResponseUtil.success();
  }

  @ResponseBody
  @RequestMapping(value = "/getUserInfo")
  public Object getUserInfo() {
    SecurityUser securityUser = UserUtil.getSecurityUser();
    Integer fastRecordUserId = securityUser.getId();
    // Integer fastRecordUserId = 2;
    EnergyLabelUser energyLabelUser = userService.getEnergyLabelUser(fastRecordUserId);
    return ResponseUtil.success(energyLabelUser);
  }


  @ResponseBody
  @RequestMapping(value = "/bindEnergyLabelUser")
  public Object bindEnergyLabelUser(String fastRecordLoginName, String energyLabelLoginName,
      Integer energyLabeluserId) {
    if (StringUtils.isEmpty(fastRecordLoginName)) {
      return ResponseUtil.fail("请填写本系统账号！");
    }
    if (StringUtils.isEmpty(energyLabelLoginName)) {
      return ResponseUtil.fail("请填写备案系统账号！");
    }
    if (null == energyLabeluserId) {
      return ResponseUtil.fail("请填写备案系统用户ID！");
    }
    User user = userService.findUserByLoginName(fastRecordLoginName);
    if (null == user) {
      return ResponseUtil.fail("本系统账号不存在！");
    }
    EnergyLabelUser energyLabelUser = userService.getEnergyLabelUserByUserName(fastRecordLoginName);
    if (!StringUtils.isEmpty(energyLabelUser.getEnergyLabelLoginName())) {
      return ResponseUtil.fail("本系统账号已绑定！");
    }

    Map<String, String> params = new HashMap<>();
    params.put("userid", energyLabeluserId.toString());
    params.put("username", energyLabelLoginName);
    String re = null;
    try {
      re = HttpsUtils.post(beianDomain + "/energyLabelUser/get.do", null, params, null);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.fail("请求失败！");
    }
    EnergyLabelUserVO energyLabelUserVO = JSONObject.parseObject(re, EnergyLabelUserVO.class);
    energyLabelUserVO.setFastRecordLoginName(fastRecordLoginName);
    
    userService.updateEnergyLabelUser(energyLabelUserVO);
    return ResponseUtil.success();
  }


  /**
   * 用户分配角色
   * 
   * @Title: roleList @Description: 用户分配角色 @param @param id userId @return Object 返回类型 @throws
   */
  @RequestMapping("/roleList")
  public @ResponseBody Object roleList(@RequestParam(value = "id") int id) {

    List<UserRole> list = userService.findRoleList(id);
    return list;
  }

  /**
   * 用户分配角色
   *
   * @Title: roleList @Description: 用户分配角色 @param @param id userId @return Object 返回类型 @throws
   */
  @RequestMapping("/roleList2")
  public @ResponseBody Object roleList2(@RequestParam(value = "id") int id) {

    List<NewTree> list = userService.findRoleList2(id);

    return list;
  }

  /**
   * 全部用户列表
   * 
   * @Title: list @Description: 全部用户列表 @return Object 返回类型 @throws
   */
  @RequestMapping("/list")
  public @ResponseBody Object list(User user,
      @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
      @RequestParam(defaultValue = "15", value = "pageSize") int pageSize) {

    PageInfo<User> page = userService.findUserList(user, pageNum, pageSize);
    return PageUtil.convertGrid(page);
  }


  @RequestMapping(value = "/name")
  public @ResponseBody Object getName() {
    return ResponseUtil.success(UserUtil.getSecurityUser().getDisplayName());

  }

  /**
   * 根据用户id获取组织机构树
   * 
   * @param userId
   * @return
   */
  @RequestMapping("/orgTree")
  public @ResponseBody Object tree(@Param(value = "userId") Integer userId) {
    List<TreeNodeVO> tree = userService.getOrgsWithUserRelated(userId);
    return tree;
  }

  /**
   * 选择组织机构
   * 
   * @param userId
   * @param orgId
   * @return
   */
  @RequestMapping("/selectOrg")
  public @ResponseBody Object selectOrg(@Param(value = "userId") Integer userId,
      @Param(value = "orgId") Integer orgId) {
    userService.insertOrg(userId, orgId);
    return ResponseUtil.success();
  }


  /**
   * 异常处理
   * 
   * @Title: exception @Description: 异常处理 @return Object 返回类型 @throws
   */
  @ExceptionHandler({BusinessException.class})
  public @ResponseBody Object exception(BusinessException e) {
    return ResponseUtil.fail(e.getErr());
  }
}
