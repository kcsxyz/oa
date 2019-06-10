package com.oa.service.process;

import java.util.List;

import com.oa.bean.Leave;
import com.oa.bean.Process;

public interface ProcessService {

	List<Leave> getLeaveList(String type,String queryStr, String startTime, String endTime);

	void saveLeave(Leave leave);

	void saveProcess(Process process);

}
