package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.WorkLog;

public interface WorkLogService {
	//查询所有工作日志
	List<WorkLog> selectWorkLog();
	//根据id查询日志
	WorkLog getWorkLogByLogid(Integer logId);
	//新增日志
	int addWorkLog(WorkLog workLog);
	//删除日志
	void deleteWorkLog(Integer logId);
	//批量删除
	void deleteDeptBatch(List<Integer> listId);
	
	/**
	 * @param worklog
	 * //修改工作日志
	 */
	void updateWorkLog(WorkLog worklog);
	
	/**
	 * @param workLogInfo
	 * @return
	 * 模糊查询
	 */
	List<WorkLog> selectLikeWorkLog(String workLogInfo,String startTime,String endTime);
	List<WorkLog> selectLikeWorkLog(String start, String end);
	List<WorkLog> selectLikeWorkLog(String workLogInfo);
	

}
