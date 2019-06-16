
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
	public List<WorkPlan> selectWorkPlan(int deptId) {
		// TODO Auto-generated method stub
		return workPlanMapper.allWorkPlan(deptId);
	}

	@Override
	public WorkPlan getWorkPlanById(Integer id) {
		// TODO Auto-generated method stub
		WorkPlan workPlan=workPlanMapper.selectByPrimaryKey(id);
		return workPlan;
	}

	@Override
	public int addworkPlan(WorkPlan workPlan) {
		// TODO Auto-generated method stub
		int i=workPlanMapper.insert(workPlan);
		return i;
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
		workPlanMapper.updateByPrimaryKeySelective(workPlan);
	}

	@Override
	public List<WorkPlan> selectLikeWorkPlan(String Info, String startTime, String endTime) {
		WorkPlanExample de = new WorkPlanExample();
		Criteria ct = de.createCriteria();
		ct.andContentLike("%"+Info+"%");		
		Criteria ct3 = de.createCriteria();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
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
		de.or(ct3);		
		return workPlanMapper.selectByExample(de);
		
	}

	@Override
	public List<WorkPlan> getWorkPlanByType(String type) {
		WorkPlanExample de = new WorkPlanExample();
		Criteria ct = de.createCriteria();
		ct.andTypeEqualTo(type);
		return workPlanMapper.selectByExample(de);
	}

	@Override
	public List<WorkPlan> getWorkPlanByStatus(Integer status) {
		WorkPlanExample de = new WorkPlanExample();
		Criteria ct = de.createCriteria();
		ct.andStatusEqualTo(status);
		return workPlanMapper.selectByExample(de);
	}

	@Override
	public List<WorkPlan> getWorkPlanByUid(String uid) {
		// TODO Auto-generated method stub
		return workPlanMapper.getWorkPlanByUid(uid);
	}
	

	public List<WorkPlan> getWorkPlanList(String uid, String info, String startTime, String endTime) {
		String start = null;
		String end = null;
		if(startTime!=null && !(startTime.equals(""))) {
			start= startTime+" "+"00:00:00";
		}
		if(endTime!=null && !(endTime.equals(""))) {
			end = endTime+" "+"23:59:59";
		}		 
		return workPlanMapper.getList(uid,info,start,end);
	}
}