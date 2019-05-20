package com.hitworth.framework.base.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.hitworth.framework.base.vo.SecurityUser;

/**
 * User工具类
 * 
 * 项目名称：base_spring_framework 类名称：UserUtil 类描述： 创建人：Administrator 创建时间：2015年2月2日
 * 下午5:45:42 修改人：Administrator 修改时间：2015年2月2日 下午5:45:42 修改备注：
 * 
 * @version
 *
 */
public class UserUtil {

	/**
	 * 
	 * @Title: getLoginName @Description: 获取当前用户名 @param @return loginName @return
	 *         String 返回类型 @throws
	 */
	public static String getLoginName() {
//		String loginName = "beian";
		String loginName = null;
		SecurityContext springSecurityContext = SecurityContextHolder.getContext();
		if (springSecurityContext != null) {
			Object principal = springSecurityContext.getAuthentication().getPrincipal();
			if (principal instanceof SecurityUser) {
				SecurityUser securityUser = ((SecurityUser) principal);
				return securityUser.getUsername();
			}
		}
		return loginName;
	}

	public static String getUserId() {
		SecurityUser securityUser = getSecurityUser();
		if (securityUser != null) {
			return String.valueOf(securityUser.getId());
		}
		return null;
//		return "2";
	}

	/**
	 * 内存user对象 @Title: getSecurityUser @Description:
	 * 内存user对象 @param @return @return SecurityUser 返回类型 @throws
	 */
	public static SecurityUser getSecurityUser() {

		SecurityUser securityUser = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof SecurityUser) {
			securityUser = ((SecurityUser) principal);
		}
		return securityUser;
	}

	/**
	 * 获取当前角色
	 * 
	 * @param request
	 * @return
	 */
	public static int getRoleId(HttpServletRequest request) {
		int roleId = 0;
		SecurityContext springSecurityContext = (SecurityContext) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		if (springSecurityContext != null) {
			Object principal = springSecurityContext.getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				Object[] roleIdArray = ((UserDetails) principal).getAuthorities().toArray();
				roleId = Integer.valueOf(roleIdArray[0].toString());
			} else {
				principal.toString();
			}
		}
		return roleId;

	}

	public static void main(String[] args) {
		String array = "haierbx,liuyanni,hfmidea2013,hisensebx,ronshen2087,kelonlg,kinghome";
		for (String u : array.split(",")) {
			String p = u + "@2019";
			p = new Md5PasswordEncoder().encodePassword(p, u);
			System.out.println(p);
		}
	}
}
