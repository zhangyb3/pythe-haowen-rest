package com.pythe.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 * 
 * @author Administrator
 *
 */
public class DateUtils {

	public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat TIME_FORMAT_ = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat DATEKEY_FORMAT = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("MMddHHmmss");

	/**
	 * 判断一个时间是否在另一个时间之前
	 * 
	 * @param time1
	 *            第一个时间
	 * @param time2
	 *            第二个时间
	 * @return 判断结果
	 */
	public static boolean before(String time1, String time2) {
		try {
			Date dateTime1 = TIME_FORMAT.parse(time1);
			Date dateTime2 = TIME_FORMAT.parse(time2);

			if (dateTime1.before(dateTime2)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 判断一个时间是否在另一个时间之后
	 * 
	 * @param time1
	 *            第一个时间
	 * @param time2
	 *            第二个时间
	 * @return 判断结果
	 */
	public static boolean after(String time1, String time2) {
		try {
			Date dateTime1 = TIME_FORMAT.parse(time1);
			Date dateTime2 = TIME_FORMAT.parse(time2);

			if (dateTime1.after(dateTime2)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 计算时间差值（单位为秒）
	 * 
	 * @param time1
	 *            时间1
	 * @param time2
	 *            时间2
	 * @return 差值
	 */
	public static int minus(String time1, String time2) {
		try {
			Date datetime1 = TIME_FORMAT.parse(time1);
			Date datetime2 = TIME_FORMAT.parse(time2);

			long millisecond = datetime1.getTime() - datetime2.getTime();

			return Integer.valueOf(String.valueOf(millisecond / 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 计算时间差值（单位为秒）
	 * 
	 * @param time1
	 *            时间1
	 * @param time2
	 *            时间2 time1>time2
	 * @return 天：时：分：秒
	 * 
	 */
	public static String getTimeDefference(String time1, String time2) throws ParseException {
		
		if (before(time1, time2)) {
			return null;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date datetime1 = TIME_FORMAT.parse(time1);
		Date datetime2 = TIME_FORMAT.parse(time2);
		
		//System.out.println(new Timestamp(System.currentTimeMillis()));

		long l = datetime1.getTime() - datetime2.getTime();

		long day = l / (24 * 60 * 60 * 1000);

		long hour = (l / (60 * 60 * 1000) - day * 24);

		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);

		long second = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

		// System.out.println(""+day+"天"+hour+"小时"+min+"分"+second+"秒");

		String d = String.valueOf(day);
		String h = String.valueOf(hour);
		String m = String.valueOf(min);
		String s = String.valueOf(second);

		if (day < 10)
			d = "0" + day;
		if (hour < 10)
			h = "0" + hour;
		if (min < 10)
			m = "0" + min;
		if (second < 10)
			s = "0" + second;
	
		return (d + ":" + h + ":" + m + ":" + s);
	}

	/**
	 * 获取年月日和小时
	 * 
	 * @param datetime
	 *            时间（yyyy-MM-dd HH:mm:ss）
	 * @return 结果
	 */
	public static String getDateHour(String datetime) {
		String date = datetime.split(" ")[0];
		String hourMinuteSecond = datetime.split(" ")[1];
		String hour = hourMinuteSecond.split(":")[0];
		return date + "_" + hour;
	}

	/**
	 * 获取当天日期（yyyy-MM-dd）
	 * 
	 * @return 当天日期
	 */
	public static String getTodayDate() {
		return DATE_FORMAT.format(new Date());
	}

	/**
	 * 获取昨天的日期（yyyy-MM-dd）
	 * 
	 * @return 昨天的日期
	 */
	public static String getYesterdayDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, -1);

		Date date = cal.getTime();

		return DATE_FORMAT.format(date);
	}

	/**
	 * 格式化日期（yyyy-MM-dd）
	 * 
	 * @param date
	 *            Date对象
	 * @return 格式化后的日期
	 */
	public static String formatDate(Date date) {
		return DATE_FORMAT.format(date);
	}

	/**
	 * 格式化时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param date
	 *            Date对象
	 * @return 格式化后的时间
	 */
	public static String formatTime(Date date) {
		return TIME_FORMAT.format(date);
	}
	
	/**
	 * 格式化时间（yyyyMMddHHmmss）
	 * 
	 * @param date
	 *            Date对象
	 * @return 格式化后的时间
	 */
	public static String formatTimeByNumber(Date date) {
		return TIME_FORMAT_.format(date);
	}
	

	/**
	 * 解析时间字符串
	 * 
	 * @param time
	 *            时间字符串
	 * @return Date
	 */
	public static Date parseTime(String time) {
		try {
			return TIME_FORMAT.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化日期key
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateKey(Date date) {
		return DATEKEY_FORMAT.format(date);
	}
	
	/**
	 * 格式化日期key
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTimeStampKey(Date date) {
		return TIMESTAMP_FORMAT.format(date);
	}

	/**
	 * 解析时间字符串
	 * 
	 * @param string
	 * @return Date
	 */
	public static Date parseDateKey(String date) {
		// TODO Auto-generated method stub
		try {
			return DATEKEY_FORMAT.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化时间，保留分钟级别
	 * 
	 * @param date
	 *            Unix timestamp
	 * @return string yyyyMMddHHmm
	 */
	public static String formatTimeMinute(Date date) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMM");
		return simpleDateFormat.format(date);
	}
}