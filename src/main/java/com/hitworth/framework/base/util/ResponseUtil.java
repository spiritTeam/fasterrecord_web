package com.hitworth.framework.base.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *    
 * 项目名称：base_spring_framework   
 * 类名称：ResponseUtil   
 * 类描述：   封装result返回
 * 创建人：huangxiong
 * 创建时间：2015年2月6日 下午1:44:23   
 * 修改人：huangxiong   
 * 修改时间：2015年2月6日 下午1:44:23   
 * 修改备注：   
 * @version    
 *
 */
public class ResponseUtil {

  public static <T> Map<String, Object> success() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("result", true);
    return map;
  }
  
  public static <T> Map<String, Object> success(String message) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("result", true);
    map.put("msg", message);
    return map;
  }

  public static <T> Map<String, Object> fail(String message) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("result", false);
    map.put("msg", message);
    return map;
  }

  public static <T> Map<String, Object> success(T o) {
    Map<String, Object> map = new HashMap<>();
    map.put("result", true);
    map.put("msg", o);
    return map;
  }
}
