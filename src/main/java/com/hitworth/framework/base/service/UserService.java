package com.hitworth.framework.base.service;

import com.energylabel.fastrecord.vo.EnergyLabelUser;
import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.model.User;
import com.hitworth.framework.base.vo.EnergyLabelUserVO;
import com.hitworth.framework.base.vo.NewTree;
import com.hitworth.framework.base.vo.TreeNodeVO;
import com.hitworth.framework.base.vo.UserRole;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * user操作类
 * <p/>
 * 项目名称：base_spring_framework 类名称：UserService 类描述： 创建人：huangx 创建时间：2015年1月27日 下午7:02:54 修改人：huangx
 * 修改时间：2015年1月27日 下午7:02:54 修改备注：
 *
 * @version 1.0
 */
public interface UserService {


    /**
     * @param @param user user对象
     * @return void 返回类型
     * @throws
     * @Title: 增加USER
     * @Description: 新增用户
     */
    public void insertUser(User user);


    /**
     * 刪除用戶
     *
     * @param @param userId 用户ID
     * @return void 返回类型
     * @throws
     * @Title: deleteUser
     * @Description: 刪除用戶
     */
    public void deleteUser(Integer userId);

    /**
     * @param @param userId
     * @param @param loginName 用户
     * @return void 返回类型
     * @throws
     * @Title: deleteUser
     * @Description: 删除用户
     */
    public void deleteUser(Integer userId, String loginName);


    /**
     * @param @param  user
     * @param @return
     * @throws
     * @Title: updateUser
     * @Description: 更新用户
     */
    public void updateUser(User user);

    /**
     * @param @param loginName 登录名
     * @param @param oldPassword 旧密码
     * @param @param password 新密码
     * @throws
     * @Title: updatePassword
     * @Description: 修改密码
     */
    public void updatePassword(String loginName, String oldPassword, String password);


    /**
     * @param @param id
     * @param @param state 当前状态
     * @return void 返回类型
     * @throws
     * @Title: updateState
     * @Description: 冻结或者解冻用户账号
     */
    public void updateState(int id, int state);


    /**
     * @param @param userId userid
     * @param @param roleIds 角色集合
     * @return void 返回类型
     * @throws
     * @Title: updateRoleschecked
     * @Description: 选择用户角色
     */
    public void updateRoleschecked(int userId, String roleIds);


    /**
     * @param @param  pageNum 当前页
     * @param @param  pageSize 每页显示数量
     * @param @return
     * @return PageInfo<User> 返回类型
     * @throws
     * @Title: findUserList
     * @Description: 查询所有用户
     */
    public PageInfo<User> findUserList(int pageNum, int pageSize);

    /**
     * @param @param  user
     * @param @param  pageNum 当前页
     * @param @param  pageSize 每页显示数量
     * @param @return 设定文件
     * @return PageInfo<User> 返回类型
     * @throws
     * @Title: findUserList
     * @Description: 条件查询user
     */
    public PageInfo<User> findUserList(User user, int pageNum, int pageSize);


    /**
     * @param @param  userId 用户ID
     * @param @return
     * @return List<UserRole> 返回类型
     * @throws
     * @Title: findRoleList
     * @Description: 查询当前用户的角色列表
     */
    public List<UserRole> findRoleList(int userId);


    /**
     * @param @param loginName 登录名
     * @return User User对象
     * @throws
     * @Title: findUserByLoginName
     * @Description: 查询user
     */
    public User findUserByLoginName(String loginName);

    /**
     * @param @param  email
     * @param @return
     * @return User 返回类型
     * @throws
     * @Title: findUserByEmail
     * @Description: 查询USER
     */
    public User findUserByEmail(String email);


    /**
     * @param @param req
     * @param @param loginName
     * @return void    返回类型
     * @throws
     * @Title: findAndsendRestMail
     * @Description: 发送忘记密码邮件
     */
    public void findAndsendRestMail(HttpServletRequest req, String loginName);


    /**
     * @param @param  req
     * @param @param  loginName
     * @param @param  time
     * @param @param  authInfo
     * @param @return
     * @return boolean    返回类型
     * @throws
     * @Title: findAndresetCheck
     * @Description: 密码重置参数检查
     */
    public boolean findAndresetCheck(HttpServletRequest req, String loginName, long time, String authInfo);


    /**
     * @param @param req
     * @param @param password
     * @return void    返回类型
     * @throws
     * @Title: updateAndreset
     * @Description: 重置密碼
     */
    public void updateAndreset(HttpServletRequest req, String password);

    /**
     * 根据用户id获取组织机构树
     *
     * @param userId
     * @return
     */
    public List<TreeNodeVO> getOrgsWithUserRelated(int userId);

    /**
     * 用户设置组织机构
     * @param userId
     * @param orgId
     */
    void insertOrg(Integer userId, Integer orgId);

    List<NewTree> findRoleList2(int id);

    EnergyLabelUser getEnergyLabelUser(Integer fastRecordUserId);
    
    EnergyLabelUser getEnergyLabelUserByUserName(String userName);
    
    void updateEnergyLabelUser(EnergyLabelUserVO energyLabelUserVO);
}
