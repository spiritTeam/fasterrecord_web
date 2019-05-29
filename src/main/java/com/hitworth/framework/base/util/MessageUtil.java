package com.hitworth.framework.base.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * 
 * 
 * 项目名称：base_spring_framework 类名称：MessageUtil 类描述： 文字提示工具类 创建人：Administrator 创建时间：2015年2月5日
 * 上午11:54:59 修改人：Administrator 修改时间：2015年2月5日 上午11:54:59 修改备注：
 * 
 * @version
 * 
 */
public class MessageUtil {

  private static Map<String, String> message = null;

  private static String configName = "config/properties/err_message";

  /**
   * 
  * @Title: get
  * @Description: 获取对应编号提示
  * @param @param key
  * @param @return    提示
  * @return String    返回类型
  * @throws
   */
  public static String get(String key) {
    if (message == null) load();
    return message.get(key);
  }


  /**
   * 
  * @Title: load
  * @Description: 初始化提示返回值列表
  * @return void    返回类型
  * @throws
   */
  private static void load() {
    message = new HashMap<String, String>();
    ResourceBundle resource = ResourceBundle.getBundle(configName);
    Set<String> set = resource.keySet();
    for (String str : set) {
      message.put(str, resource.getString(str) == null ? "" : resource.getString(str));
    }

  }

}
