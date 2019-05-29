package com.hitworth.framework.base.vo;

import com.hitworth.framework.base.model.Function;

import lombok.Data;

/**
 * 
 * 
 * 项目名称：base_spring_framework 类名称：Menus 类描述： function用户菜单Vo 创建人：Administrator 创建时间：2015年2月6日
 * 下午1:26:02 修改人：Administrator 修改时间：2015年2月6日 下午1:26:02 修改备注：
 * 
 * @version
 *
 */
@Data
public class Meta {

  // 前端框架Meta属性
  private String title;// 功能名称
  private boolean hideInMenu;// vue-菜单是否可直接点击 true=有子菜单，下拉展示，false=无子菜单,直接响应
  private boolean notCache;// vue-前端缓存
  private String icon;// 图标


  public Meta(Function function) {
    this.title=function.getTitle();
    this.hideInMenu=function.isHideInMenu();
    this.notCache=function.isNotCache();
    this.icon=function.getIcon();
  }
}
