package com.oa.service.personSetting.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		WorkLog workLog=workLogMapper.selectByPrimaryKey(logId);
		return workLog;
	}

	@Override
	public int addWorkLog(WorkLog workLog) {
		// TODO Auto-generated method stub
		return workLogMapper.insert(workLog);
	}

	@Override
	public void deleteWorkLog(Integer logId) {
		// TODO Auto-generated method stub
		workLogMapper.deleteByPrimaryKey(logId);
	}

	@Override
	public void deleteDeptBatch(List<Integer> listId) {
		// TODO Auto-generated method stub
		WorkLogExample de = new WorkLogExample();
		Criteria ct = de.createCriteria();
		ct.andLogIdIn(listId);
		workLogMapper.deleteByExample(de);
	}

	@Override
	public void updateWorkLog(WorkLog worklog) {
		// TODO Auto-generated method stub
		workLogMapper.updateByPrimaryKeySelective(worklog);
	}
	@Override
	public List<WorkLog> selectWorkLogByCreateName(String uid) {
		
		return workLogMapper.getWorkLogByCreateName(uid);
	}

	@Override
	public List<WorkLog> selectList(String uid, String workLogInfo, String startTime, String endTime) {
		String start = null;
		String end = null;
		if(startTime!=null && !(startTime.equals(""))) {
			start= startTime+" "+"00:00:00";
		}
		if(endTime!=null && !(endTime.equals(""))) {
			end = endTime+" "+"23:59:59";
		}	
		
		return workLogMapper.selectList(uid,workLogInfo,start,end);
	}
}
