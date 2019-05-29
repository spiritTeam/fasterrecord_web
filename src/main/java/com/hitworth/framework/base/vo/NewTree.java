package com.hitworth.framework.base.vo;

import java.util.ArrayList;
import java.util.List;

public class NewTree {

  private Integer id;//树ID
  private String title;//树节点名称
  private boolean expand=false;//是否展开
  private List<NewTree> children = new ArrayList<NewTree>();//子节点
  private boolean checked=false;//是否勾选(如果勾选，子节点也会全部勾选)	Boolean	false
  private boolean selected=false;//是否选中子节点	Boolean	false

/*
属性	说明	类型	默认值
title	标题	String | Element String	-
expand	是否展开直子节点	Boolean	false
disabled	禁掉响应	Boolean	false
disableCheckbox	禁掉 checkbox	Boolean	false
selected	是否选中子节点	Boolean	false
checked	是否勾选(如果勾选，子节点也会全部勾选)	Boolean	false
children	子节点属性数组	Array
*/

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isExpand() {
    return expand;
  }

  public void setExpand(boolean expand) {
    this.expand = expand;
  }

  public List<NewTree> getChildren() {
    return children;
  }

  public void setChildren(List<NewTree> children) {
    this.children = children;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }
}
