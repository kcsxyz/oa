package com.oa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class timeConvert {
	 private static Calendar calendar = Calendar.getInstance();
	
	    public static String DateToSTr(Date date)
	    {
	        SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String format = aDate.format(date);
	        return format;
	    }

	    public static Date StrToDate(String date)
	    {
	        SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date parse = null;
	        try
	        {
	            parse = aDate.parse(date);
	        }
	        catch (ParseException e)
	        {
	           
	        }
	        return parse;
	    }
	    /**
	     * 转换为年月日字符窜
	     */
	    public static String DateToSTr2(Date date)
	    {
	        SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd");
	        String format = aDate.format(date);
	        return format;
	    }
	
	//yyyy-MM-dd HH:mm:ss字符串分成年月日三段
	public static String timeToYear(String time) {
		String year = time.substring(0, 4);
		return year;
	}

	public static String timeToMonth(String time) {
		String month = time.substring(5, 7);
		return month;
	}

	//
	public static String timeToDay(String time) {
		String day = time.substring(8, 10);
		return day;
	}

	public static String getStringSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "0000-00-00";
		}

	}

	public static String yearAndMonth() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "0000-00";
		}

	}

	public static String getDay_Of_Week(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String week = sdf.format(date);
		return week;
	}

	public static String getWeek_Of_Month(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("W");
		String week = sdf.format(date);
		return week;
	}

	public static Date getDateSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return secondDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public static Date getDate(String timeStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			
			return formatter.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public static String getStringDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Date getDateDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return secondDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getTimeStamp() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "00000000";
		}
	}

	public static String getUuid() {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		return s;
	}
	
	 /**
     * 获取 时 分 秒 字符窜
     */
    public static String getTimeShort(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(date);

        return dateString.equals("00:00:00") ? "12:00:00" : dateString;
    }
    

    /**
     * 计算时间戳的时间差
     *
     * @param start 减数
     * @param end 被减数
     *
     * @return 分钟
     */
    public static long getTimeRang(long start, long end)
    {

        long l = (end - start) / (1000 * 60);
        return l;
    }
    
    /**
     * 获取周几
     */
    public static String getTodayWeek()
    {
        //获取当前时间
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        if (week < 0)
        {
            week = 7;
        }
        return weekToStr(week);
    }


    public static String weekToStr(int week)
    {
        String w = "";
        switch (week)
        {
            case 7:
                w = "日";
                break;
            case 6:
                w = "六";
                break;
            case 5:
                w = "五";
                break;
            case 4:
                w = "四";
                break;
            case 3:
                w = "三";
                break;
            case 2:
                w = "二";
                break;
            case 1:
                w = "一";
                break;
            default:
                w = "";
                break;
        }
        return w;
    }
    
    /**
     * 获取上一个月
     *
     * @param date 当前日期的上一个月
     */
    public static Date getPreMoth(Date date)
    {
        //获取上个月日期
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date pre = c.getTime();
        return pre;
    }
    
    /**
     * 获取个月的第一天
     */
    public static Date getFirstDayDateOfMonth(final Date date)
    {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }
    /**
     * 获取月的最后一天
     */
    public static Date getLastDayOfMonth(final Date date)
    {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }
    
    /**
     * 截取字符串
     * 
     * @param str 字符串
     * @param start 开始
     * @param end 结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end)
    {
        if (str == null)
        {
            return "";
        }

        if (end < 0)
        {
            end = str.length() + end;
        }
        if (start < 0)
        {
            start = str.length() + start;
        }

        if (end > str.length())
        {
            end = str.length();
        }

        if (start > end)
        {
            return "";
        }

        if (start < 0)
        {
            start = 0;
        }
        if (end < 0)
        {
            end = 0;
        }

        return str.substring(start, end);
    }
}
