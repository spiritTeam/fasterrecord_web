package com.hitworth.framework.base.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.model.Role;


/**
 * role操作类
 * 
 * 项目名称：base_spring_framework 类名称：RoleService 类描述： 创建人：huangx 创建时间：2015年1月27日 下午7:02:54 修改人：huangx
 * 修改时间：2015年1月27日 下午7:02:54 修改备注：
 * 
 * @version 1.0
 * 
 */
public interface RoleService {

  /**
   * 
   * @Title: validate
   * @Description: 参数校验
   * @param: Role
   * @return: void 返回类型
   * @throws
   */
  public void validate(Role role);


  /**
   * 
   * @Title: init
   * @Description: 初始对象填充
   * @param: role
   * @return: void 返回类型
   * @throws
   */
  public void init(Role role);

  /**
   * 
   * @Title: 增加Role
   * @Description: 新增角色
   * @param: role Role对象
   * @return: void 返回类型
   * @throws
   */
  public void insertRole(Role role);

  /**
   * 
   * @Title: updateRole
   * @Description: 更新角色
   * @param: role
   * @return
   * @throws
   */
  public void updateRole(Role role);

  /**
   * 
   * @Title: updateRoleState
   * @Description: 更新角色状态
   * @param: tempMap [id:roleId,state:角色状态]
   * @return
   * @throws
   */
  public void updateRoleState(Map<String, Object> tempMap);

  /**
   * 
   * @Title: deleteRole
   * @Description: 刪除角色
   * @param: roleId 角色ID
   * @return: void 返回类型
   * @throws
   */
  public void deleteRole(Integer roleId);

  /**
   * 
   * @Title: deleteRoles
   * @Description: 刪除角色
   * @param: roleIds 角色IDs
   * @return: void 返回类型
   * @throws
   */
  public void deleteRoles(String ids);

  /**
   * 
   * @Title: findRolesByLoginName
   * @Description: 查询role
   * @param: loginName 登录名
   * @return: Role Role对象
   * @throws
   */
  public List<Role> findRolesByLoginName(String loginName);


  /**
   * 查询所有有效角色
   * 
   * @Title: findAllRole
   * @Description: 查询所有有效角色
   * @return List<Role> 返回类型
   * @throws
   */
  public List<Role> findAllEffectiveRoles();



  /**
   * 
   * @Title: findRolesByFunctIonId
   * @Description: 根据functionId查询roleId
   * @param: functionId 功能ID
   * @return: List<Integer> 返回类型
   * @throws
   */
  public List<Integer> findRolesByFunctIonId(Integer functionId);


  /**
   * 
   * @Title: findRoleList
   * @Description: 查询所有角色
   * @param tempMap 查询条件
   * @param: pageNum 当前页
   * @param: pageSize 每页显示数量
   * @return: PageInfo<Role> 返回类型
   * @throws
   */
  public PageInfo<Role> findRoleList(Map<String, Object> tempMap, int pageNum, int pageSize);


  /**
   * 
   * @Title: findRoleById
   * @Description: 根据roleId查询角色信息
   * @param: roleId 角色ID
   * @return: List<Integer> 返回类型
   * @throws
   */
  public Role findRoleById(Integer roleId);

  

  /**
   * 
  * @Title: findRoleByRoleName
  * @Description: 根据roleName查询角色信息
  * @param @param roleName
  * @param @return
  * @return List<Role>    返回类型
  * @throws
   */
  public List<Role> findRoleByRoleName(String roleName);


}
