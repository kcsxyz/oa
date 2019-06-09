﻿package com.oa.controller.personSetting;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.bean.WorkLog;
import com.oa.bean.WorkPlan;
import com.oa.service.personSetting.WorkPlanService;

@Controller
@RequestMapping("workPlan")
public class WorkPlanController {
	@Resource
	private WorkPlanService workPlanService;
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 * 查询所有工作计划
	 */
	
	@RequestMapping(value="/workPlanlist", method=RequestMethod.GET)
	public String selectAllWorkPlan(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		ResponseResult rr=new ResponseResult();
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<WorkPlan> workPlanlist = workPlanService.selectWorkPlan();	
			if(workPlanlist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setMessage("未查询到数据");
				rr.setStateCode(0);
			}
			
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<WorkPlan> page = new PageInfo<WorkPlan>(workPlanlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("workPlanlist", workPlanlist);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "personSetting/workPlan";			
	}
	/**
	 * @param Id
	 * @param model
	 * @return
	 * 根据id查询
	 */
	
	@RequestMapping(value="/getWorkPlanById/{id}",method=RequestMethod.GET)	
	public String getWorkPlanById(@PathVariable Integer id,Model model) {
		ResponseResult rr=new ResponseResult();
		WorkPlan workPlan=workPlanService.getWorkPlanById(id);		
		if(workPlan!=null) {
			rr.setStateCode(1);
			model.addAttribute("workPlan", workPlan);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}		
		return "personSetting/updateWorkPlan";
	}
	//跳转到添加页面
	@RequestMapping(value="/addWorkPlan", method=RequestMethod.GET)
	public String addWorkPlan(Model model) {
		model.addAttribute(new WorkPlan());
		return "personSetting/addWorkPlan";
	}
	/**
	 * @param workPlan
	 * @param model
	 * @return
	 * 添加工作计划
	 * @throws ParseException 
	 */
	@RequestMapping(value="/addWorkPlan/{workPlan}", method=RequestMethod.POST)
	public String addWorkPlan(WorkPlan workPlan,HttpSession session) throws ParseException {
		ResponseResult rr=new ResponseResult();
		if(workPlanService.getWorkPlanById(workPlan.getId())==null) {
			User user=(User)session.getAttribute("user");
			Date now = new Date();
			// java.util.Date -> java.time.LocalDate
			LocalDate localDate=now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			// java.time.LocalDate -> java.sql.Date
			Date newDate=java.sql.Date.valueOf(localDate);
			System.out.println(newDate);
			workPlan.setCreateTime(newDate);			
			//workPlan.setCreateName(user.getName());
			workPlan.setStatus(0);
			int i=workPlanService.addworkPlan(workPlan);
			if(i<0) {				
				rr.setStateCode(1);
			}else {
				rr.setMessage("添加失败");
				rr.setStateCode(0);
			}
			
		}else {
			rr.setMessage("添加失败");
			rr.setStateCode(0);
		}
		return "redirect:/workPlan/workPlanlist";
	}
	/**
	 * @param id
	 * @return
	 * 删除
	 */
	@RequestMapping(value="/deleteWorkPlan/{id}", method=RequestMethod.GET)	
	public String deleteWorkPlan(@PathVariable("id") Integer id) {
		/*ResponseResult rr = new ResponseResult();
		String ids=id;
		//批量删除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(Integer.parseInt(string));
				workPlanService.deleteWorkPlanBatch(listId);
			}
			rr.setStateCode(1);
		// 单个删除
		} else {
			Integer id1 = Integer.parseInt(ids);
			workPlanService.deleteWorkLog(id1);
			rr.setStateCode(1);
				}*/
		workPlanService.deleteWorkLog(id);
		return "redirect:/workPlan/workPlanlist";			
	}
	@RequestMapping(value="/deleteWorkPlan/{id}", method=RequestMethod.POST)	
	public String deleteWorkPlan(@PathVariable("id") String id) {
		
		String ids=id;
		//批量删除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(Integer.parseInt(string));
				workPlanService.deleteWorkPlanBatch(listId);
			}
		}
		return "redirect:/workPlan/workPlanlist";
		
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 * 跳转到修改页面
	 */
	@RequestMapping(value="/updateWorkPlan/{id}",method=RequestMethod.GET)
	public String updateWorkPlan(@PathVariable Integer id,Model model) {
		WorkPlan workPlan=new WorkPlan();
		workPlan=workPlanService.getWorkPlanById(id);
		model.addAttribute(workPlan);		
		return "personSetting/updateWorkPlan";
	}
	/**
	 * @param workPlan
	 * @param model
	 * @return
	 * 修改工作计划
	 */
	@RequestMapping(value="/updateWorkPlan",method=RequestMethod.POST)
	public String updateWorkPlan(WorkPlan workPlan,HttpSession session) {
		User user=(User) session.getAttribute("user");
		//workPlan.setModifiedName(user.getUid());
		Date now = new Date();
		LocalDate localDate=now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();		
		Date newDate=java.sql.Date.valueOf(localDate);
		workPlan.setModifiedTime(newDate);
		workPlanService.updateWorkPlan(workPlan);		
		return "redirect:/workPlan/workPlanlist";
	}
	/**
	 * @param workLogInfo
	 * @param startTime
	 * @param endTime
	 * @param model
	 * @return
	 * 模糊查询
	 */
	@RequestMapping(value="/selectLikeWorkPlan",method=RequestMethod.GET)
	public String selectLikeWorkPlan(@RequestParam ("Info") String Info,
			@RequestParam("startTime")String startTime,@RequestParam("endTime")String endTime,Model model) {
		
		List<WorkPlan> workPlanlist = workPlanService.selectLikeWorkPlan(Info,startTime,endTime);		
		model.addAttribute("workPlanlist",workPlanlist);  
		
		return "personSetting/workPlan";			
	}
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @param model
	 * 根据类型查询
	 * @return
	 */
	@RequestMapping(value="/getWorkPlanByType", method=RequestMethod.GET)
	public String getWorkPlanByType(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,String type,Model model) {
		ResponseResult rr=new ResponseResult();
		
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<WorkPlan> workPlanlist = workPlanService.getWorkPlanByType(type);	
			if(workPlanlist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setMessage("未查询到数据");
				rr.setStateCode(0);
			}			
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<WorkPlan> page = new PageInfo<WorkPlan>(workPlanlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("workPlanlist", workPlanlist);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "personSetting/workPlan";	
	}
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param status
	 * @param model
	 * 根据状态查询
	 * @return
	 */
	@RequestMapping(value="/getWorkPlanByStatus", method=RequestMethod.GET)
	public String getWorkPlanByStatus(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Integer status,Model model) {
		ResponseResult rr=new ResponseResult();
		status=1;
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<WorkPlan> WorkPlanlist = workPlanService.getWorkPlanByStatus(status);	
			if(WorkPlanlist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setMessage("未查询到数据");
				rr.setStateCode(0);
			}			
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<WorkPlan> page = new PageInfo<WorkPlan>(WorkPlanlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("WorkPlanlist", WorkPlanlist);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "personSetting/workPlan";			
	}
	
}