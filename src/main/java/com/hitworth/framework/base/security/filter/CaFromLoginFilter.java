package com.hitworth.framework.base.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hitworth.framework.base.security.token.CaUsernamePasswordAuthenticationToken;

/**
 * CA登陆参数过滤
 * 
 * 项目名称：base_spring_framework 类名称：CustomLoginFilter 类描述： 创建人：huangxiong 创建时间：2015年2月10日 下午2:19:40
 * 修改人：huangxiong 修改时间：2015年2月10日 下午2:19:40 修改备注：
 * 
 * @version
 * 
 */
public class CaFromLoginFilter extends UsernamePasswordAuthenticationFilter {
  private String signatureParameter = "signature";
  private String plainTextParameter = "plainText";

  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {

    String signature = request.getParameter(signatureParameter);
    logger.debug(signature);
    String plainText = request.getParameter(plainTextParameter);
    logger.debug(plainText);
    String username = obtainUsername(request).toUpperCase().trim();
    String password = obtainPassword(request);
    CaUsernamePasswordAuthenticationToken authRequest =
        new CaUsernamePasswordAuthenticationToken(username, password, signature, plainText);

    setDetails(request, authRequest);
    return this.getAuthenticationManager().authenticate(authRequest);
  }



  public String getSignatureParameter() {
    return signatureParameter;
  }

  public void setSignatureParameter(String signatureParameter) {
    this.signatureParameter = signatureParameter;
  }

  public String getPlainTextParameter() {
    return plainTextParameter;
  }

  public void setPlainTextParameter(String plainTextParameter) {
    this.plainTextParameter = plainTextParameter;
  }



}
