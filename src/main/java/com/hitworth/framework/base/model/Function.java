package com.hitworth.framework.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * Function
 * 
 * @author LiMingYi
 * @date 2019-02-21
 */
@Data
public class Function implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 7097052611980149285L;
  private int id;
  private int parentId;// 父Id
  private int type;// 类型，0=访问请求（不展示只做权限校验），1=菜单（前端展示）
  private int desc;// 排序
  private int state;// 状态，0=冻结，1=正常
  private Timestamp insertTime;// 插入时间

  // 前端框架基本属性
  private String title;// 功能名称
  private String path;// vue-前端路由
  private String name;// vue-前端路由
  private String redirect;// vue-前端重定向
  private String component;// vue-前端页面项目目录
  // 前端框架Meta属性
  private boolean hideInMenu;// vue-菜单是否可直接点击 true=有子菜单，下拉展示，false=无子菜单,直接响应
  private boolean notCache;// vue-前端缓存
  private String icon;// 图标

}
