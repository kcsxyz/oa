package com.oa.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Permission;
import com.oa.bean.PermissionExample;
import com.oa.bean.PermissionExample.Criteria;
import com.oa.bean.RolePermission;
import com.oa.dao.PermissionMapper;
import com.oa.service.system.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> getPermissionList(String queryStr) {
		List<Permission> listPermission = null;
		List<Permission> parentPermission = null;
		if(queryStr != "" && queryStr != null) {
			PermissionExample pe = new PermissionExample();
			Criteria ct = pe.createCriteria();
			ct.andPermNameLike("%"+queryStr+"%");	
			 listPermission = permissionMapper.selectByExample(pe);
			return listPermission;
		}else {
			System.out.println("here");
			 listPermission = permissionMapper.selectByExample(null);
			
		}
		//拿到所有节点
		parentPermission = permissionMapper.selectByExample(null);
		Permission p = new Permission();
		for(int i =0;i<listPermission.size();i++) {
			for(int j =0;j<parentPermission.size();j++) {
				if(listPermission.get(i).getParentId()==parentPermission.get(j).getPermId()) {
					listPermission.get(i).setPermission(parentPermission.get(j));
				}else if(listPermission.get(i).getParentId()==0){
					listPermission.get(i).setPermission(p);
					listPermission.get(i).getPermission().setPermName(" ");
				}
			}
		}
		
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
	
	
	@Override
	public List<Permission> getParentPermissionList() {
		List<Permission> listPermission = permissionMapper.selectByExample(null);
		return listPermission;
	}

	@Override
	public boolean checkPermName(String permName, Integer parentId) {
		PermissionExample pe = new PermissionExample();
		Criteria ct = pe.createCriteria();
		ct.andPermNameEqualTo(permName);
		ct.andParentIdEqualTo(parentId);
		List<Permission> list = permissionMapper.selectByExample(pe);
		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Permission> getPermissionListByUserRole(Integer roleId) {
		
		List<Permission> listPermission = permissionMapper.getPermissionListByUserRole(roleId);
		return listPermission;
	}

	@Override
	public List<RolePermission> getRolePermissionList(Integer id) {
		List<RolePermission> list = permissionMapper.getRolePermission(id);
		return list;
	}

	@Override
	public List<Permission> getParPermission(Integer id) {
		List<Permission> list = permissionMapper.getParPermissionList(id);
		return list;
	}
	

	
	
}
