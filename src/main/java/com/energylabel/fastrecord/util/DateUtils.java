package com.energylabel.fastrecord.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * 
 * @author ru
 * 
 */
public class DateUtils {

	public static final String Date_Format = "yyyy-MM-dd";
	public static final String DateTime_Format = "yyyy-MM-dd HH:mm:ss";

	/**
	 * @see Date_Format_yyyyMMddHHmmss
	 */
	@Deprecated
	public static final String DateString_Format = "yyyyMMddHHmmss";
	public static final String Date_Format_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String Date_Format_yyyyMMdd = "yyyyMMdd";

	/**
	 * 字符串转换为日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date getStr2Date(String date, String format)
			throws ParseException {
		if (StringUtils.isNullOrEmpty(date)) {
			return null;
		}
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.parse(date);
	}

	/**
	 * 字符串转换为日期 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getStr2Date(String date) throws ParseException {
		return getStr2Date(date, Date_Format);
	}

	/**
	 * 字符串转换为日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date getStr2DateTime(String date, String format)
			throws ParseException {
		if (StringUtils.isNullOrEmpty(date)) {
			return null;
		}
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.parse(date);
	}

	/**
	 * 字符串转换为日期 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getStr2DateTime(String date) throws ParseException {
		return getStr2DateTime(date, DateTime_Format);
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDate2Str(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(date);
	}

	/**
	 * 日期转换为字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDate2Str(Date date) {
		return getDate2Str(date, Date_Format);
	}

	/**
	 * 日期转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateTime2Str(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(date);
	}

	/**
	 * 日期转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTime2Str(Date date) {
		return getDateTime2Str(date, DateTime_Format);
	}

	/**
	 * 获取date相对的天数：负数-向前；正数-向后
	 * 
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date getDate(Date date, int num) {
		if (date == null) {
			return null;
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, num);
		return calendar.getTime();
	}

	/**
	 * 获取当前时间的整点
	 * 
	 * @param date
	 * @param n
	 *            正数：之后的n小时；负数：之前的n小时
	 * @return
	 */
	public static Date getDateAtHour(Date date, int n) {
		if (date == null) {
			return null;
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)
				+ n);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, 0);
		return calendar.getTime();
	}

	public static void main(String[] args) {
		System.out.println(StringUtils.getNonceStr());
	}
}
