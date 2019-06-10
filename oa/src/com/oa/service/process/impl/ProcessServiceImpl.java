package com.oa.service.process.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Leave;
import com.oa.bean.LeaveExample;
import com.oa.bean.LeaveExample.Criteria;
import com.oa.bean.Process;
import com.oa.dao.LeaveMapper;
import com.oa.dao.ProcessMapper;
import com.oa.service.process.ProcessService;
import com.oa.utils.timeConvert;

@Service
public class ProcessServiceImpl implements ProcessService {
	@Resource
	private LeaveMapper leaveMappper;
	
	@Resource
	private ProcessMapper processMapper;

	@Override
	public List<Leave> getLeaveList(String type,String queryStr, String startTime, String endTime) {
		LeaveExample le = new LeaveExample();
		Criteria ct = le.createCriteria();
		if(startTime != null && endTime != null) {
			String st = startTime+" 00:00:00";
			String et = endTime+" 23:59:59";
			ct.andCreateTimeBetween(timeConvert.getDate(st), timeConvert.getDate(et));
		}
		if(type != null) {
			ct.andLeaveTypeEqualTo(type);
		}
		
		List<Leave> leaveList = leaveMappper.selectByExample(le);
		return leaveList;
	}

	@Override
	public void saveLeave(Leave leave) {
		leaveMappper.insert(leave);
		
	}

	@Override
	public void saveProcess(Process process) {
		processMapper.insert(process);
		
	}

}
