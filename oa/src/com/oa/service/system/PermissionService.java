package com.oa.service.system;

import java.util.List;

import com.oa.bean.Permission;

public interface PermissionService {
	
	//获得权限列表
	List<Permission> getPermissionList(String queryStr);
	
	//保存权限
	int savePermission(Permission permission);
	//更新权限
	int updatePermission(Permission permission);
	
	//获得权限对象
	Permission getPermission(Integer id);
	//批量删除
	void deletePermissionBatch(List<Integer> listId);
	//单个删除
	void deletePermission(Integer id);
	
	

}
