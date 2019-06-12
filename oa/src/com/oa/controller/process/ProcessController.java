package com.oa.controller.process;

import java.util.ArrayList;
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
import com.oa.bean.Audit;
import com.oa.bean.Leave;
import com.oa.bean.Permission;
import com.oa.bean.Process;
import com.oa.bean.ProcessNode;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.service.process.ProcessService;
import com.oa.utils.timeConvert;

@Controller
@RequestMapping("process")
public class ProcessController {
	@Resource
	private ProcessService processSerivce;
	
	/*-------流程审批----------*/
	
	/**流程审批页面
	 * @return
	 */
	@RequestMapping("processAudit")
	public String processAudit() {
		
		return "process/processAudit";
	}
	
	@RequestMapping("/getAuditList")
	@ResponseBody
	public ResponseResult getAuditList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,String type, String queryStr,HttpSession session){
		ResponseResult rr =new ResponseResult();
		
		//通过用户id获取相应的请假表
		User user = (User) session.getAttribute("user");
		//根据角色获取本部门状态为0的请假申请
		//如果是部门经理
		PageHelper.startPage(pageNo, pageSize);
		List<Leave> leaveList = processSerivce.getNeedAuditLeaveList(queryStr,user.getDeptId(),"部门经理");
		//如果是总经理
		List<Leave> leaveList2 = processSerivce.getAuditLeaveList(queryStr,"总经理");
		//如果是老板
		
		//PageInfo<Leave> pageInfo = new PageInfo<Leave>(leaveList,3);
		//rr.add("pageInfo", pageInfo);
		return rr;
	}
	
	/*-------请假申请---------*/
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
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,String type, String queryStr,String startTime,String endTime,HttpSession session){
		ResponseResult rr =new ResponseResult();
		//通过用户id获取相应的请假表
		User user = (User) session.getAttribute("user");
		//合并后要改
		PageHelper.startPage(pageNo, pageSize);
		List<Leave> leaveList = processSerivce.getLeaveList(type,queryStr,startTime,endTime,"admin");
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
		//自动生成流程号
		String processNo = "LA"+timeConvert.getTimeStamp();
		User user = (User) session.getAttribute("user");
		//开启流程
		Process process = null;
		//1.员工请假
		if(user.getRole().getRoleName()=="员工") {
			process = new Process(processNo, "请假申请", "提交部门经理审批");
		//2.部门经理请假
		}else if(user.getRole().getRoleName()=="部门经理") {
			process = new Process(processNo, "请假申请", "提交总经理审批");
		}
		
		processSerivce.saveProcess(process);
		//插入流程节点
		ProcessNode pn = new ProcessNode(processNo, "请假申请", "部门经理", "提交部门经理审批");
		processSerivce.saveProcessNode(pn);
		/*------------获得节点的id-------------*/
		Integer processNodeId = processSerivce.getProcessNodeId(processNo);
		//保存请假实体
		
		leave.setUserId(user.getUid());
		leave.setUserName(user.getName());
		leave.setCreateTime(new Date());
		leave.setProcessNo(processNo);
		leave.setCurrentNo(processNodeId);
		leave.setStatus("审核中");
		processSerivce.saveLeave(leave);
		rr.setStateCode(1);
		
		
		return rr;
	}
}
