package com.hitworth.framework.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.dao.RoleDAO;
import com.hitworth.framework.base.model.Role;
import com.hitworth.framework.base.service.RoleService;
import com.hitworth.framework.base.util.BusinessException;
import com.hitworth.framework.base.util.ConstantUtil;


/**
 * role serviceImpl
 * 
 * 项目名称：base_spring_framework 类名称：RoleServiceImpl 类描述： 创建人：huangx 创建时间：2015年1月27日 下午7:17:30
 * 修改人：huangx 修改时间：2015年1月27日 下午7:17:30 修改备注：
 * 
 * @version
 * 
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleDAO roleDAO;

  @Override
  public void validate(Role role) {

    if (StringUtils.isEmpty(role.getRoleName())) throw new BusinessException(10111);
    if (StringUtils.isEmpty(role.getState())) throw new BusinessException(10112);

    if(ConstantUtil.OK!=role.getState().intValue()&&ConstantUtil.FAIL!=role.getState().intValue())
      throw new BusinessException(10124);
  }

  @Override
  public void init(Role role) {}

  @Override
  public void insertRole(Role role) {
    validate(role);
    if (findRoleByRoleName(role.getRoleName()).size() > 0) throw new BusinessException(10121);
    init(role);
    roleDAO.insertRole(role);
  }

  @Override
  public void updateRole(Role role) {
    validate(role);
    init(role);
    roleDAO.updateRole(role);
  }

  @Override
  public void updateRoleState(Map<String, Object> tempMap) {
    roleDAO.updateRoleState(tempMap);
  }

  @Override
  public void deleteRole(Integer roleId) {
    roleDAO.deleteFunctionRole(roleId);
    roleDAO.deleteRole(roleId);
  }

  @Override
  public void deleteRoles(String ids) {

    String[] roleIds = ids.split(",");
    for (String roleId : roleIds) {
      roleDAO.deleteFunctionRole(Integer.valueOf(roleId));
      roleDAO.deleteRole(Integer.valueOf(roleId));
    }

  }

  @Override
  public List<Role> findRolesByLoginName(String loginName) {

    return roleDAO.findRolesByLoginName(loginName);

  }

  @Override
  public List<Role> findAllEffectiveRoles() {

    List<Role> list = roleDAO.findAllEffectiveRoles();

    return list;
  }

  @Override
  public List<Integer> findRolesByFunctIonId(Integer functionId) {
    return roleDAO.findRolesByFunctIonId(functionId);
  }

  @Override
  public PageInfo<Role> findRoleList(Map<String, Object> tempMap, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Role> list = roleDAO.findRoleList(tempMap);
    PageInfo<Role> page = new PageInfo<Role>(list);
    return page;
  }

  @Override
  public Role findRoleById(Integer roleId) {
    Role role = roleDAO.findRoleById(roleId);
    return role;
  }

  @Override
  public List<Role> findRoleByRoleName(String roleName) {
    List<Role> roleList = roleDAO.findRoleByRoleName(roleName);
    return roleList;
  }



}
