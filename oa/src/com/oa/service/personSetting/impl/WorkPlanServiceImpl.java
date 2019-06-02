
package com.oa.service.personSetting.impl;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.WorkLogExample;
import com.oa.bean.WorkPlan;
import com.oa.bean.WorkPlanExample;
import com.oa.bean.WorkPlanExample.Criteria;
import com.oa.dao.WorkPlanMapper;
import com.oa.service.personSetting.WorkPlanService;
@Service
public class WorkPlanServiceImpl implements WorkPlanService {
	@Resource
	private WorkPlanMapper workPlanMapper;

	@Override
	public List<WorkPlan> selectWorkPlan() {
		// TODO Auto-generated method stub
		return workPlanMapper.selectByExample(null);
	}

	@Override
	public WorkPlan getWorkPlanById(Integer id) {
		// TODO Auto-generated method stub
		WorkPlan workPlan=workPlanMapper.selectByPrimaryKey(id);
		return workPlan;
	}

	@Override
	public void addworkPlan(WorkPlan workPlan) {
		// TODO Auto-generated method stub
		workPlanMapper.insert(workPlan);
	}

	@Override
	public void deleteWorkPlanBatch(List<Integer> listId) {
		// TODO Auto-generated method stub
		WorkPlanExample de = new WorkPlanExample();
		Criteria ct = de.createCriteria();
		ct.andIdIn(listId);
		workPlanMapper.deleteByExample(de);
	}

	@Override
	public void deleteWorkLog(Integer id1) {
		// TODO Auto-generated method stub
		workPlanMapper.deleteByPrimaryKey(id1);
	}

	@Override
	public void updateWorkPlan(WorkPlan workPlan) {
		// TODO Auto-generated method stub
		workPlanMapper.updateByPrimaryKey(workPlan);
	}

	@Override
	public List<WorkPlan> selectLikeWorkPlan(String workLogInfo, String startTime, String endTime) {
		WorkPlanExample de = new WorkPlanExample();
		Criteria ct = de.createCriteria();
		ct.andTypeLike("%"+workLogInfo+"%");
		Criteria ct2 = de.createCriteria();
		ct2.andContentLike("%"+workLogInfo+"%");
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
		return workPlanMapper.selectByExample(de);
	}
}