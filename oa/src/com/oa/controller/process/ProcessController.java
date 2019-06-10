package com.oa.controller.process;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Leave;
import com.oa.bean.Permission;
import com.oa.bean.Process;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.service.process.ProcessService;
import com.oa.utils.timeConvert;

@Controller
@RequestMapping("process")
public class ProcessController {
	@Resource
	private ProcessService processSerivce;
	
	/**跳转到请假页面
	 * @return
	 */
	@RequestMapping("/leavePage")
	public String leavePage() {
		
		return "process/leave";
	}
	
	/**得到请假列表
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @param queryStr
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("/getLeaveList")
	@ResponseBody
	public ResponseResult getLeaveList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,String type, String queryStr,String startTime,String endTime){
		ResponseResult rr =new ResponseResult();
		PageHelper.startPage(pageNo, pageSize);
		List<Leave> leaveList = processSerivce.getLeaveList(type,queryStr,startTime,endTime);
		PageInfo<Leave> pageInfo = new PageInfo<Leave>(leaveList,3);
		rr.add("pageInfo", pageInfo);
		return rr;
	}
	
	/**保存请假实例，开启流程
	 * @param leave
	 * @return
	 */
	@RequestMapping("/saveLeave")
	@ResponseBody
	public ResponseResult saveLeave(Leave leave,HttpSession session) {
		ResponseResult rr =new ResponseResult();
		//保存请假实体
		//总动生成流程号
		String peocessNo = "LA"+timeConvert.getTimeStamp();
		User user = (User) session.getAttribute("user");
		leave.setUserId(user.getUid());
		leave.setUserName(user.getName());
		leave.setCreateTime(new Date());
		leave.setProcessNo(peocessNo);
		leave.setStatus("0");
		processSerivce.saveLeave(leave);
		
		com.oa.bean.Process process = new Process(peocessNo, "请假申请", "提交部门经理审批");
		processSerivce.saveProcess(process);
		//根据身份来选择相应的审核人
		//开启流程
		return rr;
	}
}
