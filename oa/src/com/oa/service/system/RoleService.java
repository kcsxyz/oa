package com.oa.service.system;

import java.util.List;

import com.oa.bean.Role;
import com.oa.bean.RolePermission;
import com.oa.bean.User;

public interface RoleService {
	
	//获取角色列表
	List<Role> getRolelist(String queryStr);
	
	//保存角色
	int saveRole(Role role);
	
	//修改角色
	int updateRole(Role role);
	
	//删除单个角色
	void deleteRole(Integer id);
	
	//批量删除
	void deleteRoleBacth(List<Integer> listId);

	boolean checkRoleName(String roleName);

	Role getRoleById(Integer id);

	Role getRoleByIdWithPerm(Integer id);

	int updateRolePermission(Role role, Integer[] ids);

	List<User> getUserList(Integer id);

}
