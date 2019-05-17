package com.energylabel.fastrecord.vo;

import java.io.Serializable;

/**
 * WEB层返回给浏览器的是JSON字符串,这个类用来包装返回结果.同时它附加了返回码,和返回信息等
 * 
 */
public class NormalVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2443611113872025513L;
  /**
   * result 1 操作结果 body {…} 提交后，需要后台返回的数据，具体格式定义在各个接口中。 cache_id xxxxx
   * 如有该参数，则该接口body部分数据可缓存，缓存时间为“cache_times”参数值。 cache_times xxxxx
   * 缓存时间，单位秒。值为-1表示长期缓存，值为0表示不缓存，其它大于零的值为具体缓存秒数。 del_cache_id […]
   * 如有该参数，则需要APP删除数组中对应的本地cache_id的内容。
   */
  private String result = "1";
  private String cache_id = "";
  private String cache_times = "0";
  private String[] del_cache_id = new String[] {};
  private Object body;

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getCache_id() {
    return cache_id;
  }

  public void setCache_id(String cache_id) {
    this.cache_id = cache_id;
  }

  public String[] getDel_cache_id() {
    return del_cache_id;
  }

  public void setDel_cache_id(String[] del_cache_id) {
    this.del_cache_id = del_cache_id;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = null == body ? "" : body;
  }

  public String getCache_times() {
    return cache_times;
  }

  public void setCache_times(String cache_times) {
    this.cache_times = cache_times;
  }
}
