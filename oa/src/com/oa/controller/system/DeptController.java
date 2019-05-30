package com.oa.controller.system;

import java.util.ArrayList;
import java.util.List;

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
	
	/**根据id删除部门
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteDept/{ids}")
	@ResponseBody
	public ResponseResult deleteDept(@PathVariable("ids") String ids) {
		ResponseResult rr = new ResponseResult();
		// 批量刪除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(Integer.parseInt(string));
				deptService.deleteDeptBatch(listId);
			}
		// 单个删除
		} else {
			Integer id = Integer.parseInt(ids);
			deptService.deleteDept(id);
				}
		return rr.success();	
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
		if(i>0) {
			rr.setStateCode(1);;
		}else {
			rr.setStateCode(0);
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
		ResponseResult rr = new ResponseResult();
		int i =deptService.saveDept(dept);
		if(i>0) {
			rr.setStateCode(1);;
		}else {
			rr.setStateCode(0);
		}
		return rr;
	}
	
	/**获取部门列表
	 * @return
	 */
	@RequestMapping("/getDeptList")
	public String deptList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<Dept> listDept = deptService.getDeptList();
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<Dept> page = new PageInfo<Dept>(listDept, 3);
			model.addAttribute("pageInfo", page);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "/getDeptList";
	}
	
	
	/**通过部门id获取部门
	 * @param deptId
	 */
	@RequestMapping("/getDept/{id}")
	public String getDeptById(@PathVariable("id") Integer id,Model model) {
		Dept dept = deptService.getDeptById(id);
		model.addAttribute("dept", dept);
		return "getDept";
	}
	
	
}
