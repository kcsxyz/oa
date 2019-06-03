package com.oa.service.system;

import java.util.List;

import com.oa.bean.Dept;

public interface DeptService {
	
	//获取所部门
	List<Dept> getDeptList();
	
	//通过部门id获取部门
	Dept getDeptById(Integer deptId);
	
	//保存部门
	int saveDept(Dept dept);
	
	//修改部门
	int updateDept(Dept dept);
	
	//批量删除部门
	void deleteDeptBatch(List<Integer> listId);
	
	//单个删除从部门
	void deleteDept(Integer id);
	
	//验证部门名是否存在
	int checkDeptName(String deptName);

}
