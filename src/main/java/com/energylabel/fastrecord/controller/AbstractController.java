package com.energylabel.fastrecord.controller;

import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.energylabel.fastrecord.exception.APIErrorEnum;
import com.energylabel.fastrecord.util.StringUtils;
import com.energylabel.fastrecord.vo.ErrorVO;
import com.energylabel.fastrecord.vo.NormalVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hitworth.framework.base.util.UserUtil;

/**
 * 基础Controller，封装基本返回对象
 */
@SuppressWarnings("restriction")
public abstract class AbstractController {

  private Logger logger = LoggerFactory.getLogger(AbstractController.class);

  protected final String Result_Code_Fail = "0";
  protected final String Result_Code_Success = "1";

  protected NormalVO success(Object obj) {
    return success(obj, new String[0]);
  }

  protected NormalVO success(Object obj, String[] delCacheIds) {
    NormalVO rr = new NormalVO();
    rr.setBody(obj);
    rr.setDel_cache_id(delCacheIds);
    return rr;
  }

  protected NormalVO success(Object obj, long cacheTimes) {
    NormalVO rr = new NormalVO();
    rr.setBody(obj);
    rr.setCache_times(cacheTimes + "");
    return rr;
  }

  protected NormalVO success(Object obj, String cache_id, String[] del_cache_id) {
    NormalVO rr = new NormalVO();
    rr.setBody(obj);
    rr.setBody(obj);
    rr.setCache_id(cache_id);
    rr.setDel_cache_id(del_cache_id);
    return rr;
  }

  protected NormalVO success(Object obj, String cache_id, String cache_times,
      String[] del_cache_id) {
    NormalVO rr = new NormalVO();
    rr.setBody(obj);
    rr.setBody(obj);
    rr.setCache_id(cache_id);
    rr.setCache_times(cache_times);
    rr.setDel_cache_id(del_cache_id);
    return rr;
  }

  protected ErrorVO error(String err_code, String err_msg) {
    ErrorVO rr = new ErrorVO(err_code, err_msg);
    return rr;
  }

  protected ErrorVO error(APIErrorEnum error) {
    ErrorVO rr = new ErrorVO(error.getCode(), error.getDesc());
    return rr;
  }

  /**
   * 统一处理，封装请求参数为map
   *
   * @param request
   * @return
   */
  protected Map<String, Object> getParamMap(HttpServletRequest request) {

    Map<String, Object> paramMap = new HashMap<String, Object>();
    Enumeration<String> paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements()) {
      String key = (String) paramNames.nextElement();
      paramMap.put(key, request.getParameter(key));
    }
    return paramMap;
  }

  /**
   * 统一处理，从req中取出封装请求参数为map
   *
   * @param request
   * @return
   */
  public Map<String, Object> getReqMap(HttpServletRequest request) {
    Map<String, String[]> map = (Map<String, String[]>) request.getParameterMap();
    Map<String, Object> res = new HashMap<String, Object>();
    for (String key : map.keySet()) {
      res.put(key, map.get(key)[0]);
    }
    return res;
  }

  /**
   * 将json转为map
   *
   * @param jsonstr
   * @return
   */
  public Map<String, Object> parseJSON2Map(String jsonstr) {
    Map<String, Object> map = new HashMap<String, Object>();
    // 最外层解析
    JSONObject json = JSONObject.parseObject(jsonstr);
    for (Object k : json.keySet()) {
      Object v = json.get(k);
      // 如果内层还是数组的话，继续解析
      if (v instanceof JSONArray) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Iterator<Object> it = ((JSONArray) v).iterator();
        while (it.hasNext()) {
          JSONObject json2 = (JSONObject) it.next();
          list.add(parseJSON2Map(json2.toString()));
        }
        map.put(k.toString(), list);
      } else {
        map.put(k.toString(), v);
      }
    }
    return map;
  }

  /**
   * jsonp调用处理
   * 
   * @param object
   * @param req
   * @return
   */
  protected Object jsonp(Object object, HttpServletRequest req) {
    String callback = req.getParameter("callback");// jsonp调用
    if (!StringUtils.isNullOrEmpty(callback)) {
      return new JSONPObject(callback, object);
    }
    return object;
  }

  /**
   * 解码
   * 
   * @param s
   * @return
   * @throws UnsupportedEncodingException
   */
  protected String decode(String s) throws UnsupportedEncodingException {
    if (StringUtils.isNullOrEmpty(s)) {
      return null;
    }
    return URLDecoder.decode(s, "UTF-8");
  }

  /**
   * 获取备案用户id
   * 
   * @return
   */
  protected String getUserId() {
    return "" + UserUtil.getUserId();
  }


  /**
   * 验证mns的合法性
   * 
   * @param request
   * @return
   */
  protected boolean verify(HttpServletRequest request) {
    String certUrl = request.getHeader("x-mns-signing-cert-url");

    if (null == certUrl) {
      logger.error("SigningCerURL Header not found!");
      return false;
    }

    if (certUrl.isEmpty()) {
      logger.error("SigningCertURL empty!");
      return false;
    }

    certUrl = new String(Base64.decodeBase64(certUrl));
    logger.info("SigningCertURL:" + certUrl);

    Enumeration<String> headerNames = request.getHeaderNames();
    Map<String, String> hm = new HashMap<>(0);
    String headerName;
    logger.info("Header:");
    while (headerNames.hasMoreElements()) {
      headerName = headerNames.nextElement();
      hm.put(headerName, request.getHeader(headerName));
      logger.info("\t" + headerName + " : " + request.getHeader(headerName));
    }

    return authenticate(request.getMethod(), request.getRequestURI(), hm, certUrl);
  }

  protected boolean authenticate(String method, String uri, Map<String, String> headers,
      String cert) {
    boolean result;
    String str2sign = getSignStr(method, uri, headers);
    logger.info("[local sign : " + str2sign + "]");
    String signature = headers.get("authorization");
    byte[] decodedSign = Base64.decodeBase64(signature);
    // get cert, and verify this request with this cert
    try {
      URL url = new URL(cert);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      DataInputStream in = new DataInputStream(conn.getInputStream());
      CertificateFactory cf = CertificateFactory.getInstance("X.509");

      Certificate c = cf.generateCertificate(in);
      PublicKey pk = c.getPublicKey();

      java.security.Signature signetcheck = java.security.Signature.getInstance("SHA1withRSA");
      signetcheck.initVerify(pk);
      signetcheck.update(str2sign.getBytes());
      result = signetcheck.verify(decodedSign);
    } catch (Exception e) {
      e.printStackTrace();
      logger.warn("authenticate fail, " + e.getMessage());
      return false;
    }

    return result;
  }

  private String getSignStr(String method, String uri, Map<String, String> headers) {
    StringBuilder sb = new StringBuilder();
    sb.append(method);
    sb.append("\n");
    sb.append(safeGetHeader(headers, "content-md5"));
    sb.append("\n");
    sb.append(safeGetHeader(headers, "content-type"));
    sb.append("\n");
    sb.append(safeGetHeader(headers, "date"));
    sb.append("\n");

    List<String> tmp = new ArrayList<>();
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      if (entry.getKey().startsWith("x-mns-")) {
        tmp.add(entry.getKey() + ":" + entry.getValue());
      }
    }
    Collections.sort(tmp);

    for (String kv : tmp) {
      sb.append(kv);
      sb.append("\n");
    }

    sb.append(uri);
    return sb.toString();
  }

  private String safeGetHeader(Map<String, String> headers, String name) {
    if (headers.containsKey(name)) {
      return headers.get(name);
    }
    return "";
  }
  
  protected String paserMessage(String body) {
    try {
        logger.info("body : " + body);
        JSONObject o = JSONObject.parseObject(body);
        String message = o.getString("Message");
        logger.info("message : " + message);
        logger.info("decode message : " + new String(Base64.decodeBase64(message)));
        return new String(Base64.decodeBase64(message));
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
}
