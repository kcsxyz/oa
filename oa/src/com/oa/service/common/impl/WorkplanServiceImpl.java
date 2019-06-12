package com.oa.service.common.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.oa.bean.WorkPlan;
import com.oa.bean.WorkPlanExample;
import com.oa.dao.WorkPlanMapper;
import com.oa.service.common.WorkplanService;
@Service
public class WorkplanServiceImpl implements WorkplanService {
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

	public List<WorkPlan> selectByMap(Map<String, Object> params) {
		List<WorkPlan> workPlans = workPlanMapper.selectByMap(params);
		return workPlans;
	}



    
}
