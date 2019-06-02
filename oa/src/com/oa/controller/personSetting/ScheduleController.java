﻿
package com.oa.controller.personSetting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.ResponseResult;
import com.oa.bean.Schedule;
import com.oa.bean.WorkPlan;
import com.oa.service.personSetting.ScheduleService;

@Controller
@RequestMapping("schedule")
public class ScheduleController {
	@Resource
	private ScheduleService scheduleService;
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 * 查询所有工作日程
	 */
	@RequestMapping("/schedulelist")
	@ResponseBody
	public ResponseResult selectAllSchedule(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		ResponseResult rr=new ResponseResult();
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<Schedule> schedulelist = scheduleService.selectSchedule();	
			if(schedulelist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setMessage("未查询到数据");
				rr.setStateCode(0);
			}
			for (Schedule schedule : schedulelist) {
				System.out.println(schedule);
			}
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<Schedule> page = new PageInfo<Schedule>(schedulelist, 3);
			model.addAttribute("pageInfo", page);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return rr;			
	}
	/**
	 * @param id
	 * @param model
	 * @return
	 * 根据id查询
	 */
	@RequestMapping("/getScheduleById")
	@ResponseBody
	public ResponseResult getScheduleById(@RequestParam("id")Integer id,Model model) {
		ResponseResult rr=new ResponseResult();
		Schedule schedule=scheduleService.getScheduleById(id);
		model.addAttribute("schedule", schedule);
		System.out.println(schedule);
		if(schedule!=null) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}		
		return rr;
	}
	/**
	 * @param schedule
	 * @param model
	 * @param session
	 * @return
	 * 新增工作日程
	 */
	@RequestMapping("/addSchedule")
	@ResponseBody
	public ResponseResult addSchedule(Schedule schedule,Model model,HttpSession session) {
		ResponseResult rr=new ResponseResult();
		if(scheduleService.getScheduleById(schedule.getId())==null) {
			
			schedule.setCreateTime(new Date());
			scheduleService.addSchedule(schedule);
			model.addAttribute("schedule", schedule);
			rr.setStateCode(1);
		}else {
			rr.setMessage("添加失败");
			rr.setStateCode(0);
		}
		return rr;
	}
	/**
	 * @param id
	 * @return
	 * 删除
	 */
	@RequestMapping("/deleteSchedule")
	@ResponseBody
	public ResponseResult deleteSchedule(String id) {
		ResponseResult rr = new ResponseResult();		
		String ids=id;		
		//批量删除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(Integer.parseInt(string));
				scheduleService.deleteScheduleBatch(listId);
			}
			rr.setStateCode(1);
		// 单个删除
		} else {
			Integer id1 = Integer.parseInt(ids);
			scheduleService.deleteSchedule(id1);;
			rr.setStateCode(1);
				}
		return rr;			
	}
	/**
	 * @param schedule
	 * @param model
	 * @return
	 * 修改
	 */
	@RequestMapping("/updateSchedule")
	@ResponseBody
	public ResponseResult updateSchedule(Schedule schedule,Model model) {
		
		ResponseResult rr=new ResponseResult();
		if(scheduleService.getScheduleById(schedule.getId())!=null) {
			scheduleService.updateSchedule(schedule);
			rr.setStateCode(1);
		}else {
			rr.setMessage("修改失败");
			rr.setStateCode(0);
		}
		return rr;
	}
}