package com.hitworth.framework.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * Role
 * 
 * @author LiMingYi
 * @date 2019-02-21
 */
@Data
public class Role implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1827005474599869942L;
  private Integer id;
  private String roleName;// 角色名称
  private Integer state;// 状态，0=冻结，1=正常
  private Timestamp insertTime;// 插入时间

}
