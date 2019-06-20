package com.oa.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Dept;
import com.oa.bean.DeptExample;
import com.oa.bean.DeptExample.Criteria;
import com.oa.bean.User;
import com.oa.dao.DeptMapper;
import com.oa.service.system.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Resource
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> getDeptList() {
		
		/*DeptExample ee =new DeptExample();
		Criteria criteria=ee.createCriteria();
		criteria.andDeptNameLike("");*/
		List<Dept> listDept= deptMapper.selectByExample(null);
		
		return listDept;
	}

	@Override
	public Dept getDeptById(Integer deptId) {
		Dept dept = deptMapper.selectByPrimaryKey(deptId);
		return dept;
	}

	@Override
	public int saveDept(Dept dept) {
		int i = deptMapper.insert(dept);
		return i;
	}

	@Override
	public int updateDept(Dept dept) {
		int i = deptMapper.updateByPrimaryKey(dept);
		return i;
	}

	@Override
	public void deleteDeptBatch(List<Integer> listId) {
		DeptExample de = new DeptExample();
		Criteria ct = de.createCriteria();
		ct.andDeptIdIn(listId);
		deptMapper.deleteByExample(de);
		
	}

	@Override
	public void deleteDept(Integer id) {
		deptMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public int checkDeptName(String deptName) {
		DeptExample de = new DeptExample();
		Criteria ct = de.createCriteria();
		ct.andDeptNameLike(deptName);
		List<Dept> list = deptMapper.selectByExample(de);
		System.out.println(list.size());
		if(list.size()>0) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public List<User> getUserList(int deptId) {
		
		List<User> userList = deptMapper.getUserList(deptId);
		return userList;
	}

}
