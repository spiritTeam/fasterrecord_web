package com.hitworth.framework.base.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * 
 * 
 * 项目名称：base_spring_framework 类名称：MailUtil 类描述： 邮件工具类 创建人：huangxiong 创建时间：2015年3月6日 下午9:03:36
 * 修改人：huangxiong 修改时间：2015年3月6日 下午9:03:36 修改备注：
 * 
 * @version
 * 
 */
public class MailUtil {


  private static String SMTP_SERVER = ConfigUtil.getConfigContent("config/properties/mail",
      "smtpServer");
  private static int SMTP_SERVER_PORT = Integer.valueOf(ConfigUtil.getConfigContent(
      "config/properties/mail", "smtpServerPort"));
  private static String USER_NAME = ConfigUtil.getConfigContent("config/properties/mail",
      "userName");
  private static String PASSWORD = ConfigUtil
      .getConfigContent("config/properties/mail", "password");
  private static String FROM_MAIL_DISPALY = ConfigUtil.getConfigContent("config/properties/mail",
      "fromMailDisplay");
  private static String FROM_MAIL = ConfigUtil.getConfigContent("config/properties/mail",
      "fromMail");
  private static String TYPE = ConfigUtil.getConfigContent("config/properties/mail", "type");
  private static String TITLE = ConfigUtil.getConfigContent("config/properties/mail", "title");



  public static void sendMail(String mailAddress, String content) {
    Properties properties = new Properties();
    properties.setProperty("mail.transport.protocol", "smtp");// 发送邮件协议
    properties.setProperty("mail.smtp.auth", "true");// 需要验证
    Session session = Session.getInstance(properties);
    session.setDebug(false);// debug模式
    // 邮件信息
    Message messgae = new MimeMessage(session);
    try {
      messgae.setFrom(new InternetAddress(FROM_MAIL, FROM_MAIL_DISPALY));// 设置发送人
      messgae.setSubject(TITLE);// 设置邮件主题
      messgae.setContent(content, TYPE);// 设置邮件内容
      // 发送邮件
      Transport tran = session.getTransport();
      tran.connect(SMTP_SERVER, SMTP_SERVER_PORT, USER_NAME, PASSWORD);// 连接到新浪邮箱服务器
      tran.sendMessage(messgae, new Address[] {new InternetAddress(mailAddress)});// 设置邮件接收人
      tran.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new BusinessException(10127);
    }
  }

}
