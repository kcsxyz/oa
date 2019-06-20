package com.oa.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.oa.bean.Permission;
import com.oa.bean.ResponseResult;
import com.oa.bean.RolePermission;
import com.oa.bean.User;
import com.oa.service.system.PermissionService;

@Controller
@RequestMapping("system")
public class PermissionController {
	@Resource
	private PermissionService permissionService;
	
	
	@RequestMapping("/permissionMenu")
	@ResponseBody
	public ResponseResult permissionMenu(HttpSession session) {
		ResponseResult rr =new ResponseResult();
		List<Permission> permissions = new ArrayList<Permission>();
		User user = (User) session.getAttribute("user");
		if(user != null) {
			List<Permission> permissionList = permissionService.getPermissionListByUserRole(user.getRoleId());
			Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
			Permission root = null;
			Set<String> uriSet = new HashSet<String>();
			for (Permission permission : permissionList) {
				permissionMap.put(permission.getPermId(), permission);
				if (permission.getUrl() != null && !"".equals(permission.getUrl())) {
					uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
				}
			}
			if(session.getAttribute("authUriSet")!=null) {
				session.removeAttribute("authUriSet");
			}
			session.setAttribute("authUriSet", uriSet);
			for (Permission permission : permissionList) {
				Permission child = permission;
				if (child.getParentId() == 0) {
					permissions.add(permission);
				} else {
					Permission parent = permissionMap.get(child.getParentId());
					
					if(child.getPermName().equals("项目管理") || child.getPermName().equals("文件管理")) {
						if(user.getRole().getRoleName().equals("员工") && user.getDept().getDeptName().equals("办公室")) {
							continue;
						}
					}
					if(child.getPermName().equals("项目管理") ||child.getPermName().equals("文件管理")) {
						if(user.getRole().getRoleName().equals("部门经理") && user.getDept().getDeptName().equals("开发部")) {
							continue;
						}
					}
					if(child.getPermName().equals("人力资源管理") ||child.getPermName().equals("考勤记录")) {
						if(user.getRole().getRoleName().equals("部门经理") && user.getDept().getDeptName().equals("办公室")) {
							continue;
						}
					}
					if(child.getPermName().equals("人力资源管理") ||child.getPermName().equals("考勤记录")) {
						if(user.getRole().getRoleName().equals("员工") && user.getDept().getDeptName().equals("办公室")) {
							continue;
						}
					}
					
					if(child.getPermName().equals("项目管理")) {
						if(user.getRole().getRoleName().equals("员工")) {
							continue;
						}
					}
					
					/*if(user.getRole().getRoleName().equals("员工") && user.getDept().getDeptName().equals("办公室")) {
						
					}*/
					
					parent.getChildren().add(child);
				}
			}
			//session.setAttribute("rootPermission", root);
			rr.add("permissions", permissions);
			rr.setStateCode(1);
		}
		return rr;
	}
	
	/**验证权限名是否存在
	 * @return
	 */
	@RequestMapping("/checkPermName")
	@ResponseBody
	public ResponseResult checkPermName(String permName,Integer parentId) {
		ResponseResult rr =new ResponseResult();
		boolean  flag = permissionService.checkPermName(permName,parentId);
		if(flag) {
			rr.setStateCode(0);
			rr.setMessage("该菜单已存在");
		}else {
			rr.setStateCode(1);
		}
		return rr;
	}
	
	
	/**加载所有权限
	 * @return
	 */
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
		if(permission.getParentId() == null) {
			permission.setParentId(0);
		}
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
	@ResponseBody
	public ResponseResult getPermissionById(Integer id) {
		ResponseResult rr =new ResponseResult();
		Permission permission = permissionService.getPermission(id);
		if(permission.getParentId() != 0) {
			Permission pPermission = permissionService.getPermission(permission.getParentId());
			permission.setPermission(pPermission);
		}
		rr.add("permission", permission);
		return rr;
	}
	
	@RequestMapping("/deleterPermission/{ids}")
	@ResponseBody
	public ResponseResult deletePermission(@PathVariable("ids") String ids) {
		ResponseResult rr =new ResponseResult();
		List<RolePermission> rolePermissionList = null;
		List<Permission> listPermission = null;
		if(ids.contains("-")) {
			String[] split_ids = ids.split("-");
			List<Integer> listId = new ArrayList<Integer>();
			for(String id : split_ids) {
				listId.add(Integer.parseInt(id));
				rolePermissionList = permissionService.getRolePermissionList(Integer.parseInt(id));
				if(rolePermissionList!=null) {
					rr.setStateCode(0);
					rr.setMessage("菜单已在使用中。。。");
					return rr;
				}
				
				listPermission = permissionService.getParPermission(Integer.parseInt(id));
				if(listPermission!=null) {
					rr.setStateCode(0);
					rr.setMessage("该菜单已有子菜单，您无法删除");
					return rr;
				}
				
			}
			permissionService.deletePermissionBatch(listId);
			return rr.success();
		}else {
			Integer id = Integer.parseInt(ids);
			rolePermissionList = permissionService.getRolePermissionList(id);
			if(rolePermissionList!=null) {
				rr.setStateCode(0);
				rr.setMessage("菜单已在使用中。。。");
				return rr;
			}
			
			listPermission = permissionService.getParPermission(id);
			if(listPermission!=null) {
				rr.setStateCode(0);
				rr.setMessage("该菜单已有子菜单，您无法删除");
				return rr;
			}
			listPermission = permissionService.getParPermission(id);
			permissionService.deletePermission(id);
			return rr.success();
		}
		
	}

}
