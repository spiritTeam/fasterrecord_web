package com.hitworth.framework.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * User
 * 
 * @author LiMingYi
 * @date 2019-02-21
 */
@Data
public class User implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = -8175314140143143186L;
  private int id;
  private String loginName;// 登录名
  private String password;// 密码
  private String displayName;// 显示名称
  private String type;// 'normal','ca''账号类型，CA|普通'
  private int state;// 状态，0=冻结，1=正常
  private String loginIp;// 登陆IP
  private String bindIp;// 绑定IP
  private int ipbandFlag;// 是否绑定
  private int tryTimes;// 登陆失败的尝试次数，超过次数后session有效期内禁止登陆
  private Timestamp lastLogintime;// 最后登陆时间
  private String email;// 邮箱
  private String contactPhone;// 电话
  private Timestamp insertTime;// 插入时间

}
