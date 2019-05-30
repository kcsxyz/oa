package com.oa.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Permission;
import com.oa.bean.ResponseResult;
import com.oa.service.system.PermissionService;

@Controller
@RequestMapping("system")
public class PermissionController {
	@Resource
	private PermissionService permissionService;
	
	/**
	 * 获取权限列表
	 * @param pageNo
	 * @param pageSize
	 * @param queryStr
	 * @param model
	 * @return
	 */
	@RequestMapping("/permissionList")
	public String getPermissionList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String queryStr, Model model) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<Permission>  listPermission = permissionService.getPermissionList(queryStr);
		PageInfo<Permission> page = new PageInfo<Permission>(listPermission,3);
		model.addAttribute("page", page);
		return "permissionList";
		
	}
	
	@RequestMapping("/savePermission")
	@ResponseBody
	public ResponseResult savePermission(Permission permission) {
		ResponseResult rr =new ResponseResult();
		int i = permissionService.savePermission(permission);
		if(i>0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
		}
		return rr;
	}
	
	/**更新权限
	 * @param permission
	 * @return
	 */
	@RequestMapping("/updatePermission")
	@ResponseBody
	public ResponseResult updatePermission(Permission permission) {
		ResponseResult rr =new ResponseResult();
		int i = permissionService.updatePermission(permission);
		if(i>0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
		}
		return rr;
	}
	
	/**获取权限对象
	 * @param id
	 * @return
	 */
	@RequestMapping("/getPermission")
	public String getPermissionById(Integer id,Model model) {
		Permission permission = permissionService.getPermission(id);
		model.addAttribute("permission", permission);
		return "permissionPage";
	}
	
	@RequestMapping("/deleterPermission")
	@ResponseBody
	public ResponseResult deletePermission(String ids) {
		ResponseResult rr =new ResponseResult();
		if(ids.contains("-")) {
			String[] split_ids = ids.split("-");
			List<Integer> listId = new ArrayList<Integer>();
			for(String id : split_ids) {
				listId.add(Integer.parseInt(id));
			}
			permissionService.deletePermissionBatch(listId);
		}else {
			Integer id = Integer.parseInt(ids);
			permissionService.deletePermission(id);
		}
		return rr;
	}

}
