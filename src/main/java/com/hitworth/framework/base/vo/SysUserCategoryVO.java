package com.hitworth.framework.base.vo;


/**
 * SysUserCategory
 * 
 * @author LiMingYi
 * @date 2019-03-05
 */
public class SysUserCategoryVO implements java.io.Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 674790322682237484L;
  private Integer userId;
  private Integer ecModelNo;
  private String ecModelTitle;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getEcModelNo() {
    return ecModelNo;
  }

  public void setEcModelNo(Integer ecModelNo) {
    this.ecModelNo = ecModelNo;
  }

  public String getEcModelTitle() {
    return ecModelTitle;
  }

  public void setEcModelTitle(String ecModelTitle) {
    this.ecModelTitle = ecModelTitle;
  }


}
