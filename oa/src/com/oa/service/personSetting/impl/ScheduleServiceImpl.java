package com.oa.service.personSetting.impl;

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
	public void addSchedule(Schedule schedule) {
		scheduleMapper.insert(schedule);
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
}
