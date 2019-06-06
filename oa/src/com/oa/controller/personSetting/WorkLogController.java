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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.bean.WorkLog;
import com.oa.service.personSetting.WorkLogService;
import com.oa.utils.md5;
	
	@Controller
	@RequestMapping("workLog")
	public class WorkLogController {
		@Resource
		private WorkLogService workLogService;
		/**
		 * @param model
		 * @return
		 * 查询所有工作日志
		 */
		@RequestMapping("/workLoglist")
		@ResponseBody
		public ResponseResult selectAllWorkLog(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
			ResponseResult rr=new ResponseResult();
			try {
				// startPage后紧跟着的就是一个分页查询
				PageHelper.startPage(pageNo, pageSize);
				List<WorkLog> workLoglist = workLogService.selectWorkLog();	
				if(workLoglist.size()>0) {
					rr.setStateCode(1);
				}else {
					rr.setStateCode(0);
					rr.setMessage("未查询到数据");
				}
				for (WorkLog workLog : workLoglist) {
					//System.out.println(workLog);
				}
				// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
				PageInfo<WorkLog> page = new PageInfo<WorkLog>(workLoglist, 3);
				model.addAttribute("pageInfo", page);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
						
			return rr;			
		}
		/**
		 * @param logId
		 * @param model
		 * @return
		 * 根据id查询日志
		 */
		@RequestMapping("/getWorkLogById")
		@ResponseBody
		public ResponseResult getWorkLogById(Integer logId,Model model) {
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
			
			return rr;
		}
		/**
		 * @param workLog
		 * @param model
		 * @return
		 * 新增日志
		 */
		@RequestMapping("/addWorkLog")
		@ResponseBody
		public ResponseResult addWorkLog(WorkLog workLog,Model model) {
			ResponseResult rr=new ResponseResult();
			if(workLogService.getWorkLogByLogid(workLog.getLogId())==null) {
				workLog.setCreateTime(new Date());				
				int i=workLogService.addWorkLog(workLog);
				if(i<0) {
					model.addAttribute("workLog", workLog);
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
		/**
		 * @param logId
		 * @return
		 * 删除日志
		 */
		@RequestMapping("/deleteWorkLog")
		@ResponseBody
		public ResponseResult deleteWorkLog(String logId) {
			ResponseResult rr = new ResponseResult();
			String ids=logId;
			//批量删除
			if (ids.contains("-")) {
				List<Integer> listId = new ArrayList<>();
				String[] split_ids = ids.split("-");
				for (String string : split_ids) {
					listId.add(Integer.parseInt(string));
					workLogService.deleteDeptBatch(listId);
				}
				rr.setStateCode(1);
			// 单个删除
			} else {
				Integer id = Integer.parseInt(ids);
				workLogService.deleteWorkLog(id);;
				rr.setStateCode(1);
					}
			return rr;			
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
			worklog.setLogId(1);
			worklog.setTitle("35454");
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
		@ResponseBody
		public ResponseResult selectLikeWorkLog(String workLogInfo,String startTime,String endTime,Model model) {
			ResponseResult rr=new ResponseResult();
			List<WorkLog> workLoglist = workLogService.selectLikeWorkLog(workLogInfo,startTime,endTime);
			model.addAttribute("workLoglist",workLoglist);
	       /*for (WorkLog workLog : workLoglist) {
			System.out.println(workLog);
	       }*/
			if(workLoglist.size()>0) {
				rr.setStateCode(1);
			}else {
				rr.setStateCode(0);
				rr.setMessage("未查询到数据");
			}
			
			return rr;			
		}
		
		
	}
