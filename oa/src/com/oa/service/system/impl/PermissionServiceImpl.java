package com.oa.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Permission;
import com.oa.bean.PermissionExample;
import com.oa.bean.PermissionExample.Criteria;
import com.oa.dao.PermissionMapper;
import com.oa.service.system.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> getPermissionList(String queryStr) {
		PermissionExample pe = new PermissionExample();
		Criteria ct = pe.createCriteria();
		ct.andPermNameLike("%"+queryStr+"%");		
		List<Permission> listPermission = permissionMapper.selectByExample(pe);
		return listPermission;
	}

	@Override
	public int savePermission(Permission permission) {
		int i = permissionMapper.insert(permission);
		return i;
	}

	@Override
	public int updatePermission(Permission permission) {
		int i = permissionMapper.updateByPrimaryKey(permission);
		return i;
	}

	@Override
	public Permission getPermission(Integer id) {
		Permission perm = permissionMapper.selectByPrimaryKey(id);
		return perm;
	}

	@Override
	public void deletePermissionBatch(List<Integer> listId) {
		PermissionExample pe = new PermissionExample();
		Criteria ct = pe.createCriteria();
		ct.andPermIdIn(listId);
		permissionMapper.deleteByExample(pe);
	}

	@Override
	public void deletePermission(Integer id) {
		permissionMapper.deleteByPrimaryKey(id);
	}
	

	
	
}
