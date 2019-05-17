package com.hitworth.framework.base.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hitworth.framework.base.model.Role;
import com.hitworth.framework.base.model.User;
import com.hitworth.framework.base.service.RoleService;
import com.hitworth.framework.base.service.UserService;
import com.hitworth.framework.base.util.ConstantUtil;
import com.hitworth.framework.base.vo.SecurityUser;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

  @Autowired
  UserService userService;
  @Autowired
  RoleService roleService;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException,
      DataAccessException {
    logger.info("loadUserByUsername");

    // 加载user
    User user = userService.findUserByLoginName(userName);

    if (user == null) return null;


    Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
    // 加载角色列表
    List<Role> roleList = roleService.findRolesByLoginName(userName);

    for (Role role : roleList) {
      auths.add(new SimpleGrantedAuthority(role.getId().toString()));
    }

    // 冻结账户处理
    boolean enabled = (user.getState() == ConstantUtil.OK) ? true : false;

    UserDetails userDetails =
        new SecurityUser(user.getId(),user.getType(), user.getEmail(), user.getContactPhone(),
            user.getDisplayName(), user.getLoginName(), user.getPassword(), enabled, true, true,
            true, auths);

    return userDetails;
  }
}
