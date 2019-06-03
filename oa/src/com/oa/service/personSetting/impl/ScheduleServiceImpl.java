
package com.oa.service.personSetting.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Schedule;
import com.oa.bean.ScheduleExample;
import com.oa.bean.ScheduleExample.Criteria;
import com.oa.dao.ScheduleMapper;
import com.oa.service.personSetting.ScheduleService;
@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Resource
	private ScheduleMapper scheduleMapper;

	@Override
	public List<Schedule> selectSchedule() {		
		return scheduleMapper.selectByExample(null);
	}

	@Override
	public Schedule getScheduleById(Integer id) {		
		return scheduleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addSchedule(Schedule schedule) {
		int i=scheduleMapper.insert(schedule);
		return i;
	}

	@Override
	public void deleteScheduleBatch(List<Integer> listId) {
		ScheduleExample de=new ScheduleExample();
		Criteria ct = de.createCriteria();
		ct.andIdIn(listId);
		scheduleMapper.deleteByExample(de);		
	}

	@Override
	public void deleteSchedule(Integer id1) {
		scheduleMapper.deleteByPrimaryKey(id1);		
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		scheduleMapper.updateByPrimaryKey(schedule);
	}

	public List<Schedule> selectLikeSchedule(String Info, String startTime, String endTime) {
		ScheduleExample de = new ScheduleExample();
		Criteria ct = de.createCriteria();
		ct.andTitleLike("%"+Info+"%");
		Criteria ct2 = de.createCriteria();
		ct2.andDescrLike("%"+Info+"%");
		Criteria ct3 = de.createCriteria();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		Date date1;
		Date date2;
		try {
			date1 = formatter.parse(startTime);
			date2=formatter.parse(endTime);
			ct3.andCreateTimeBetween(date1, date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		de.or(ct2);
		de.or(ct3);
		return scheduleMapper.selectByExample(de);
	}
}