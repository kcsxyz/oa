package com.oa.service.system;

import java.util.List;

import com.oa.bean.Role;

public interface RoleService {
	
	//获取角色列表
	List<Role> getRolelist(String queryStr);
	
	//保存角色
	int saveRole(Role role);
	
	//修改角色
	int updateRole(Role role);
	
	//删除单个角色
	void deleteRole(int parseInt);
	
	//批量删除
	void deleteRoleBacth(List<Integer> listId);

}
