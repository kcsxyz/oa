package com.oa.controller.personSetting;

import java.text.SimpleDateFormat;
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
	@RequestMapping("/workPlanlist")
	@ResponseBody
	public ResponseResult selectAllWorkPlan(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		ResponseResult rr=new ResponseResult();
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<WorkPlan> WorkPlanlist = workPlanService.selectWorkPlan();	
			if(WorkPlanlist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setMessage("未查询到 数据");
				rr.setStateCode(0);
			}
			/*for (WorkPlan workPlan : WorkPlanlist) {
				System.out.println(workPlan);
			}*/
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<WorkPlan> page = new PageInfo<WorkPlan>(WorkPlanlist, 3);
			model.addAttribute("pageInfo", page);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return rr;			
	}
	/**
	 * @param Id
	 * @param model
	 * @return
	 * 根据id查询
	 */
	@RequestMapping("/getWorkPlanById")
	@ResponseBody
	public ResponseResult getWorkPlanById(Integer id,Model model) {
		ResponseResult rr=new ResponseResult();
		WorkPlan workPlan=workPlanService.getWorkPlanById(id);
		model.addAttribute("workPlan", workPlan);
		//System.out.println(workPlan);
		if(workPlan!=null) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}
		
		return rr;
	}
	/**
	 * @param workPlan
	 * @param model
	 * @return
	 * 添加工作计划
	 */
	@RequestMapping("/addWorkPlan")
	@ResponseBody
	public ResponseResult addWorkPlan(WorkPlan workPlan,Model model,HttpSession session) {
		ResponseResult rr=new ResponseResult();
		if(workPlanService.getWorkPlanById(workPlan.getId())==null) {
		
			workPlan.setCreateTime(new Date());
			workPlanService.addworkPlan(workPlan);
			model.addAttribute("workPlan", workPlan);
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
	@RequestMapping("/deleteWorkPlan")
	@ResponseBody
	public ResponseResult deleteWorkPlan(String id) {
		ResponseResult rr = new ResponseResult();
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
			workPlanService.deleteWorkLog(id1);;
			rr.setStateCode(1);
				}
		return rr;			
	}
	
	/**
	 * @param workPlan
	 * @param model
	 * @return
	 * 修改工作计划
	 */
	@RequestMapping("/updateWorkPlan")
	@ResponseBody
	public ResponseResult updateWorkPlan(WorkPlan workPlan,Model model) {
		ResponseResult rr=new ResponseResult();
		if(workPlanService.getWorkPlanById(workPlan.getId())!=null) {
			workPlanService.updateWorkPlan(workPlan);
			rr.setStateCode(1);
		}else {
			rr.setMessage("修改失败");
			rr.setStateCode(0);
		}
		return rr;
	}
	/**
	 * @param workLogInfo
	 * @param startTime
	 * @param endTime
	 * @param model
	 * @return
	 * 模糊查询
	 */
	@RequestMapping("/selectLikeWorkPlan")
	@ResponseBody
	public ResponseResult selectLikeWorkPlan(String workLogInfo,String startTime,String endTime,Model model) {
		ResponseResult rr=new ResponseResult();		
		List<WorkPlan> workPlanlist = workPlanService.selectLikeWorkPlan(workLogInfo,startTime,endTime);
		model.addAttribute("workPlanlist",workPlanlist);
       /*for (WorkPlan workPlans : workPlanlist) {
		System.out.println(workPlans);
       }*/
		if(workPlanlist.size()>0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}
		
		return rr;			
	}
	
}