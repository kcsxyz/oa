package com.oa.service.common.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.WorkPlan;
import com.oa.dao.WorkPlanMapper;
import com.oa.service.common.WorkPlanService;
@Service
public class WorkPlanServiceImpl implements WorkPlanService {
    @Resource
	private WorkPlanMapper workPlanMapper;

	@Override
	public int updateByPrimaryKeySelective(WorkPlan record) {
		int i = workPlanMapper.updateByPrimaryKeySelective(record);
		return i;
	}
    
    
}
