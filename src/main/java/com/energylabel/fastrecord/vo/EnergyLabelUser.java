package com.energylabel.fastrecord.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * EnergyLabelUser
 * 
 * @author LiMingYi
 * @date 2019-02-21
 */
@Data
public class EnergyLabelUser implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -488349105254236772L;
  /**
   * 
   */
  private Integer fastRecordUserId;//
  private Integer energyLabeluserId;//
  
  private Integer eid;// eid
  private String ename;// ename
  private String energyLabelLoginName;
  private String fastRecordLoginName;
  private String displayName;
  private String contactPhone;
  
  private List<String> productTypeList=new ArrayList<String>();



}
