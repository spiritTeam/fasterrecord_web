package com.hitworth.framework.base.util;


/**
 * 封装各种格式的编码解码工具类.
 * 
 * 1.Commons-Codec的hex/base64 编码
 * 3.Commons-Lang的xml/html/csv escape
 * 4.JDK提供的URLEncoder
 * 
 */
public class Encodes {

	private static final char DIGITS_LOWER[] = {
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	        'a', 'b', 'c', 'd', 'e', 'f'
	    };
	private Encodes() {
	}
	/**
	 * Hex编码.
	 */
	public static String encodeHex(byte[] input) {
		return new String(encodeHex(input,  DIGITS_LOWER ));
	}
	
	protected static char[] encodeHex(byte data[], char toDigits[])
    {
        int l = data.length;
        char out[] = new char[l << 1];
        int i = 0;
        int j = 0;
        for(; i < l; i++)
        {
            out[j++] = toDigits[(240 & data[i]) >>> 4];
            out[j++] = toDigits[15 & data[i]];
        }
        return out;
    }

	/**
	 * Hex解码.
	 */
	public static byte[] decodeHex(String input) {
		try {
			return decodeHex(input.toCharArray());
		} catch (Exception e) {
			throw new IllegalStateException("Hex Decoder exception", e);
		}
	}
	
	
	 public static byte[] decodeHex(char data[])
     throws Exception
	 {
	     int len = data.length;
	     if((len & 1) != 0)
	         throw new Exception("Odd number of characters.");
	     byte out[] = new byte[len >> 1];
	     int i = 0;
	     for(int j = 0; j < len;)
	     {
	         int f = toDigit(data[j], j) << 4;
	         j++;
	         f |= toDigit(data[j], j);
	         j++;
	         out[i] = (byte)(f & 255);
	         i++;
	     }
	
	     return out;
	 }
	 
	 protected static int toDigit(char ch, int index)
     throws Exception
	 {
	     int digit = Character.digit(ch, 16);
	     if(digit == -1)
	         throw new Exception((new StringBuilder()).append("Illegal hexadecimal character ").append(ch).append(" at index ").append(index).toString());
	     else
	         return digit;
	 }
	

	/**
	 * Base64编码.
	 * @throws Exception 
	 */
	public static String encodeBase64(byte[] input) {
		try {
			return new String(BASE64Encoder.encode(input),"UTF-8");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	/**
	 * Base64解码.
	 */
	public static byte[] decodeBase64(String input) {
		return BASE64Encoder.decode(input.getBytes());
	}

}
