package com.oa.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Role;
import com.oa.bean.RoleExample;
import com.oa.bean.RoleExample.Criteria;
import com.oa.dao.RoleMapper;
import com.oa.service.system.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<Role> getRolelist(String queryStr) {
		
		RoleExample re = new RoleExample();
		Criteria ct = re.createCriteria();
		ct.andRoleNameLike("%"+queryStr+"%");
		List<Role> roleList = roleMapper.selectByExample(re);
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
	}

	@Override
	public void deleteRole(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
		
	}

}
