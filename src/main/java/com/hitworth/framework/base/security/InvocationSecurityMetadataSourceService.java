package com.hitworth.framework.base.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.hitworth.framework.base.service.FunctionService;
import com.hitworth.framework.base.service.RoleService;

/**
 * 
 * 加载权限模块  项目启动后的新权限加入 项目名称：base_spring_framework 类名称：InvocationSecurityMetadataSourceService
 * 类描述： 创建人：huangx 创建时间：2015年1月28日 下午3:51:08 修改人：huangx 修改时间：2015年1月28日 下午3:51:08 修改备注：
 * 
 * @version
 * 
 */
@Service("invocationSecurityMetadataSourceService")
public class InvocationSecurityMetadataSourceService
    implements
      FilterInvocationSecurityMetadataSource {

  private static final Logger logger = Logger
      .getLogger(InvocationSecurityMetadataSourceService.class);
  @Autowired
  private RoleService roleService;
  @Autowired
  private FunctionService functionService;

  public void loadResourceDefine() throws Exception {}

  /**
 * 访问权限控制
 */
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    if (logger.isDebugEnabled()) {
      logger.debug("getAttributes(Object) - start"); //$NON-NLS-1$
    }
    HttpServletRequest request = ((FilterInvocation) object).getRequest();
    String uri = request.getServletPath().replaceAll("/+", "/");

    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();

    // 判断URI是否需要角色授权
    List<Integer> list = functionService.findEffectiveFunctionsbyAction(uri);

    for (Integer functionId : list) {
      List<Integer> roleList = roleService.findRolesByFunctIonId(functionId);
      // 如果只存在action,不存在角色，则都可以访问
      for (Integer roleId : roleList) {
        ConfigAttribute ca = new SecurityConfig(roleId.toString());
        atts.add(ca);
      }
    }
    return atts;

  }

  public boolean supports(Class<?> clazz) {
    return true;
  }

  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  public RoleService getRoleService() {
    return roleService;
  }

  public void setRoleService(RoleService roleService) {
    this.roleService = roleService;
  }

  public FunctionService getFunctionService() {
    return functionService;
  }

  public void setFunctionService(FunctionService functionService) {
    this.functionService = functionService;
  }
}
