package com.oa.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.oa.bean.Attend;
import com.oa.bean.WorkTime;

public class WorkTimeUtils {

    /**
     * 获取早上班时间
     */
    public static long MorWorkStartTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getWorkMorStartTime()));
    }

    /**
     * 早上下班时间
     */
    public static long MorWorkEndTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getWorkMorEndTime()));
    }


    /**
     * 早上打卡开始时间
     */
    public static long attendStartMorTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendMorStartTime()));
    }

    /**
     * 早上打卡结束时间
     */
    public static long attendEndMorTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendMorEndTime()));
    }

    /**
     * 早上下班打卡开始时间
     */
    public static long leaveMorStartTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendMorLeaveStartTime()));
    }


    /**
     * 早上下班打卡时间
     */
    public static long leaveMorEnddate(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendMorLeaveEndTime()));
    }


    /**
     * 下午上班打卡开始时间
     */
    public static long attendAfterNoonStatrTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendAfternoonStartTime()));
    }

    /**
     * 下午上班打卡结束时间
     */
    public static long attendAfterNoonEndTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendAfternoonEndTime()));
    }


    /**
     * 下午上班时间
     */
    public static long AfterNoonStarWorkTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getWorkMorStartTime()));

    }

    /**
     * 下午上班 结束时间
     */
    public static long AfterNonEndWorkTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getWorkEndTimeAfternoon()));
    }


    /**
     * 下午下班结束开始打卡时间
     */
    public static long AttendAfterNoonLeaveStartTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendAfterLeaveStartTime()));
    }

    /**
     * 下午下班班结结束打卡时间
     */
    public static long AttendAfterNoonLeaveEndTime(Date date, WorkTime workTime)
    {
        return dateFormat(date, timeConvert.getTimeShort(workTime.getAttendAfterLeaveEndTime()));
    }


    /**
     * 日期格式转换 将 HH:mm:ss 拼接成 yyyy-MM-dd HH:mm:ss 再转换成时间戳
     *
     * @param strDate 字符窜
     */
    private static long dateFormat(Date date, String strDate)
    {
        long time = 0;

        //获取当前日期
        String s = timeConvert.DateToSTr2(date) + " ";
        String dateStr = s + strDate;
        time = timeConvert.StrToDate(dateStr).getTime();


        return time;
    }


    /**
     * 计算当天考勤的打卡时间差
     */
    public static Map<String, Long> getCurrentAttendTime(WorkTime workShif, Attend attend)
    {
        Map<String, Long> map = new HashMap<>();

        //计算早上上班打卡是否有差异 两个时间在数据库都是time类型 年 月 日 都一样
        Long workStartTime = workShif.getWorkMorStartTime().getTime();
        if (attend.getAttendMorStart()!=null)
        {
            Long attendMorStart = attend.getAttendMorStart().getTime();

            //计算早上打卡时间和上班时间差
            Long timeRang = timeConvert.getTimeRang(workStartTime, attendMorStart);
            map.put("morStart", timeRang);
        }

        //计算早上下班打卡
        Long workEndTime = workShif.getWorkMorEndTime().getTime();
        map.put("morleave", null);
        if (attend.getAttendMorLeave()!=null)
        {
            Long attendMorLeave = attend.getAttendMorLeave().getTime();

            // 大于0 说明 早退
            Long timeRang = timeConvert.getTimeRang(attendMorLeave, workEndTime);
            map.put("morleave", timeRang);
        }


        //计算下午上班打卡
        Long workNoonStartTime = workShif.getWorkStartTimeAfternoon().getTime();
        map.put("noonStart", null);
        if (attend.getAttendNoonStart()!=null)
        {
            Long attendNoonStart = attend.getAttendNoonStart().getTime();

            Long timeRang = timeConvert.getTimeRang(workNoonStartTime, attendNoonStart);
            map.put("noonStart", timeRang);
        }

        //计算下午下班打卡
        Long workNoonEndTime = workShif.getWorkEndTimeAfternoon().getTime();
        map.put("noonleave", null);
        if (attend.getAttendNoonLeave()!=null)
        {
            // 大于0 说明 早退
            Long attendNoonleave = attend.getAttendNoonLeave().getTime();
            Long timeRang = timeConvert.getTimeRang(attendNoonleave, workNoonEndTime);
            map.put("noonleave", timeRang);
        }
        return map;
    }

}
