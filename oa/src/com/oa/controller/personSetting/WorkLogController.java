package com.oa.controller.personSetting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.oa.bean.User;
import com.oa.bean.WorkLog;
import com.oa.service.personSetting.WorkLogService;
import com.oa.utils.md5;

import net.sf.jsqlparser.statement.delete.Delete;
	
	@Controller
	@RequestMapping("workLog")
	public class WorkLogController {
		@Resource
		private WorkLogService workLogService;
		
		@RequestMapping("/workLog")
		public String WorkLog() {
			return "personSetting/workLog";
		}
		/**
		 * @param model
		 * @return
		 * 查询所有工作日志
		 */
		@RequestMapping("/workLoglist")
		public String selectAllWorkLog(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model,HttpSession session) {
			ResponseResult rr=new ResponseResult();
			User user=(User) session.getAttribute("user");
			try {
				// startPage后紧跟着的就是一个分页查询
				PageHelper.startPage(pageNo, pageSize);
				List<WorkLog> workLoglist = workLogService.selectWorkLogByCreateName(user.getUid());	
				if(workLoglist.size()>0) {
					rr.setStateCode(1);
				}else {
					rr.setStateCode(0);
					rr.setMessage("未查询到数据");
				}
				// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
				PageInfo<WorkLog> page = new PageInfo<WorkLog>(workLoglist, 3);
				model.addAttribute("pageInfo", page);
				model.addAttribute("workLoglist",workLoglist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "personSetting/workLog";
		}
		/**
		 * @param logId
		 * @param model
		 * @return
		 * 根据id查询日志
		 */
		@RequestMapping("/getWorkLogById/{logId}")
		public String getWorkLogById(@PathVariable Integer logId,Model model) {
			ResponseResult rr=new ResponseResult();
			WorkLog workLog=workLogService.getWorkLogByLogid(logId);
			model.addAttribute("workLog", workLog);
			//System.out.println(workLog);
			if(workLog!=null) {
				rr.setStateCode(1);
			}else {
				rr.setStateCode(0);
				rr.setMessage("未查询到数据");
			}
			
			return "personSetting/updateWorkLog";
		}
		@RequestMapping("/toAddWorkLog")
		public String addWorkLog(Model model) {
			model.addAttribute(new WorkLog());
			return "personSetting/addWorkLog";
		}
		/**
		 * @param workLog
		 * @param model
		 * @return
		 * 新增日志
		 */
		@RequestMapping("/addWorkLog")
		@ResponseBody
		public ResponseResult addWorkLog(WorkLog workLog,HttpSession session) {
			ResponseResult rr=new ResponseResult();
			if(workLogService.getWorkLogByLogid(workLog.getLogId())==null && workLog!=null) {
				User user=(User) session.getAttribute("user");
				workLog.setCreateTime(new Date());
				workLog.setCreateName(user.getUid());
				int i=workLogService.addWorkLog(workLog);
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
			return rr;
		}
		@RequestMapping("/deleteWorkLog/{logId}")
		public String Delete(@PathVariable("logId")Integer logId) {
				workLogService.deleteWorkLog(logId);
				return "redirect:/workLog/workLoglist";
		}
		/**
		 * @param logId
		 * @return
		 * 删除日志
		 */
		@RequestMapping(value="/deleteWorkLog/{logId}",method=RequestMethod.POST)
		public String deleteWorkLog(@PathVariable("logId")String logId) {
			
			String ids=logId;
			//批量删除
			if (ids.contains("-")) {
				List<Integer> listId = new ArrayList<>();
				String[] split_ids = ids.split("-");
				for (String string : split_ids) {
					listId.add(Integer.parseInt(string));
					workLogService.deleteDeptBatch(listId);
				}
			} 
			return "redirect:/workLog/workLoglist";			
		}
		
		@RequestMapping("/toUpdateWorkLog")
		public String toUpdateWorkLog () {
			return "personSetting/updateWorkLog";
		}
		/**
		 * @param worklog
		 * @param model
		 * @return
		 * 修改日志
		 */
		@RequestMapping("/updateWorkLog")
		@ResponseBody
		public ResponseResult updateWorkLog(WorkLog worklog,Model model) {
			ResponseResult rr=new ResponseResult();
			if(workLogService.getWorkLogByLogid(worklog.getLogId())!=null) {
				workLogService.updateWorkLog(worklog);
				rr.setStateCode(1);
			}else {
				rr.setMessage("修改失败");
				rr.setStateCode(0);
			}
			return rr;
		}
		/**
		 * @param workLogInfo
		 * @param model
		 * @return
		 * 模糊查询
		 */
		
		@RequestMapping("/selectLikeWorkLog")
		public String selectLikeWorkLog(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String workLogInfo,
				String startTime,String endTime,Model model,HttpSession session) {
			ResponseResult rr=new ResponseResult();
			User user=(User) session.getAttribute("user");
			try {
				// startPage后紧跟着的就是一个分页查询
				PageHelper.startPage(pageNo, pageSize);
				List<WorkLog> workLoglist =workLogService.selectList(user.getUid(),workLogInfo,startTime,endTime);
				
				if(workLoglist.size()>0) {
					rr.setStateCode(1);
				}else {
					rr.setStateCode(0);
					rr.setMessage("未查询到数据");
				}
				// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
				PageInfo<WorkLog> page = new PageInfo<WorkLog>(workLoglist, 3);
				model.addAttribute("pageInfo", page);
				model.addAttribute("workLoglist",workLoglist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "personSetting/workLog";
		}
		
	}
