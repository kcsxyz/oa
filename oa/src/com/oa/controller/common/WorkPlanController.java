package com.oa.controller.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.bean.WorkPlan;
import com.oa.service.common.WorkPlanService;

@Controller
public class WorkPlanController {
     @Resource
	 private WorkPlanService workPlanService;
     
     /**修改部门
 	 * @param dept
 	 * @return
 	 */
 	@RequestMapping("/updateWorkPlanStatus")
 	@ResponseBody
 	public int updateWorkPlanStatus(WorkPlan workPlan) {
 		//ResponseResult rr = new ResponseResult();
 		int i =workPlanService.updateByPrimaryKeySelective(workPlan);
 		if(i>0) {
 			//rr.setStateCode(1);;
 		}else {
 			//rr.setStateCode(0);
 		}
 		//return rr;
 		return i;
 	}
 	
}
