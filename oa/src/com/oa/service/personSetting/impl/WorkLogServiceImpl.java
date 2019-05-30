package com.oa.service.personSetting.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.WorkLog;
import com.oa.bean.WorkLogExample;
import com.oa.bean.WorkLogExample.Criteria;
import com.oa.dao.WorkLogMapper;
import com.oa.service.personSetting.WorkLogService;
@Service
public class WorkLogServiceImpl implements WorkLogService {
	@Resource
	private WorkLogMapper workLogMapper;

	@Override//查询所有工作日志
	public List<WorkLog> selectWorkLog() {
		// TODO Auto-generated method stub		
		List<WorkLog> workLogList=workLogMapper.selectByExample(null);
		return workLogList;
	}

	@Override
	public WorkLog getWorkLogByLogid(Integer logId) {
		// TODO Auto-generated method stub
		return workLogMapper.selectByPrimaryKey(logId);
	}

}
