package com.oa.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping("/loadPermission")
	@ResponseBody
	public Object loadPermission() {	
		List<Permission> permissions = new ArrayList<Permission>();
		
		//获取所有的权限
		List<Permission> ps = permissionService.getParentPermissionList();
		
		Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
		
		//把已查询的权限放到map中
		for (Permission p : ps) {
			permissionMap.put(p.getPermId(), p);
		}
		
		for (Permission p : ps) {
			Permission child = p;
			if (child.getParentId() == 0) {
				permissions.add(p);
			} else {
				Permission parent = permissionMap.get(child.getParentId());
				parent.getChildren().add(child);	
			}
		}
		return permissions;
	}
	/**跳转到菜单页面
	 * @return
	 */
	@RequestMapping("/permissionPage")
	public String permissionPage() {
		
		return "/system/permission";
	}
	/**
	 * 获取权限列表
	 * @param pageNo
	 * @param pageSize
	 * @param queryStr
	 * @param model
	 * @return
	 */
	@RequestMapping("/permissionList")
	@ResponseBody
	public ResponseResult getPermissionList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String queryStr) {
		
		ResponseResult rr =new ResponseResult();
		PageHelper.startPage(pageNo, pageSize);
		List<Permission>  listPermission = permissionService.getPermissionList(queryStr);
		PageInfo<Permission> pageInfo = new PageInfo<Permission>(listPermission,3);
		rr.add("pageInfo", pageInfo);
		return rr;
		
	}
	
	@RequestMapping("/savePermission")
	@ResponseBody
	public ResponseResult savePermission(Permission permission) {
		ResponseResult rr =new ResponseResult();
		int i = permissionService.savePermission(permission);
		if(i<0) {
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
		if(i<0) {
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
