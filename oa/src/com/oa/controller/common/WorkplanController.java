package com.oa.controller.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Dept;
import com.oa.bean.ResponseResult;
import com.oa.bean.WorkPlan;
import com.oa.service.common.WorkplanService;

@Controller
@RequestMapping("workplanAudit")
public class WorkplanController {
     @Resource
	 private WorkplanService workPlanService;
     
     /**修改部门
 	 * @param dept
 	 * @return
 	 */
 	@RequestMapping("/updateWorkPlanStatus")
 	public String updateWorkPlanStatus(
 			HttpSession session,
 			@RequestParam("status")  Integer status,
 			@RequestParam("opinion")  String opinion,
 			WorkPlan workPlan) {
 		ResponseResult rr = new ResponseResult();
 		String checkedName = (String) session.getAttribute("");
 		workPlan.setId(workPlan.getId());
 		workPlan.setStatus(status);
 		workPlan.setCheckedName(checkedName);
 		int i =workPlanService.updateByPrimaryKeySelective(workPlan);
 		if(i!=0) {
 			rr.setStateCode(1);
 			rr.setMessage("修改成功");
 		}else {
 			rr.setStateCode(0);
 			rr.setMessage("修改失败");
 		}
 		return "redirect:/workplanAudit/selectInfo";
 		
 	}
 	/**
	 * 通过id查询
	 * @return
	 */
	@RequestMapping("/findById/{id}")
	public String findBynoticeId(@PathVariable Integer id,Model model) {
		WorkPlan workPlan = null;
		try {
			workPlan = workPlanService.selectByPrimaryKey(id);
			System.out.println(workPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("planAuditById", workPlan);
		return "cheackPlanAudit";
	}
 	
	@RequestMapping("/selectInfo")
	public String selectInfo(
			HttpSession session,
			Integer type,
			String Info,
			Integer status,
			String createName,
			String dateStart,
			String finalTime,
			@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize,
            Model model
			) throws ParseException {
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(dateStart != null&&!dateStart.equals("") && finalTime != null&& !finalTime.equals("")) {
				 String startTime= dateStart+" "+"00:00:00";
				 String endTime = finalTime+" "+"23:59:59";
				 System.out.println(startTime+endTime);
				 map.put("startTime", startTime);
			    	map.put("endTime", endTime);
			 }
		    	map.put("Info", Info);
			    map.put("type", type);
			    map.put("status",status);
			    map.put("createName",createName);
		    Integer deptId = 2; 
		    if(deptId !=null || deptId==0) {
		    	  map.put("deptId", deptId);
		    }
		    PageHelper.startPage(pageNo,pageSize);
	        List<WorkPlan> workPlans = workPlanService.selectByMap(map);
	    	PageInfo<WorkPlan> pageBean = new PageInfo<WorkPlan>(workPlans, 3);
			model.addAttribute("pageInfo", pageBean);
	    	model.addAttribute("planAudit",workPlans);
			return "planAudit";
		
	}
	
}
