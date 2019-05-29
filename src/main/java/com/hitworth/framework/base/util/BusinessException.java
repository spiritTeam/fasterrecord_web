package com.hitworth.framework.base.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 
 * 项目名称：base_spring_framework 类名称：BusinessException 类描述： 自定义异常 创建人：Administrator 创建时间：2015年2月5日
 * 上午11:48:55 修改人：Administrator 修改时间：2015年2月5日 上午11:48:55 修改备注：
 * 
 * @version
 * 
 */
public class BusinessException extends RuntimeException {

  /**
   * @Fields serialVersionUID
   */
  private static final long serialVersionUID = 1L;
  private String err = "";

  public String getErr() {
    return err;
  }

  public BusinessException(int err) {

    this.err = (StringUtils.isNotBlank(MessageUtil.get(err+"")))?MessageUtil.get(err+"" ):err+"";
  }
  public BusinessException(String message){
    this.err = message;
  };
  @Override
  public Throwable fillInStackTrace() {
               return this;
  }

}
