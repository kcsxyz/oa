
package com.oa.service.personSetting.impl;

import static org.hamcrest.CoreMatchers.both;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		scheduleMapper.updateByPrimaryKeySelective(schedule);
	}

	public List<Schedule> selectLikeSchedule(String uid,String Info, String startTime, String endTime) throws ParseException {
		
		String start = null;
		String end = null;
		if(startTime!=null && !(startTime.equals(""))) {
			start= startTime+" "+"00:00:00";
		}
		if(endTime!=null && !(endTime.equals(""))) {
			end = endTime+" "+"23:59:59";
		}	
		
		return scheduleMapper.getScheduleList(uid,Info,start,end);
		
	}

	@Override
	public List<Schedule> selectSchedule(String string) {
		// TODO Auto-generated method stub
		return scheduleMapper.selectSchedule(string);
	}
	
}