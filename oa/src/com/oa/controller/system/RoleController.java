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
import com.oa.bean.RolePermission;
import com.oa.bean.User;
import com.oa.service.system.RoleService;

@Controller
@RequestMapping("system")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	
	
	/**保存角色权限
	 * @param role
	 * @param ids
	 * @return
	 */
	@RequestMapping("/saveRolePermission")
	@ResponseBody
	public ResponseResult saveRolePermission(Role role,Integer[] ids) {
		ResponseResult rr =new ResponseResult();
		int i =0;
		System.out.println("-------"+role.getRoleId());
		i = roleService.updateRolePermission(role,ids);
		rr.setStateCode(1);
		//如果是当前角色，则刷新当前角色权限
		
		return rr;
	}
	/**通过id获取角色
	 * @param id
	 * @return
	 */
	@RequestMapping("/getRoleByIdWithPerm")
	@ResponseBody
	public ResponseResult getRoleByIdWithPerm(Integer id) {
		ResponseResult rr =new ResponseResult();
		Role role = roleService.getRoleByIdWithPerm(id);
		if(role != null) {
			rr.add("role", role);
			rr.setStateCode(1);
			return rr;
		}else {
			rr.setStateCode(0);
			return rr;
		}
	}
	
	/**通过id获取角色
	 * @param id
	 * @return
	 */
	@RequestMapping("/getRoleById")
	@ResponseBody
	public ResponseResult getRoleById(Integer id) {
		ResponseResult rr =new ResponseResult();
		Role role = roleService.getRoleById(id);
		if(role != null) {
			rr.add("role", role);
			rr.setStateCode(1);
			System.out.println(role.toString());
			return rr;
		}else {
			rr.setStateCode(0);
			return rr;
		}
	}
	/**验证全线
	 * @param roleName
	 * @return
	 */
	@RequestMapping("/checkroleName")
	@ResponseBody
	public ResponseResult checkroleName(String roleName) {
		ResponseResult rr =new ResponseResult();
		boolean  flag = roleService.checkRoleName(roleName);
		if(flag) {
			rr.setStateCode(0);
			rr.setMessage("该角色已存在");
		}else {
			rr.setStateCode(1);
		}
		return rr;
	}
	
	/**跳转到权限页面
	 * @return
	 */
	@RequestMapping("/rolePage")
	public String rolePage() {
		
		return "system/role";
	}
	
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
				List<User> listUser = roleService.getUserList(Integer.parseInt(id));
	 			if(listUser.size()>0) {
	 				rr.setStateCode(0);
	 				rr.setMessage("你所选中的角色已有在使用中,无法删除");
	 				return rr;
	 			}
			}
			
			roleService.deleteRoleBacth(listId);
		//单个删除
 		}else {
 			Integer id = Integer.parseInt(ids);
 			//如果角色在使用中则不能删除
 			List<User> listUser = roleService.getUserList(id);
 			if(listUser.size()>0) {
 				rr.setStateCode(0);
 				rr.setMessage("该角色已在使用中,无法删除");
 				return rr;
 			}
 			roleService.deleteRole(id);
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
		if(i<0) {
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
		if(i<0) {
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
	@ResponseBody
	public ResponseResult getRoleList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String queryStr, Model model) {
		ResponseResult rr =new ResponseResult();
		PageHelper.startPage(pageNo, pageSize);
		List<Role> roleList = roleService.getRolelist(queryStr);
		PageInfo<Role> pageInfo = new PageInfo<>(roleList, 3);
		rr.add("pageInfo", pageInfo);
		return rr;
		
	}

}
