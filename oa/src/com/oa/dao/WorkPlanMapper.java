package com.oa.dao;


import com.oa.bean.WorkPlan;
import com.oa.bean.WorkPlanExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WorkPlanMapper {
    long countByExample(WorkPlanExample example);

    int deleteByExample(WorkPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkPlan record);

    int insertSelective(WorkPlan record);

    List<WorkPlan> selectByExample(WorkPlanExample example);

    WorkPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkPlan record, @Param("example") WorkPlanExample example);

    int updateByExample(@Param("record") WorkPlan record, @Param("example") WorkPlanExample example);

    int updateByPrimaryKeySelective(WorkPlan record);

    int updateByPrimaryKey(WorkPlan record);
    
    List<WorkPlan>  selectByMap(@Param("param") Map<String,Object> params);

	List<WorkPlan> allWorkPlan(int deptId);
	
	List<WorkPlan> getWorkPlanByUid(String uid);

	List<WorkPlan> getListByTime(String uid, String startTime, String endTime);

	List<WorkPlan> getListByLike(@Param("uid")String uid, @Param("info")String info);

	List<WorkPlan> getList(String uid, String info, String startTime, String endTime);
  
 

}