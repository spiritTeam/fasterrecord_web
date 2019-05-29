package com.hitworth.framework.base.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 *    
 * 项目名称：base_spring_framework   
 * 类名称：JcaptchaController   
 * 类描述：   验证码
 * 创建人：huangxiong
 * 创建时间：2015年2月6日 下午1:54:16   
 * 修改人：huangxiong   
 * 修改时间：2015年2月6日 下午1:54:16   
 * 修改备注：   
 * @version    
 *
 */
@Controller
@RequestMapping("/jcaptcha")
public class JcaptchaController {

  @Autowired
  ImageCaptchaService imageCaptchaService;

  @RequestMapping(value = "/generatImage")
  public void ImageCaptcha(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    byte[] captchaChallengeAsJpeg = null;
    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
    try {
      String captchaId = request.getSession().getId();
      BufferedImage challenge =
          imageCaptchaService.getImageChallengeForID(captchaId, request.getLocale());

      // a jpeg encoder
      JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
      jpegEncoder.encode(challenge);
    } catch (IllegalArgumentException e) {} catch (CaptchaServiceException e) {} catch (ImageFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    ServletOutputStream responseOutputStream = response.getOutputStream();
    responseOutputStream.write(captchaChallengeAsJpeg);
    responseOutputStream.flush();
    responseOutputStream.close();
  }


}
