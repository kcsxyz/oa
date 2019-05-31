package com.oa.dao;


import com.oa.bean.WorkPlan;
import com.oa.bean.WorkPlanExample;
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
    
    List<WorkPlan> selectByParams(@Param("param") Map<String, String> params);

    WorkPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkPlan record, @Param("example") WorkPlanExample example);

    int updateByExample(@Param("record") WorkPlan record, @Param("example") WorkPlanExample example);

    int updateByPrimaryKeySelective(WorkPlan record);

    int updateByPrimaryKey(WorkPlan record);
}