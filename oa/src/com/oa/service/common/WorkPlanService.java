package com.oa.service.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oa.bean.WorkPlan;
import com.oa.bean.WorkPlanExample;

public interface WorkPlanService {
     /**
      * 修改status来审核
      * @param record
      * @return
      */
	 int updateByPrimaryKeySelective(WorkPlan record);
	/**
	 *  根据id查
	 * @param id
	 * @return
	 */
	 WorkPlan selectByPrimaryKey(Integer id);
	 /**
	  * 显示审批信息
	  * @param example
	  * @return
	  */
	 List<WorkPlan> selectByExample(WorkPlanExample example);
	 /**
	  * 显示信息
	  * @param params
	  * @return
	  */
	 List<WorkPlan> selectByParams(@Param("param") Map<String, String> params);
}
