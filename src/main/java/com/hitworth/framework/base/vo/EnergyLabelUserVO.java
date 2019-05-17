package com.hitworth.framework.base.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * EnergyLabelUser
 * 
 * @author LiMingYi
 * @date 2019-03-05
 */
public class EnergyLabelUserVO implements Serializable {



  /**
   * 
   */
  private static final long serialVersionUID = -1066579053853240233L;

  private Integer energyLabeluserId;//

  private Integer eid;// eid
  private String ename;// ename
  private String energyLabelLoginName;
  private String fastRecordLoginName;

  private List<SysUserCategoryVO> sysUserCategoryList=new ArrayList<SysUserCategoryVO>();

  public Integer getEnergyLabeluserId() {
    return energyLabeluserId;
  }

  public void setEnergyLabeluserId(Integer energyLabeluserId) {
    this.energyLabeluserId = energyLabeluserId;
  }

  public Integer getEid() {
    return eid;
  }

  public void setEid(Integer eid) {
    this.eid = eid;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getEnergyLabelLoginName() {
    return energyLabelLoginName;
  }

  public void setEnergyLabelLoginName(String energyLabelLoginName) {
    this.energyLabelLoginName = energyLabelLoginName;
  }

  public List<SysUserCategoryVO> getSysUserCategoryList() {
    return sysUserCategoryList;
  }

  public void setSysUserCategoryList(List<SysUserCategoryVO> sysUserCategoryList) {
    this.sysUserCategoryList = sysUserCategoryList;
  }

  public String getFastRecordLoginName() {
    return fastRecordLoginName;
  }

  public void setFastRecordLoginName(String fastRecordLoginName) {
    this.fastRecordLoginName = fastRecordLoginName;
  }

}
