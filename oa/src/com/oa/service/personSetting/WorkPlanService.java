package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.WorkPlan;

public interface WorkPlanService {
	//查询所有工作计划
	List<WorkPlan> selectWorkPlan(int deptId);
	//根据id查询
	WorkPlan getWorkPlanById(Integer id);
	//添加工作计划
	int addworkPlan(WorkPlan workPlan);
	//删除多个
	void deleteWorkPlanBatch(List<Integer> listId);
	//删除一个
	void deleteWorkLog(Integer id1);
	//修改
	void updateWorkPlan(WorkPlan workPlan);
	//模糊查询
	List<WorkPlan> selectLikeWorkPlan(String workLogInfo, String startTime, String endTime);
	//根据类型查询
	List<WorkPlan> getWorkPlanByType(String type);
	//根据状态查询
	List<WorkPlan> getWorkPlanByStatus(Integer status);
	
	List<WorkPlan> getWorkPlanByUid(String uid);
	
	List<WorkPlan> getWorkPlanListByTime(String uid, String startTime, String endTime);
	
	List<WorkPlan> getWorkPlanListLike(String uid, String info);
	
	List<WorkPlan> getWorkPlanList(String uid, String info, String startTime, String endTime);

}