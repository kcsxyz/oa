
package com.oa.service.deptOffice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.oa.bean.Dept;
import com.oa.bean.DeptExample;
import com.oa.bean.User;
import com.oa.bean.UserExample;
import com.oa.bean.UserExample.Criteria;
import com.oa.dao.DeptMapper;
import com.oa.dao.UserMapper;
import com.oa.service.deptOffice.UserPowerService;
import com.oa.utils.md5;

@Service
public class UserPowerServiceImpl implements UserPowerService {
    @Resource
	private UserMapper userMapper;
    @Resource
	private DeptMapper  deptMapper;
	@Override
	public int insertSelective(User user) {
		String password = md5.GetMD5Code(user.getPassword());
		user.setPassword(password);
		int i = userMapper.insertSelective(user);
		return i;
	}

	
	public int updateByPrimaryKeySelective(User user) {
		int i = userMapper.updateByPrimaryKeySelective(user);
		return i;
	}
    
	
	public User selectByPrimaryKey(String uid) {
		User user = userMapper.selectByPrimaryKey(uid);
		return user;
	}


	public int deleteByPrimaryKey(String ids) {
		int i = userMapper.deleteByPrimaryKey(ids);
		return i;
	}


	public void deleteDeptBatch(List<String> listId) {
		UserExample ue = new UserExample();
		Criteria c =ue.createCriteria();
		c.andUidIn(listId);
		userMapper.deleteByExample(ue);
	}


	@Override
	public List<User> selectByParams(Map<String,String> param) {
		List<User> users = userMapper.selectByParams(param);
		return users;
		
	}
	public List<Dept> selectByDept(DeptExample example) {
		 List<Dept> depts = deptMapper.selectByExample(null);
		return depts;
	}
	
} 