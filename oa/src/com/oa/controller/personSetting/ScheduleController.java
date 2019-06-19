
package com.oa.controller.personSetting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.ResponseResult;
import com.oa.bean.Schedule;
import com.oa.bean.User;
import com.oa.bean.WorkLog;
import com.oa.bean.WorkPlan;
import com.oa.service.personSetting.ScheduleService;
import com.oa.utils.timeConvert;

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
	public String selectAllSchedule(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model,HttpSession session) {
		ResponseResult rr=new ResponseResult();
		User user=(User) session.getAttribute("user");
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<Schedule> schedulelist = scheduleService.selectSchedule(user.getUid());
			
			if(schedulelist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setMessage("未查询到数据");
				rr.setStateCode(0);
			}
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<Schedule> page = new PageInfo<Schedule>(schedulelist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("schedulelist", schedulelist);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return "personSetting/personalSchedule";			
	}
	
	@RequestMapping("/allSchedulelist")
	@ResponseBody
	public Map<String, String> AllSchedule(HttpSession session) {
		Map<String, String> map = new HashMap<String,String>();
		User user=(User) session.getAttribute("user");
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			
			List<Schedule> schedulelist = scheduleService.selectSchedule(user.getUid());
			if(schedulelist.size()>0) {
				for (Schedule schedule : schedulelist) {
					map.put(sdFormat.format(schedule.getStartTime()),schedule.getTitle());
				}
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return map;			
	}
	
	@RequestMapping("/getScheduleByDate")
	@ResponseBody
	public ResponseResult getScheduleByDate(String date,Model model) throws ParseException {
		ResponseResult rr=new ResponseResult();
		date="2019-06-12 15:03:11";
		Schedule schedule=scheduleService.getScheduleByDate(date);
		
		model.addAttribute(schedule);
		if(schedule!=null) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}		
		return rr;		
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 * 根据id查询
	 */
	@RequestMapping("/getScheduleById/{id}")
	public String getScheduleById(@PathVariable("id")Integer id,Model model) {
		ResponseResult rr=new ResponseResult();
		Schedule schedule=scheduleService.getScheduleById(id);
		model.addAttribute(schedule);
		if(schedule!=null) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}		
		return "personSetting/updatePersonalSchedule";
		
	}
	@RequestMapping("/toAddSchedule")
	public String toAddSchedule() {
		return "personSetting/addPersonalSchedule";
	}
	/**
	 * @param schedule
	 * @param model
	 * @param session
	 * @return
	 * 新增工作日程
	 */
	@RequestMapping("/addSchedule")
	public String addSchedule(Schedule schedule,Model model,HttpSession session) {
		ResponseResult rr=new ResponseResult();
		User user =(User) session.getAttribute("user");
		if(schedule.getDescr()!=null && schedule.getTitle()!=null) {			
			schedule.setCreateName(user.getUid());
			schedule.setCreateTime(new Date());
			if(schedule.getStartTime()==null) {
				schedule.setStartTime(new Date());
			}
			if(schedule.getEndTime()==null) {
				schedule.setEndTime(new Date());
			}
			int i=scheduleService.addSchedule(schedule);
			if(i<0) {
				model.addAttribute("schedule", schedule);
				rr.setStateCode(1);
			}else {
				rr.setStateCode(0);
				rr.setMessage("添加失败");
			}
			
		}else {
			rr.setMessage("信息已存在");
			rr.setStateCode(0);
		}
		return "redirect:/schedule/schedulelist";
	}
	/**
	 * @param id
	 * @return
	 * 删除
	 */
	@RequestMapping(value="/deleteSchedule/{id}",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult deleteSchedule(@PathVariable("id")String id) {
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
			int id1= Integer.parseInt(id);
			scheduleService.deleteSchedule(id1);
		}
		return rr;		
	}
	@RequestMapping("/deleteSchedule/{id}")
	public String delete(@PathVariable("id")Integer id) {
		scheduleService.deleteSchedule(id);
		return "redirect:/schedule/schedulelist";
	}
	/**
	 * @param schedule
	 * @param model
	 * @return
	 * 修改
	 */
	@RequestMapping("/updateSchedule/{schedule}")
	public String updateSchedule(Schedule schedule,Model model) {
		
		ResponseResult rr=new ResponseResult();
		if(scheduleService.getScheduleById(schedule.getId())!=null && schedule.getDescr()!=null) {
			scheduleService.updateSchedule(schedule);
			rr.setStateCode(1);
		}else {
			rr.setMessage("修改失败");
			rr.setStateCode(0);
		}
		return "redirect:/schedule/schedulelist";
	}
	/**
	 * @param Info
	 * @param startTime
	 * @param endTime
	 * @param model
	 * @return
	 * 模糊查询
	 */
	@RequestMapping("/selectLikeSchedule")
	public String selectLikeSchedule(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String Info,
			String startTime,String endTime,Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		ResponseResult rr=new ResponseResult();
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<Schedule> schedulelist =new ArrayList<>();
			 schedulelist=scheduleService.selectLikeSchedule(user.getUid(),Info, startTime, endTime);
			PageInfo<Schedule> page = new PageInfo<Schedule>(schedulelist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("schedulelist",schedulelist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personSetting/personalSchedule";
	}
	
}