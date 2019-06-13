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
	public List<WorkLog> selectLikeWorkLog(String workLogInfo,String startTime,String endTime) {
		// TODO Auto-generated method stub
		WorkLogExample de = new WorkLogExample();
		Criteria ct = de.createCriteria();
		ct.andTitleLike("%"+workLogInfo+"%");
		Criteria ct2 = de.createCriteria();
		ct2.andContentLike("%"+workLogInfo+"%");
		Criteria ct3 = de.createCriteria();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
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
				return workLogMapper.selectByExample(de);
		}
	
	public List<WorkLog> selectLikeWorkLog(String startTime,String endTime) {
		// TODO Auto-generated method stub
		WorkLogExample de = new WorkLogExample();
		Criteria ct3 = de.createCriteria();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
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
			return workLogMapper.selectByExample(de);
		}

	@Override
	public List<WorkLog> selectLikeWorkLog(String workLogInfo) {
		WorkLogExample de = new WorkLogExample();
		Criteria ct = de.createCriteria();
		ct.andTitleLike("%"+workLogInfo+"%");
		Criteria ct2 = de.createCriteria();
		ct2.andContentLike("%"+workLogInfo+"%");
		 de.or(ct2);		
		return workLogMapper.selectByExample(de);
	}
}
