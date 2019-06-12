package com.oa.service.process;

import java.util.List;

import com.oa.bean.Leave;
import com.oa.bean.Process;
import com.oa.bean.ProcessNode;

public interface ProcessService {

	List<Leave> getLeaveList(String type,String queryStr, String startTime, String endTime,String uid);

	void saveLeave(Leave leave);

	void saveProcess(Process process);

	void saveProcessNode(ProcessNode pn);

	Integer getProcessNodeId(String processNo);
	
	//获得部们经理的审批项
	List<Leave> getNeedAuditLeaveList(String queryStr, Integer deptId,String roleName);
	//获得经理需要审批的请假申请
	List<Leave> getAuditLeaveList(String queryStr, String roleName);

}
