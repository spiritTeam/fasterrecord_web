package com.hitworth.framework.base.dao;

import com.energylabel.fastrecord.vo.EnergyLabelUser;
import com.hitworth.framework.base.model.User;
import com.hitworth.framework.base.vo.EnergyLabelUserVO;
import com.hitworth.framework.base.vo.TreeNodeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * user DAO
 * <p/>
 * 项目名称：base_spring_framework 类名称：UserDAO 类描述： 创建人：huangx 创建时间：2015年1月27日 下午7:09:58 修改人：huangx
 * 修改时间：2015年1月27日 下午7:09:58 修改备注：
 */
public interface UserDAO {

  /**
   * @param @param user
   * @return
   * @throws @Title: insertUser
   * @Description: 新增用户
   */
  public void insertUser(User user);

  /**
   * @param @param userId 用户ID
   * @param @param roleId 角色ID
   * @return void 返回类型
   * @throws @Title: insertUserRole
   * @Description: 插入用户、角色关联
   */
  public void insertUserRole(@Param("userId") int userId, @Param("roleId") int roleId);

  /**
   * @param @param userId 用户id
   * @return void 返回类型
   * @throws @Title: deleteUser
   * @Description: 删除用户
   */
  public void deleteUser(Integer userId);


  /**
   * @param @param user 用户
   * @return void 返回类型
   * @throws @Title: updateUser
   * @Description: 修改用户
   */
  public void updateUser(User user);

  /**
   * @param @param userId 用户id
   * @return void 返回类型
   * @throws @Title: deleteUserRole
   * @Description: 删除关联表
   */
  public void deleteUserRole(Integer userId);

  /**
   * @param @param user user
   * @return void 返回类型
   * @throws @Title: updatePassword
   * @Description: 修改密码
   */
  public void updatePassword(User user);


  /**
   * @param @param id 主键
   * @param @param state 修改后的状态
   * @return void 返回类型
   * @throws @Title: updateState
   * @Description: 冻结、解冻账号
   */
  public void updateState(@Param("id") int id, @Param("state") int state);


  /**
   * @param @return 用户列表
   * @return List<User> 返回类型
   * @throws @Title: finduserList
   * @Description: 查询使用用户
   */
  public List<User> finduserList();

  /**
   * @param @param user
   * @param @return 设定文件
   * @return List<User> 返回类型
   * @throws @Title: findUserListByQuery
   * @Description: 条件查询user
   */
  public List<User> findUserListByQuery(User user);

  /**
   * @param @param userId 用户ID
   * @param @return 设定文件
   * @return List<Integer> 返回类型
   * @throws @Title: findRolesByUserId
   * @Description: 查询当前用户关联的角色ID
   */
  public List<Integer> findRolesByUserId(int userId);


  /**
   * @param @param loginName
   * @param @return 设定文件
   * @return List<User> 返回类型
   * @throws @Title: findUserByLoginName
   * @Description: 查询user
   */
  public List<User> findUserByLoginName(@Param("loginName") String loginName);


  /**
   * @param @param email
   * @param @return
   * @return User 返回类型
   * @throws @Title: findUserByEmail
   * @Description: 查询user
   */
  public User findUserByEmail(String email);

  /**
   * @param @return
   * @return User 返回类型
   * @throws @Title: findUserById
   * @Description: 根据ID加载对象
   */
  public User findUserById(int id);

  /**
   * 获取带有用户和组织关联关系的组织树
   * 
   * @param userId
   * @return
   */
  public List<TreeNodeVO> getOrgsWithUserRelated(int userId);

  /**
   * 为用户添加组织机构
   * 
   * @param userId
   * @param orgId
   * @return
   */
  int insertOrg(@Param("userId") Integer userId, @Param("orgId") Integer orgId);

  /**
   * 为用户删除组织机构
   * 
   * @param userId
   * @return
   */
  int deleteOrg(@Param("userId") Integer userId);

  /**
   * 获取能效系统用户信息
   * 
   * @param fastRecordUserId
   * @return
   */
  EnergyLabelUser getEnergyLabelUser(@Param("fastRecordUserId") Integer fastRecordUserId);

  int updateEnergyLabelUser(EnergyLabelUserVO energyLabelUserVO);

  /**
   * 获取能效系统用户信息
   * 
   * @param userName
   * @return
   */
  EnergyLabelUser getEnergyLabelUserByUserName(@Param("userName") String userName);
}
