package com.oa.controller.personSetting;

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
		public String selectAllWorkLog(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
			
			try {
				// startPage后紧跟着的就是一个分页查询
				PageHelper.startPage(pageNo, pageSize);
				List<WorkLog> workLoglist = workLogService.selectWorkLog();	
				for (WorkLog workLog : workLoglist) {
					System.out.println(workLog);
				}
				// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
				PageInfo<WorkLog> page = new PageInfo<WorkLog>(workLoglist, 3);
				model.addAttribute("pageInfo", page);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return "workLoglist";			
		}
		
		
	}
