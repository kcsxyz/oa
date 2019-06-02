package com.oa.service.common.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.WorkPlan;
import com.oa.bean.WorkPlanExample;
import com.oa.dao.WorkPlanMapper;
import com.oa.service.common.WorkPlanService;
@Service
public class WorkPlanServiceImpl implements WorkPlanService {
    @Resource
	private WorkPlanMapper workPlanMapper;


	public int updateByPrimaryKeySelective(WorkPlan record) {
		int i = workPlanMapper.updateByPrimaryKeySelective(record);
		return i;
	}

	
	public WorkPlan selectByPrimaryKey(Integer id) {
		WorkPlan workPlan = workPlanMapper.selectByPrimaryKey(id);
		return workPlan;
	}


	public List<WorkPlan> selectByExample(WorkPlanExample example) {
		
		return null;
	}


	public List<WorkPlan> selectByParams(Map<String, String> params) {
		List<WorkPlan> workPlans = null;
		try {
			workPlans = workPlanMapper.selectByParams(params);
			for (WorkPlan workPlan : workPlans) {
				System.out.println(workPlan);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workPlans;
	}
    
    
}
