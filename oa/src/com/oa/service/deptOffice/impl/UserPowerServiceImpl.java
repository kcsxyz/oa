package com.oa.service.deptOffice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.User;
import com.oa.bean.UserExample;
import com.oa.bean.UserExample.Criteria;
import com.oa.dao.UserMapper;
import com.oa.service.deptOffice.UserPowerService;

@Service
public class UserPowerServiceImpl implements UserPowerService {
    @Resource
	private UserMapper userMapper;

	@Override
	public int insertSelective(User user) {
		int i = userMapper.insertSelective(user);
		System.out.println("sevice中user的 i"+i);
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
	//	List<User> users = userMapper.selectByParams(param);
	//	return users;
		return null;
	}


	

    
    
	
} 
