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
import com.oa.bean.Leave;
import com.oa.bean.ResponseResult;
import com.oa.bean.WorkPlan;
import com.oa.service.personSetting.LeaveService;

@Controller
@RequestMapping("leave")
public class LeaveController {
	@Resource
	private LeaveService leaveService;
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 * 查询所有请假
	 */
	@RequestMapping("/leavelist")
	@ResponseBody
	public ResponseResult selectAllWorkPlan(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		ResponseResult rr=new ResponseResult();
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<Leave> Leavelist = leaveService.selectLeave();	
			if(Leavelist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setMessage("未查询到 数据");
				rr.setStateCode(0);
			}
			
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<Leave> page = new PageInfo<Leave>(Leavelist, 3);
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
	 * 根据id查询请假
	 */
	@RequestMapping("/getLeaveById")
	@ResponseBody
	public ResponseResult getWorkPlanById(Integer id,Model model) {
		ResponseResult rr=new ResponseResult();
		Leave leave=leaveService.getLeaveById(id);
		model.addAttribute("leave", leave);
		//System.out.println(leave);
		if(leave!=null) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}		
		return rr;
	}
	/**
	 * @param leave
	 * @param model
	 * @param session
	 * @return
	 * 新增
	 */
	@RequestMapping("/addleave")
	@ResponseBody
	public ResponseResult addLeave(Leave leave,Model model) {
		ResponseResult rr=new ResponseResult();
		if(leaveService.getLeaveById(leave.getId())==null) {
			leave.setCreateTime(new Date());
			int i=leaveService.addLeave(leave);
			if(i<0) {
				model.addAttribute("leave", leave);
				rr.setStateCode(1);
			}else {
				rr.setMessage("添加失败");
				rr.setStateCode(0);
			}		
			
		}else {
			rr.setMessage("请假已存在");
			rr.setStateCode(0);
		}
		return rr;
	}
	/**
	 * @param id
	 * @return
	 * 删除
	 */
	@RequestMapping("/deleteLeave")
	@ResponseBody
	public ResponseResult deleteLeave(String id) {
		ResponseResult rr = new ResponseResult();
		
		String ids=id;
		//批量删除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(Integer.parseInt(string));
				leaveService.deleteLeaveBatch(listId);
			}
			rr.setStateCode(1);
		// 单个删除
		} else {
			Integer id1 = Integer.parseInt(ids);
			leaveService.deleteLeave(id1);;
			rr.setStateCode(1);
				}
		return rr;			
	}
	/**
	 * @param leave
	 * @param model
	 * @return
	 * 修改
	 */
	@RequestMapping("/updateLeave")
	@ResponseBody
	public ResponseResult updateLeave(Leave leave,Model model) {
		ResponseResult rr=new ResponseResult();
		
		if(leaveService.getLeaveById(leave.getId())!=null) {
			int i=leaveService.updateLeave(leave);
			if (i>0) {
				model.addAttribute(leave);
				rr.setStateCode(1);
			}else {
				rr.setStateCode(0);
				rr.setMessage("修改失败");
			}
			
		}else {
			rr.setMessage("工号不存在");
			rr.setStateCode(0);
		}
		return rr;
	}
	/**
	 * @param Info
	 * @param startTime
	 * @param endTime
	 * @param model
	 * @return
	 * 模糊查询
	 */
	@RequestMapping("/selectLikeWorkPlan")
	@ResponseBody
	public ResponseResult selectLikeWorkPlan(String Info,String startTime,String endTime,Model model) {
		ResponseResult rr=new ResponseResult();		
		List<Leave> leavelist = leaveService.selectLikeLeave(Info,startTime,endTime);
		model.addAttribute("leavelist",leavelist);
       for (Leave leave : leavelist) {
		System.out.println(leave);
       }
		if(leavelist.size()>0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}		
		return rr;			
	}
}
