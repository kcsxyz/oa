package com.oa.service.deptOffice.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Attend;
import com.oa.bean.WorkTime;
import com.oa.dao.AttendMapper;
import com.oa.dao.WorkTimeMapper;
import com.oa.service.deptOffice.AttendService;
import com.oa.utils.WorkTimeUtils;
import com.oa.utils.timeConvert;

@Service
public class AttendServiceImpl implements AttendService {
	
	@Resource
	private WorkTimeMapper workTimeMapper;
	
	@Resource
	private AttendMapper  attendMapper;

	@Override
	public int insertAttend(Attend attend) throws Exception {
		int i = 0;
        Date date = new Date();
        long currDate = date.getTime();
        WorkTime workShif = workTimeMapper.getTimeUsing();
        System.out.println(attend.getUserId());

        //2.判断是不是当天第一次打卡,如果是 就插入数据，否则更新 中午 或者下午 晚上 时间的打卡时间
        Attend isAttend = attendMapper.selectSaveDayIsAttend(attend.getUserId());
        System.out.println(currDate);
        Attend attend1 = null;
        if (isAttend == null)
        {
            //第一次打卡
            attend1 = attend(date, workShif, attend, currDate);
            attend1.setUserId("admin");
            attend1.setCurrDate(date);
            attend1.setWeek(timeConvert.getTodayWeek());
            System.out.println(attend1.toString());
            i = attendMapper.insertSelective(attend1);
        }
        else
        {
            attend1 = attend(date, workShif, attend, currDate);
            attend1.setWeek(timeConvert.getTodayWeek());
            attend1.setAttendId(isAttend.getAttendId());
            i = attendMapper.updateByPrimaryKeySelective(attend1);
            System.out.println("not first"+attend1.toString());
        }

        return i;
	}

	public Attend attend(Date date, WorkTime workShif, Attend attend, long currDate) throws Exception
    {
        //早上上班时间
        long morWorkStartTime = WorkTimeUtils.MorWorkStartTime(date, workShif);
        // 早上下班时间
        long morWorkEndTime = WorkTimeUtils.MorWorkEndTime(date, workShif);

        //早上开始打卡时间
        long attendStartMorTime = WorkTimeUtils.attendStartMorTime(date, workShif);
        //早上结束打卡时间
        long attendEndMorTime = WorkTimeUtils.attendEndMorTime(date, workShif);

        //早上下班打卡开始时间
        long leavMorStartTime = WorkTimeUtils.leaveMorStartTime(date, workShif);
        //早上下班打卡结束时间
        long leavMorEndtTime = WorkTimeUtils.leaveMorEnddate(date, workShif);


        //下午上班打卡开始时间
        long attendAfterNoonStatrTime = WorkTimeUtils.attendAfterNoonStatrTime(date, workShif);
        //下午上班打卡结束时间
        long attendAfterNoonEndTime = WorkTimeUtils.attendAfterNoonEndTime(date, workShif);

        //下午上班开始时间
        long afterNoonStarWorkTime = WorkTimeUtils.AfterNoonStarWorkTime(date, workShif);
        //下午上班结束时间
        long afterNonEndWorkTime = WorkTimeUtils.AfterNonEndWorkTime(date, workShif);


        //下午下班开始打卡时间
        long attendAfterNoonleaveStartTime = WorkTimeUtils.AttendAfterNoonLeaveStartTime(date, workShif);
        //下午下班结束打卡时间
        long attendAfterNoonleaveEndTime = WorkTimeUtils.AttendAfterNoonLeaveEndTime(date, workShif);

        System.out.println(attendAfterNoonleaveEndTime);
        Attend saveDayIsAttend = attendMapper.selectSaveDayIsAttend(attend.getUserId());

        Attend isFirstAttend = attendMapper.selectSaveDayIsAttend(attend.getUserId());

        //如果第一次打卡不是早上上班时间，那么当天的考勤就设为异常
        if (isFirstAttend==null)
        {
            if (currDate > attendEndMorTime)
            {
                attend.setStatus(0);
            }
        }


        //早打卡 打卡开始时间 < 当前打卡时间 < 下班时间
        if (attendStartMorTime <= currDate && currDate < attendEndMorTime)
        {
            //判断是否重复打卡
            if (saveDayIsAttend != null && saveDayIsAttend.getAttendMorStart() != null)
            {
                throw new Exception("请勿重复打卡！");
            }

            // 当前打卡时间 > 上班时间
            if (currDate > morWorkStartTime)
            {
                //迟到
                attend.setStatus(0);
            }
            attend.setAttendMorStart(date);
        }
        //中午下班打卡
        else if (leavMorStartTime <= currDate && currDate <= leavMorEndtTime)
        {
            //判断是否重复打卡
            if (saveDayIsAttend != null && saveDayIsAttend.getAttendMorLeave() != null)
            {
                throw new Exception("请勿重复打卡！");
            }
            attend.setAttendMorLeave(date);
        }
        //下午上班打卡
        else if (attendAfterNoonStatrTime <= currDate && currDate < attendAfterNoonEndTime)
        {
            //判断是否重复打卡
            if (saveDayIsAttend != null && saveDayIsAttend.getAttendNoonStart() != null)
            {
                throw new Exception("请勿重复打卡！");
            }
            if (currDate > afterNoonStarWorkTime)
            {
                //迟到
                attend.setStatus(0);
            }
            attend.setAttendNoonStart(date);
        }
        else if (attendAfterNoonleaveStartTime <= currDate && currDate <= attendAfterNoonleaveEndTime)
        {
            //判断是否重复打卡
            if (saveDayIsAttend != null && saveDayIsAttend.getAttendNoonLeave() != null)
            {
                throw new Exception("请勿重复打卡！");
            }
            attend.setAttendNoonLeave(date);
        }
        else
        {
            throw new Exception("现在不是打卡时间！");
        }
        return attend;
    }

	@Override
	public WorkTime selectUsing() {
		WorkTime wt = workTimeMapper.getTimeUsing();
		return wt;
	}

	@Override
	public Attend selectSaveDayIsAttend(String uid) {
		
		return attendMapper.selectSaveDayIsAttend(uid);
	}

	@Override
	public List<WorkTime> getWorkTimeList() {
		
		List<WorkTime> workTimeList = workTimeMapper.selectByExample(null);
		return workTimeList;
	}

	@Override
	public List<Attend> getAttendList() {
		
		 List<Attend> listAttend = attendMapper.getAttendList();
		return listAttend;
	}

	@Override
	public WorkTime getWorkTime() {
		WorkTime  workTime = attendMapper.getWorkTime();
		return workTime;
	}

}
