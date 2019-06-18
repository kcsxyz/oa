package com.oa.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oa.bean.Attend;
import com.oa.bean.AttendCount;
import com.oa.bean.Leave;
import com.oa.bean.User;
import com.oa.bean.WorkTime;
import com.oa.dao.AttendCountMapper;
import com.oa.dao.AttendMapper;
import com.oa.dao.LeaveMapper;
import com.oa.dao.WorkTimeMapper;

public class MyAttendCountThread implements Runnable {
	
	private WorkTimeMapper workTimeMapper;
	private AttendMapper attendMapper;
	private LeaveMapper leaveMapper;
	private AttendCountMapper attendCountMapper;
	private List<User> users;
	
	
	public MyAttendCountThread(WorkTimeMapper workTimeMapper, AttendMapper attendMapper, LeaveMapper leaveMapper,
			AttendCountMapper attendCountMapper, List<User> users) {
		super();
		this.workTimeMapper = workTimeMapper;
		this.attendMapper = attendMapper;
		this.leaveMapper = leaveMapper;
		this.attendCountMapper = attendCountMapper;
		this.users = users;
	}


	@Override
	public void run() {
		WorkTime workTime = workTimeMapper.getTimeUsing();
		// 统计所有用户的
		// List<User> users = userMapper.selectByUser(new User());

		Leave leave = new Leave();
		AttendCount attendCount = new AttendCount();
		Attend attend = new Attend();

		// 当前日期 每个月一号 统计，统计上个月的打卡记录
		Date date = new Date();
		Date preMoth = timeConvert.getPreMoth(date);

		// 要统计的月 的第一天
		attend.setBeginTime(timeConvert.getFirstDayDateOfMonth(preMoth));
		// 要统计的月的最后一天
		attend.setOverTime(timeConvert.getLastDayOfMonth(preMoth));

		// 迟到次数和时间
		Integer time = null;
		Integer count = null;
		// 请假时长
		int leaveTimeLength = 0;
		// 每个人的当月的所有打卡记录
		List<Attend> attends = new ArrayList<>();
		// 每个人的请假记录
		List<Leave> leaves = new ArrayList<>();

		// 未打卡次数
		int noAttentCount = 0;
		// 插入统计表的记录
		String dateYear = null;
		String dateMoth = null;

		// 遍历用户一个个用户统计
		for (User u : users) {
			// if (User.isBoss(u.getUid()))
			// {
			// continue;
			// }

			attend.setUserId(u.getUid());
			attends = attendMapper.selectByMothAndUserId(attend);

			if (!attends.isEmpty()) {

				// 统计未打卡的次数
				noAttentCount = getNoAttentCount(attends);

				// 统计迟到次数和时长
				Map<String, Integer> lateAttentMap = getLateAttentCount(attends, workTime);
				time = lateAttentMap.get("time");
				count = lateAttentMap.get("count");

				// 统计请假时长
				leave.setUserId(u.getUid());
				leave.setBeginTime(preMoth);
				leave.setOverTime(preMoth);
				leaves = leaveMapper.selectByUserIdAndDate(leave);

				if (!lateAttentMap.isEmpty()) {
					leaveTimeLength = getLeaveTimeLength(leaves);
				}

				// 统计结果封装
				attendCount.setCreateTime(new Date());
				attendCount.setUserId(u.getUid());
				attendCount.setDeptId(u.getDeptId());
				attendCount.setLateCount(count);
				attendCount.setLateTimeLength(time);
				attendCount.setLeaveTimeLength(leaveTimeLength);
				attendCount.setAbsenceCount(noAttentCount);
				dateYear = timeConvert.substring(timeConvert.DateToSTr(preMoth), 0, 4);
				dateMoth = timeConvert.substring(timeConvert.DateToSTr(preMoth), 5, 7);
				attendCount.setDateYear(dateYear);
				attendCount.setDateMoth(dateMoth);

				try {
					attendCountMapper.insertSelective(attendCount);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}
	/**
	 * 统计未打卡的次数
	 */
	private static int getNoAttentCount(List<Attend> attends) {
		int count = 0;
		for (Attend a : attends) {
			Date attendMorStart = a.getAttendMorStart();
			Date attendMorLeave = a.getAttendMorLeave();
			Date attendNoonStart = a.getAttendNoonStart();
			Date attendNoonLeave = a.getAttendNoonLeave();
			if (attendMorStart == null) {
				count += 1;
			}
			if (attendMorLeave == null) {
				count += 1;
			}

			if (attendNoonStart == null) {
				count += 1;
			}
			if (attendNoonLeave == null) {
				count += 1;
			}

		}
		return count;
	}

	/**
	 * 统计迟到的次数和时间
	 *
	 * @param attends
	 *            当月的打卡日期
	 */
	private static Map<String, Integer> getLateAttentCount(List<Attend> attends, WorkTime workTime) {

		int time = 0;
		int count = 0;
		Map<String, Integer> map = new HashMap<>();

		// 数据库的time类型 为1970年 拿到一个时间 要进行同意的时间戳的比对
		Date date = workTime.getWorkMorStartTime();

		for (Attend a : attends) {
			Date attendMorStart = a.getAttendMorStart();
			Date attendMorLeave = a.getAttendMorLeave();
			Date attendNoonStart = a.getAttendNoonStart();
			Date attendNoonLeave = a.getAttendNoonLeave();

			// 迟到
			if (attendMorStart == null) {
				// 打卡时间 > 上班时间
				if (attendMorStart.getTime() > WorkTimeUtils.MorWorkStartTime(date, workTime)) {
					// 打卡时间-开始上啊不能时间
					long timeRang = timeConvert.getTimeRang(WorkTimeUtils.MorWorkStartTime(date, workTime),
							attendMorStart.getTime());
					System.out.println(timeRang);
					time += timeRang;
				}
			} else {
				count += 1;
			}

			if (attendNoonStart != null) {
				// 打卡时间 > 上班时间
				if (attendNoonStart.getTime() > WorkTimeUtils.AfterNoonStarWorkTime(date, workTime)) {
					long timeRang = timeConvert.getTimeRang(WorkTimeUtils.AfterNoonStarWorkTime(date, workTime),
							attendNoonStart.getTime());
					System.out.println(timeRang);
					time += timeRang;

				}
			} else {
				count += 1;
			}

			// 早退
			if (attendMorLeave != null) {
				// 打卡时间 早于 下班时间
				if (attendMorLeave.getTime() < WorkTimeUtils.MorWorkEndTime(date, workTime)) {
					long timeRang = timeConvert.getTimeRang(attendMorLeave.getTime(),
							WorkTimeUtils.MorWorkEndTime(date, workTime));
					System.out.println(timeRang);
					time += timeRang;

				}
			} else {
				// 未打卡
				count += 1;
			}

			if (attendNoonLeave != null) {
				// 打卡时间 早于 下班时间
				if (attendNoonLeave.getTime() < WorkTimeUtils.AfterNonEndWorkTime(date, workTime)) {

					long timeRang = timeConvert.getTimeRang(attendNoonLeave.getTime(),
							WorkTimeUtils.AfterNonEndWorkTime(date, workTime));
					System.out.println(timeRang);
					time += timeRang;
				}
			} else {
				count += 1;
			}
		}
		map.put("time", time);
		map.put("count", count);
		return map;
	}

	/**
	 * 统计请假时长
	 */
	private static int getLeaveTimeLength(List<Leave> leaves) {

		int time = 0;
		if (leaves.isEmpty()) {
			return time;
		}

		for (Leave leave : leaves) {
			long timeRang = timeConvert.getTimeRang(leave.getStartTime().getTime(),
					leave.getEndTime().getTime());
			time += timeRang;
		}
		return time;
	}

}
