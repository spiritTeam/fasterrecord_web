package com.hitworth.framework.base.vo;

import java.io.Serializable;

/**
 * 工程：base_spring_framework
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/11
 * 说明：
 */
public class TreeNodeVO implements Serializable {
    public TreeNodeVO(){

    }
    public TreeNodeVO(int id, int pId, String name, boolean checked) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.checked = checked;
    }
    private int id;
    private int pId;
    private String name;
    private boolean checked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCheced(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked(){
        return checked;
    }
}
