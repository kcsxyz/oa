package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.WorkLog;

public interface WorkLogService {
	//查询所有工作日志
	List<WorkLog> selectWorkLog();
	//根据id查询日志
	WorkLog getWorkLogByLogid(Integer logId);

}
