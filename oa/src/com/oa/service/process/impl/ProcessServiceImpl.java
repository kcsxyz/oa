package com.oa.service.process.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Audit;
import com.oa.bean.AuditExample;
import com.oa.bean.Leave;
import com.oa.bean.LeaveExample;
import com.oa.bean.LeaveExample.Criteria;
import com.oa.bean.Process;
import com.oa.bean.ProcessExample;
import com.oa.bean.ProcessLine;
import com.oa.bean.ProcessLineExample;
import com.oa.bean.ProcessNode;
import com.oa.bean.ProcessNodeExample;
import com.oa.dao.AuditMapper;
import com.oa.dao.LeaveMapper;
import com.oa.dao.ProcessLineMapper;
import com.oa.dao.ProcessMapper;
import com.oa.dao.ProcessNodeMapper;
import com.oa.service.process.ProcessService;
import com.oa.utils.timeConvert;

@Service
public class ProcessServiceImpl implements ProcessService {
	@Resource
	private LeaveMapper leaveMappper;
	
	@Resource
	private ProcessMapper processMapper;
	
	@Resource
	private ProcessNodeMapper processNodeMapper;
	
	@Resource
	private ProcessLineMapper processLineMapper;
	
	@Resource
	private AuditMapper auditMapper;
	@Override
	public List<Leave> getLeaveList(String type,String queryStr, String startTime, String endTime,String uid) {
		LeaveExample le = new LeaveExample();
		Criteria ct = le.createCriteria();
		ct.andUserIdEqualTo(uid);
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

	@Override
	public void saveProcessNode(ProcessNode pn) {
		processNodeMapper.insertSelective(pn);
		
	}

	@Override
	public Integer getProcessNodeId(String processNo,String roleName) {
		Integer processNodeId = processNodeMapper.getProcessNodeId(processNo,roleName);
		return processNodeId;
	}

	@Override
	public List<Leave> getNeedAuditLeaveList(String queryStr, Integer deptId,String roleName) {
		List<Leave> NeedAuditLeave = leaveMappper.getNeedAuditLeave(queryStr,deptId,roleName);
		
		return NeedAuditLeave;
	}

	@Override
	public List<Leave> getAuditLeaveList(String queryStr, String roleName) {
		List<Leave> NeedAuditLeave = leaveMappper.getSeMaNeedLeaveList(queryStr,roleName);
		return NeedAuditLeave;
	}

	@Override
	public Leave getLeaveById(Integer id) {
		System.out.println(id);
		Leave leave = leaveMappper.getLeaveById(id);
		return leave;
	}

	@Override
	public void updateLeave(Leave leave) {
		leaveMappper.updateByPrimaryKeySelective(leave);
		
	}

	@Override
	public void insertAudit(Audit au) {
		auditMapper.insert(au);
		
	}

	@Override
	public void saveProcessLine(ProcessLine processLine) {
		processLineMapper.insert(processLine);
		
	}

	@Override
	public void deleteLeave(String processNo) {
		LeaveExample le = new LeaveExample();
		Criteria ct = le.createCriteria();
		ct.andProcessNoEqualTo(processNo);
		leaveMappper.deleteByExample(le);
		
	}

	@Override
	public void deleteProcessNode(String processNo) {
		ProcessNodeExample pn =new ProcessNodeExample();
		com.oa.bean.ProcessNodeExample.Criteria pe = pn.createCriteria();
		pe.andProcessNoEqualTo(processNo);
		processNodeMapper.deleteByExample(pn);
		
	}

	@Override
	public void deleteProcessLine(String processNo) {
		ProcessLineExample pl = new ProcessLineExample();
		com.oa.bean.ProcessLineExample.Criteria ct = pl.createCriteria();
		ct.andProcessNoEqualTo(processNo);
		processLineMapper.deleteByExample(pl);
		
	}

	@Override
	public void deleteAudit(Integer leaveId) {
		AuditExample ae = new AuditExample();
		com.oa.bean.AuditExample.Criteria ac = ae.createCriteria();
		ac.andProIdEqualTo(leaveId);
		auditMapper.deleteByExample(ae);
		
	}

}
