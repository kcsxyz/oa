package com.oa.controller.process;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Audit;
import com.oa.bean.Leave;
import com.oa.bean.Permission;
import com.oa.bean.Process;
import com.oa.bean.ProcessLine;
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
	
	/**流程审核
	 * @param leaveId
	 * @param currentNo
	 * @param opinion
	 * @param status
	 * @return
	 */
	@RequestMapping("/updateProcess")
	@ResponseBody
	public ResponseResult updateProcess(Integer leaveId,Integer currentNo,String opinion,String status,
			boolean isGreaterThree,String processNo,HttpSession session) {
		ResponseResult rr =new ResponseResult();
		User user = (User) session.getAttribute("user");
		//如果是总经理或老板审批或时间小于3天则流程结束，没有下一步
		//如果是部门经理审批且时间大于三天则总经理审批
		Integer proNodeId = 0;
		//根据状态决定是否结束或往下
		Leave leave = new Leave();
		System.out.println(user.getName());
		System.out.println(user.getRole().getRoleName());
		if(status == "通过") {
			if(user.getRole().getRoleName().equals("部门经理") && isGreaterThree) {
				//插入数据到流程节点表
				ProcessNode proNo = new ProcessNode(processNo, "总经理审批", "总经理", "提交总经理审批");
				processSerivce.saveProcessNode(proNo);
				proNodeId = processSerivce.getProcessNodeId(processNo,"总经理");
				//保存流程线表
				ProcessLine pl = new ProcessLine();
				pl.setPreNodeId(currentNo);
				pl.setNextNodeId(proNodeId);
				processSerivce.saveProcessLine(pl);
				
				//保存请假的状态
				leave.setId(leaveId);
				leave.setCurrentNo(proNodeId);
				processSerivce.updateLeave(leave);
				
			}else if(user.getRole().getRoleName().equals("总经理") && isGreaterThree) {
				//插入数据到流程节点表
				ProcessNode proNo = new ProcessNode(processNo, "老板审批", "Boss", "提交老板审批");
				processSerivce.saveProcessNode(proNo);
				proNodeId = processSerivce.getProcessNodeId(processNo,"Boss");
				//保存流程线表
				ProcessLine pl = new ProcessLine();
				pl.setPreNodeId(currentNo);
				pl.setNextNodeId(proNodeId);
				processSerivce.saveProcessLine(pl);
				
				//保存请假的状态
				leave.setId(leaveId);
				leave.setCurrentNo(proNodeId);
				processSerivce.updateLeave(leave);
			}else{//这里就是通过，流程审批结束，保存请假和审批意见
				//保存请假的状态
				leave.setId(leaveId);
				leave.setStatus(status);
				leave.setCurrentNo(proNodeId);
				processSerivce.updateLeave(leave);
				
			}/*若要增加审批手续可在这里继续判断*/
			
			
			
		}else if(status == "驳回") {
			//保存请假的状态
			leave.setId(leaveId);
			leave.setStatus(status);
			leave.setCurrentNo(proNodeId);
			processSerivce.updateLeave(leave);
		}else if(status == "拒绝") {
			//保存请假的状态
			leave.setId(leaveId);
			leave.setStatus(status);
			leave.setCurrentNo(proNodeId);
			processSerivce.updateLeave(leave);
		}
		//保存审批意见
		Audit au = new Audit();
		au.setAuditUserId(user.getUid());
		au.setAuditName(user.getName());
		au.setAuditOpinion(opinion);
		au.setAuditDate(timeConvert.getDateSecond());
		processSerivce.insertAudit(au);
		
		rr.setStateCode(1);
		return rr;
	}
	
	@RequestMapping("/getLeaveById")
	@ResponseBody
	public ResponseResult getLeaveById(Integer id) {
		ResponseResult rr =new ResponseResult();
		Leave leave = processSerivce.getLeaveById(id);
		rr.add("leave", leave);
		return rr;
	}
	/**流程审批页面
	 * @return
	 */
	@RequestMapping("processAudit")
	public String processAudit() {
		
		return "process/processAudit";
	}
	
	
	/**得到待审批的记录
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @param queryStr
	 * @param session
	 * @return
	 */
	@RequestMapping("/getAuditList")
	@ResponseBody
	public ResponseResult getAuditList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,String type, String queryStr,HttpSession session){
		ResponseResult rr =new ResponseResult();
		
		//通过用户id获取相应的请假表
		User user = (User) session.getAttribute("user");
		//根据角色获取本部门状态为0的请假申请
		//如果是部门经理
		//测试用
		//PageHelper.startPage(pageNo, pageSize);
		//List<Leave> leaveList = processSerivce.getNeedAuditLeaveList(queryStr,2,user.getRole().getRoleName());
		//System.out.println(leaveList==null);
		List<Leave> leaveList = null;
		if(user.getRole().getRoleName().equals("部门经理")) {
			PageHelper.startPage(pageNo, pageSize);	
			leaveList = processSerivce.getNeedAuditLeaveList(queryStr,user.getDeptId(),"部门经理");
			//如果是总经理
		}else if(user.getRole().getRoleName().equals("总经理")){
			PageHelper.startPage(pageNo, pageSize);
			leaveList = processSerivce.getAuditLeaveList(queryStr,"总经理");
		}else {//如果是老板
			leaveList = processSerivce.getAuditLeaveList(queryStr,"Boos");
		}
		
		
		PageInfo<Leave> pageInfo = new PageInfo<Leave>(leaveList,3);
		rr.add("pageInfo", pageInfo);
		return rr;
	}
	
	/*-------请假申请---------*/
	
	/**撤销申请
	 * @param processNo
	 * @return
	 */
	@RequestMapping("/deleteLeave")
	@ResponseBody
	public ResponseResult deleteLeave(String processNo,Integer leaveId) {
		ResponseResult rr =new ResponseResult();
		//删除请假表
		processSerivce.deleteLeave(processNo);
		//删除流程节点表
		processSerivce.deleteProcessNode(processNo);
		//删除流程线表
		processSerivce.deleteProcessLine(processNo);
		//删除审批表
		processSerivce.deleteAudit(leaveId);
		return rr;
	}
	/**跳转到请假页面
	 * @return
	 */
	@RequestMapping("/leavePage")
	public String leavePage() {
		
		return "/process/leave";
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
		List<Leave> leaveList = processSerivce.getLeaveList(type,queryStr,startTime,endTime,"oa1111");
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
		//1.员工请假
		//返回流程节点
		Integer processNodeId = 0;
		
		if(user.getRole().getRoleName().equals("员工")) {
			System.out.println(user.getRole().getRoleName());
			Process process = new Process(processNo, "请假申请", "提交部门经理审批");
			processSerivce.saveProcess(process);
			
			//插入流程节点
			ProcessNode pn = new ProcessNode(processNo, "请假申请", "部门经理", "提交部门经理审批");
			processSerivce.saveProcessNode(pn);
			/*------------获得节点的id-------------*/
			processNodeId = processSerivce.getProcessNodeId(processNo,"部门经理");
			
			leave.setUserId(user.getUid());
			leave.setUserName(user.getName());
			leave.setCreateTime(new Date());
			leave.setProcessNo(processNo);
			leave.setCurrentNo(processNodeId);
			leave.setStatus("部门经理审批中");
			processSerivce.saveLeave(leave);
		//2.部门经理请假
		}else if(user.getRole().getRoleName().equals("部门经理")) {
			Process process = new Process(processNo, "请假申请", "提交总经理审批");
			processSerivce.saveProcess(process);
			
			ProcessNode pn = new ProcessNode(processNo, "请假申请", "总经理", "提交总经理审批");
			processSerivce.saveProcessNode(pn);
			
			leave.setUserId(user.getUid());
			leave.setUserName(user.getName());
			leave.setCreateTime(new Date());
			leave.setProcessNo(processNo);
			leave.setCurrentNo(processNodeId);
			leave.setStatus("总经理审批中");
			processSerivce.saveLeave(leave);
			/*------------获得节点的id-------------*/
			processNodeId = processSerivce.getProcessNodeId(processNo,"总经理");
		}else if(user.getRole().getRoleName().equals("总经理")) {
			Process process = new Process(processNo, "请假申请", "提交老板审批");
			processSerivce.saveProcess(process);
			
			ProcessNode pn = new ProcessNode(processNo, "请假申请", "Boss", "提交老板审批");
			processSerivce.saveProcessNode(pn);
			/*------------获得节点的id-------------*/
			processNodeId = processSerivce.getProcessNodeId(processNo,"Boss");
			
			leave.setUserId(user.getUid());
			leave.setUserName(user.getName());
			leave.setCreateTime(new Date());
			leave.setProcessNo(processNo);
			leave.setCurrentNo(processNodeId);
			leave.setStatus("老板审批中");
			processSerivce.saveLeave(leave);
		}else {
			rr.setStateCode(0);
			rr.setMessage("请假异常。。。");
			return rr;
		}
		
		//保存请假实体
		rr.setStateCode(1);
		return rr;
	}
}
