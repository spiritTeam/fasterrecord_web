package com.hitworth.framework.base.vo;

import java.util.Deque;
import java.util.LinkedList;

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
public class Menus {

  // 前端框架基本属性
  private String path;// vue-前端路由
  private String name;// vue-前端路由
  private String redirect;// vue-前端重定向
  private String component;// vue-前端页面项目目录
  
  private Meta meta;

  private Deque<Menus> children;

  public Menus(Function function) {
    this.path=function.getPath();
    this.name=function.getName();
    this.redirect=function.getRedirect();
    this.component=function.getComponent();
    this.meta=new Meta(function);
    this.children=new LinkedList<Menus>();
  }
}
