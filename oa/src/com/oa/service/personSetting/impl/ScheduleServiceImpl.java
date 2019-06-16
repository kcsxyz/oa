
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

	public List<Schedule> selectLikeSchedule(String Info, String startTime, String endTime) throws ParseException {
		
			ScheduleExample de = new ScheduleExample();
			Criteria ct = de.createCriteria();
			Criteria ct2 = de.createCriteria();
			Criteria ct3 = de.createCriteria();
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
			if(startTime != null && !startTime.equals("") && endTime != null&& !endTime.equals("")) {
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
				return scheduleMapper.selectByExample(de);
				}
			if(Info!=null) {
				ct.andTitleLike("%"+Info+"%");
				ct2.andCreateNameLike("%"+"Info"+"%");
				de.or(ct2);
				return scheduleMapper.selectByExample(de);
			}
			return scheduleMapper.selectByExample(de);
		
	}

	@Override
	public List<Schedule> selectSchedule(String string) {
		// TODO Auto-generated method stub
		return scheduleMapper.selectSchedule(string);
	}
	
}