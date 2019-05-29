package com.hitworth.framework.base.util;

import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HmacUtil {

  private static String HMACSHA1 = "HmacSHA1";

  /**
   * 使用HMAC-SHA1进行消息签名, 返回字节数组,长度为20字节.
   * 
   * @param input 原始输入字符数组
   * @param key HMAC-SHA1密钥
   */
  public static byte[] hmacSha1(byte[] input, byte[] key) {
    try {
      SecretKey secretKey = new SecretKeySpec(key, HMACSHA1);
      Mac mac = Mac.getInstance(HMACSHA1);
      mac.init(secretKey);
      return mac.doFinal(input);
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

/*  public static void main(String[] args) throws UnsupportedEncodingException {
    Arrays.equals( HmacUtil.hmacSha1("test444444444".getBytes(), "111".getBytes()), Encodes.decodeBase64(abc))  
  }*/

}
