package com.oa.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 private WorkplanService workplanService;
     
     /**修改部门
 	 * @param dept
 	 * @return
 	 */
 	@RequestMapping("/updateWorkPlanStatus")
 	@ResponseBody
 	public ResponseResult updateWorkPlanStatus(
 			HttpSession session,
 			Integer id,
 			String opinion,
 			Integer status,
 			WorkPlan workPlan) {
 		ResponseResult rr = new ResponseResult();
 		String checkedName = (String) session.getAttribute("");
 		workPlan.setId(id);
 		workPlan.setStatus(status);
 		workPlan.setCheckedName(checkedName);
 		workPlan.setOpinion(opinion);
 		int i =workplanService.updateByPrimaryKeySelective(workPlan);
 		if(i!=0) {
 			rr.setStateCode(1);
 			rr.setMessage("修改成功");
 		}else {
 			rr.setStateCode(0);
 			rr.setMessage("修改失败");
 		}
 		return rr;
 		
 	}
 	/**
	 * 通过id查询
	 * @return
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public WorkPlan findBynoticeId(Integer id) {
		WorkPlan workPlan = null;
		try {
			workPlan = workplanService.selectByPrimaryKey(id);
			System.out.println(workPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workPlan;
	}
 	
	@RequestMapping("/selectByParams")
	@ResponseBody
	public List<WorkPlan> selectByParams(
			HttpSession session,
			String type,
			String Info,
			String status,
			String createName,
			String startTime,
			String endTime,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            Model model
			) {
		   Map<String, String> map = new HashMap<String, String>();
		    map.put("type", type);
		    map.put("status",status);
		    map.put("createName",createName);
			map.put("Info", Info);
	        map.put("startTime",startTime);
	        map.put("endTime",endTime);
	       List<WorkPlan> workPlans = workplanService.selectByParams(map);
	       PageHelper.startPage(pageNo, pageSize);
	       Integer checkedDeptid = 2;
	       List<WorkPlan> newworkPlans = new ArrayList<WorkPlan>();
	    	   for(int i=0;i<workPlans.size();i++) {
	    		   WorkPlan workPlan = workPlans.get(i);
	    		   Integer uDeptid = workPlan.getUser().getDeptId();
		    	   System.out.println("---------uid="+uDeptid);
		    	   if(checkedDeptid !=0 || uDeptid !=0 ) {
		    		   if(checkedDeptid == uDeptid){
		    			   newworkPlans.add(workPlan);
		    		   }
		    		   for (WorkPlan workPlan2 : newworkPlans) {
						System.out.println("newworkPlans中的一条数据"+workPlan2);
					  }
		           }
	    	   
		}
	    	PageInfo<WorkPlan> page = new PageInfo<WorkPlan>(newworkPlans, 3);
			//model.addAttribute("pageInfo", page);
	    	System.out.println(page.getList().size());
			return newworkPlans;
		
	}
	
}
