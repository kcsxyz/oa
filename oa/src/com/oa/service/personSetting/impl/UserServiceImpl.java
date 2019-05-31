package com.oa.service.personSetting.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.User;
import com.oa.bean.WorkLogExample;
import com.oa.bean.WorkLogExample.Criteria;
import com.oa.dao.UserMapper;
import com.oa.service.personSetting.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	@Override
	public User getUser(String uid) {
		User user =userMapper.selectByPrimaryKey(uid);
		return user;
	}
	//登录
	@Override
	public User login(String uid, String password) {
		// TODO Auto-generated method stub
		
		return userMapper.findUserByNameAndPwd(uid, password);
	}
	
	//根据uid获取密码
	@Override
	public String getPasswordByUid(String uid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(uid).getPassword();
	}
	//修改密码
	@Override
	public void updatePassword(String uid, String password) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(uid);
		user.setUid(uid);
		user.setPassword(password);
		userMapper.updatePassword(user);
	}
	//新增用户
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}
	//删除用户
	@Override
	public void deleteUserByUid(String uid) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(uid);
	}
	//修改用户
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub		
		userMapper.updateByPrimaryKey(user);
		
	}
	@Override
	public List<User> selectUser() {
		// TODO Auto-generated method stub
		return userMapper.selectUser();
	}
	@Override
	public List<User> selectLikeUser(String userInfo) {
		
		return userMapper.selectLikeUser(userInfo);
	}
	
	

}
