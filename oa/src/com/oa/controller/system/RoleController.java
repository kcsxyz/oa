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
import com.oa.bean.ResponseResult;
import com.oa.bean.Role;
import com.oa.service.system.RoleService;

@Controller
@RequestMapping("system")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("/deleteRole/{ids}")
	@ResponseBody
	public ResponseResult deleteRole(@PathVariable("ids") String ids) {
		ResponseResult rr = new ResponseResult();
		//批量删除
		if(ids.contains("-")) {
			List<Integer> listId = new ArrayList<Integer>();
			String[] splits_ids = ids.split("-");
			for(String id :splits_ids) {
				listId.add(Integer.parseInt(id));
			}
			roleService.deleteRoleBacth(listId);
		//单个删除
 		}else {
 			roleService.deleteRole(Integer.parseInt(ids));
 		}
		
		return rr;
		
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public ResponseResult updateRole(Role role) {
		ResponseResult rr = new ResponseResult();
		int i = roleService.updateRole(role);
		if(i>0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
		}
		return rr;
	}
	
	/**保存角色
	 * @param role
	 * @return
	 */
	@RequestMapping("/saveRole")
	@ResponseBody
	public ResponseResult saveRole(Role role) {
		ResponseResult rr = new ResponseResult();
		int i = roleService.saveRole(role);
		if(i>0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
		}
		return rr;
	}
	/**
	 * 获取所有角色
	 * @param pageNo
	 * @param pageSize
	 * @param queryStr
	 * @param model
	 * @return
	 */
	@RequestMapping("/getRoleList")
	public String RoleList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String queryStr, Model model) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<Role> roleList = roleService.getRolelist(queryStr);
		PageInfo<Role> page = new PageInfo<>(roleList, 3);
		model.addAttribute("page", page);
		return "roleList";
		
	}

}
