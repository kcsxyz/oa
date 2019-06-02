package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.WorkPlan;

public interface WorkPlanService {
	//查询所有工作计划
	List<WorkPlan> selectWorkPlan();
	//根据id查询
	WorkPlan getWorkPlanById(Integer id);
	//添加工作计划
	void addworkPlan(WorkPlan workPlan);
	//删除多个
	void deleteWorkPlanBatch(List<Integer> listId);
	//删除一个
	void deleteWorkLog(Integer id1);
	//修改
	void updateWorkPlan(WorkPlan workPlan);
	//模糊查询
	List<WorkPlan> selectLikeWorkPlan(String workLogInfo, String startTime, String endTime);

}
