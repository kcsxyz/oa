package com.oa.service.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.oa.bean.WorkPlan;
import com.oa.bean.WorkPlanExample;

public interface WorkplanService {
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
	  * 新建查询三表查
	  * @param params
	  * @return
	  */
	 List<WorkPlan> selectByMap(@Param("param")Map<String, Object> params);
	
}
