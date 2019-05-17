package com.energylabel.fastrecord.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 字符串工具类    
 * 
 * @author ru
 * 
 */
public class StringUtils {

	public static final String ENCODING = "utf-8";

	/**
	 * 获取非null字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String getValue(String str) {
		if (isNullOrEmpty(str)) {
			return "";
		}
		return str;
	}

	/**
	 * 字符串是否为null或者空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取随机32位的字符串
	 * 
	 * @return String
	 */
	public static String getNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 获取日期目录
	 * 
	 * @param date
	 */
	public static String getDirByDate(String date) {
		if (isNullOrEmpty(date)) {
			return null;
		}
		return date.replace("-", "/");
	}

	/**
	 * 获取日期目录
	 * 
	 * @param date
	 */
	public static String getDirByDate(Date date) {
		return getDirByDate(DateUtils.getDate2Str(date));
	}

	/**
	 * 获取日期小时目录
	 * 
	 * @param date
	 * @return
	 */
	public static String getDirByHour(Date date) {
		String str = DateUtils.getDate2Str(date, "yyyy-MM-dd-HH");
		if (isNullOrEmpty(str)) {
			return null;
		}
		return str.replace("-", "/");
	}

	/**
	 * 获取web工程根目录
	 * 
	 * @return
	 */
	public static String getRootPath() {
		String path = StringUtils.class.getResource("/").getPath()
				.split("WEB-INF")[0];
		File file = new File(path);
		path = file.getPath();
		if (!path.endsWith(File.separator)) {
			path += File.separator;
		}
		return path;
	}

	/**
	 * 判断是否是中文字符
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isChinese(String v) {
		char[] array = v.toCharArray();
		for (char c : array) {
			if (!isChinese(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否是中文字符
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 将query字符串转换成参数Map
	 * 
	 * @param query
	 *            query字符串
	 * @param split
	 *            参数分隔符
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> convertQuery2Map(String query,
			String split) throws UnsupportedEncodingException {
		if (StringUtils.isNullOrEmpty(query)) {
			return null;
		}
		String s = "=";
		String[] paramArray = query.split(split);
		Map<String, String> map = new HashMap<String, String>(paramArray.length);
		String[] array = null;
		for (String param : paramArray) {
			if (!StringUtils.isNullOrEmpty(param) && param.contains(s)) {
				array = param.split(s);
				if (array.length == 2) {
					map.put(decodePostParam(array[0]),
							decodePostParam(array[1]));
				}
			}
		}
		return map;
	}

	private static String decodePostParam(String str)
			throws UnsupportedEncodingException {
		if (StringUtils.isNullOrEmpty(str)) {
			return null;
		}
		return URLDecoder.decode(str, ENCODING);
	}
	
	   /** 
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
  
    /** 
     * 香港手机号码8位数，5|6|8|9开头+7位任意数 
     */  
    public static boolean isHKPhoneLegal(String str)throws PatternSyntaxException {  
        String regExp = "^(5|6|8|9)\\d{7}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    } 
}
