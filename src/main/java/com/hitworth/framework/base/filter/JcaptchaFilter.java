package com.hitworth.framework.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hitworth.framework.base.util.MessageUtil;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;

public class JcaptchaFilter implements Filter {

  ImageCaptchaService imageCaptchaService;
  private String loginTime = "loginTime";// 登陆次数
  private String jcaptcha = "jcaptcha";// 验证码提示
  private String callback = "callback";// 过滤器回调地址
  private String captchaValue = "captcha_value";// 验证码value


  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
      throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    HttpSession session = req.getSession();
    
    initService(session);

    // 三次免验证码登陆
    if (session.getAttribute(loginTime) == null) session.setAttribute(loginTime, 0);
    int loginTimes = (int) session.getAttribute(loginTime) + 1;
    session.setAttribute(loginTime, loginTimes);
    if (loginTimes <= 3) {
      filterchain.doFilter(request, response);
      return;
    }

   //验证码检查
    Boolean isResponseCorrect = Boolean.FALSE;
    String captcha_value = request.getParameter(captchaValue);
    String filterCallback = request.getParameter(callback);
    if (StringUtils.isEmpty(captcha_value)) {
      req.getSession().setAttribute(jcaptcha, MessageUtil.get(String.valueOf(10008)));
      resp.sendRedirect(filterCallback);
      return;
    }

    try {
      isResponseCorrect = imageCaptchaService.validateResponseForID(session.getId(), captcha_value);
    } catch (CaptchaServiceException e) {

    }

    if (!isResponseCorrect.booleanValue()) {
      req.getSession().setAttribute(jcaptcha, MessageUtil.get(String.valueOf(10009)));
      resp.sendRedirect(filterCallback);
      return;
    }
    req.getSession().setAttribute(jcaptcha, "");

    filterchain.doFilter(request, response);
  }

  
  /**
   * 基于session初始化service
  * @Title: initService
  * @Description: 基于session初始化service
  * @param @param session
  * @return void    返回类型
  * @throws
   */
  private void initService(HttpSession session) {
    //初始化验证码实现类
    if (imageCaptchaService == null) {

      ApplicationContext context =
          WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());

      imageCaptchaService = (ImageCaptchaService) context.getBean("imageCaptchaService");
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {


  }

}
