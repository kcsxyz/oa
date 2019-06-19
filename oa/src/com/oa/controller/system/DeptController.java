package com.oa.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Dept;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.service.system.DeptService;

/**
 * 系统设置
 * @author PTB
 *
 */
@Controller
@RequestMapping("system")
public class DeptController {
	
	@Resource
	private DeptService deptService;
	
	
	/**验证部门明是否存在
	 * @param deptName
	 * @return
	 */
	@RequestMapping("/checkDeptName")
	@ResponseBody
	public ResponseResult checkDeptName(String deptName) {
		ResponseResult rr = new ResponseResult();
		int re= deptService.checkDeptName(deptName);
		if(re==1) {
			rr.setMessage("部门名称已存在");
			rr.setStateCode(0);
		}else {
			rr.setStateCode(1);
		}
		return rr;
	}
	/**根据id删除部门
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteDept/{ids}")
	@ResponseBody
	public ResponseResult deleteDept(@PathVariable("ids") String ids) {
		ResponseResult rr = new ResponseResult();
		List<User> listUser=null;
		// 批量刪除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String id : split_ids) {
				listId.add(Integer.parseInt(id));
				listUser = deptService.getUserList(Integer.parseInt(id));
				if(listUser.size()>0) {
					rr.setStateCode(0);
					rr.setMessage("部门已在使用中。。。");
					return rr;
				}
				deptService.deleteDeptBatch(listId);
			}
			return rr.success();
		// 单个删除
		} else {
			Integer id = Integer.parseInt(ids);
			listUser = deptService.getUserList(id);
			if(listUser.size()>0) {
				rr.setStateCode(0);
				rr.setMessage("部门已在使用中。。。");
				return rr;
			}
			deptService.deleteDept(id);
			return rr.success();
		}
			
	}
	
	/**修改部门
	 * @param dept
	 * @return
	 */
	@RequestMapping("/updateDeptById")
	@ResponseBody
	public ResponseResult updateDeptById(Dept dept) {
		ResponseResult rr = new ResponseResult();
		int i =deptService.updateDept(dept);
		if(i<0) {
			rr.setStateCode(1);;
		}else {
			rr.setStateCode(0);
			rr.setMessage("更新失败");
		}
		return rr;
	}
	
	
	/**保存部门
	 * @param dept
	 * @return
	 */
	@RequestMapping("/saveDept")
	@ResponseBody
	public ResponseResult saveDept(Dept dept) {
		System.out.println(dept.getDeptName());
		ResponseResult rr = new ResponseResult();
		int i =deptService.saveDept(dept);
		System.out.println(i);
		if(i<0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
		}
		return rr;
	}
	
	/**获取部门列表
	 * @return
	 */
	@RequestMapping("/getDeptList")
	@ResponseBody
	public ResponseResult deptList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		
		ResponseResult rr = new ResponseResult();
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<Dept> listDept = deptService.getDeptList();
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<Dept> pageInfo = new PageInfo<Dept>(listDept, 3);
			rr.add("pageInfo", pageInfo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rr;
	}
	
	
	/**通过部门id获取部门
	 * @param deptId
	 */
	@RequestMapping("/getDeptById")
	@ResponseBody
	public ResponseResult getDeptById(Integer id) {
		ResponseResult rr = new ResponseResult();
		Dept dept = deptService.getDeptById(id);
		System.out.println(dept.getDeptName()+"");
		rr.add("dept", dept);
		return rr;
	}
	
	/**跳转到部门页面
	 * @return
	 */
	@RequestMapping("/deptPage")
	public String deptPage() {
		
		return "/system/dept";
	}
}
