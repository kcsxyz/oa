package com.oa.service.system.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Role;
import com.oa.bean.RoleExample;
import com.oa.bean.RoleExample.Criteria;
import com.oa.bean.RolePermission;
import com.oa.bean.RolePermissionExample;
import com.oa.bean.User;
import com.oa.dao.RoleMapper;
import com.oa.dao.RolePermissionMapper;
import com.oa.service.system.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public List<Role> getRolelist(String queryStr) {
		List<Role> roleList = null;
		if(queryStr != null && queryStr != "") {
			RoleExample re = new RoleExample();
			Criteria ct = re.createCriteria();
			ct.andRoleNameLike("%"+queryStr+"%");
			roleList = roleMapper.selectByExample(re);
		}else {
			roleList = roleMapper.selectByExample(null);
		}
		
		return roleList;
	}

	@Override
	public int saveRole(Role role) {
		int i = roleMapper.insert(role);
		return i;
	}

	@Override
	public int updateRole(Role role) {
		int i = roleMapper.updateByPrimaryKey(role);
		return i;
	}

	@Override
	public void deleteRoleBacth(List<Integer> listId) {
		RoleExample re = new RoleExample();
		Criteria ct =re.createCriteria();
		ct.andRoleIdIn(listId);
		roleMapper.deleteByExample(re);
		//删除权限角色表的权限
		for(Integer roleId :listId) {
			RolePermissionExample rp = new RolePermissionExample();
			com.oa.bean.RolePermissionExample.Criteria ctt =rp.createCriteria();
			ctt.andRoleIdEqualTo(roleId);
			rolePermissionMapper.deleteByExample(rp);
		}
	}

	@Override
	public void deleteRole(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
		//删除权限角色表的权限
		RolePermissionExample rp = new RolePermissionExample();
		com.oa.bean.RolePermissionExample.Criteria ct =rp.createCriteria();
		ct.andRoleIdEqualTo(id);
		rolePermissionMapper.deleteByExample(rp);
		
	}

	@Override
	public boolean checkRoleName(String roleName) {
		RoleExample re = new RoleExample();
		Criteria ct =re.createCriteria();
		ct.andRoleNameEqualTo(roleName);
		List<Role> list = roleMapper.selectByExample(re);
		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Role getRoleById(Integer id) {
		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}

	@Override
	public Role getRoleByIdWithPerm(Integer id) {
		Role role = roleMapper.selectByPrimaryKeyWithPerm(id);
		return role;
	}

	@Override
	public int updateRolePermission(Role role, Integer[] ids) {
		int i = 0;
		//验证是否是第一次插入
		RolePermissionExample rp = new RolePermissionExample();
		com.oa.bean.RolePermissionExample.Criteria ct =rp.createCriteria();
		ct.andRoleIdEqualTo(role.getRoleId());
		List<RolePermission> list = rolePermissionMapper.selectByExample(rp);
		List<Integer> permissionId = new ArrayList<Integer>();
		for(Integer permId : ids) {
			permissionId.add(permId);
		}
		//若有则删除原有权限
		if(list != null) {
			for(Integer permId : ids) {
				RolePermissionExample rpe = new RolePermissionExample();
				com.oa.bean.RolePermissionExample.Criteria ctp =rpe.createCriteria();
				ctp.andRoleIdEqualTo(role.getRoleId());
				rolePermissionMapper.deleteByExample(rpe);
				System.out.println(permId);
			}
		}
		//插入新的权限
		for(Integer perId : permissionId) {
			i = rolePermissionMapper.insert(new RolePermission(role.getRoleId(), perId));
		}
		
		return i;
	}

	@Override
	public List<User> getUserList(Integer id) {
		List<User> userList = roleMapper.getUsetList(id);
		return userList;
	}
}
