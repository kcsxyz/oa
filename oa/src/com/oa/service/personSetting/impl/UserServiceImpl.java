package com.oa.service.personSetting.impl;

import java.util.List;

import com.oa.bean.UserExample.Criteria;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.User;
import com.oa.bean.UserExample;
import com.oa.dao.UserMapper;
import com.oa.service.personSetting.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	@Override
	public User getUser(String uid) {
		User user =userMapper.getUserMap(uid);
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
		userMapper.updateByPrimaryKeySelective(user);
	}
	//新增用户
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
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
		userMapper.updateByPrimaryKeySelective(user);
		
	}
	@Override
	public List<User> selectUser() {
		// TODO Auto-generated method stub
		return userMapper.getUserList();
	}
	@Override
	public List<User> selectLikeUser(String userInfo) {
		
		return userMapper.selectLikeUser(userInfo);
	}
	@Override
	public void deleteUserBatch(List<String> listId) {
		// TODO Auto-generated method stub
		UserExample de = new UserExample();
		Criteria ct = de.createCriteria();
		ct.andUidIn(listId);
		userMapper.deleteByExample(de);
	}
	@Override
	public List<User> selectByDept(Integer id) {
		return userMapper.selectByDept(id);
	}
	@Override
	public List<User> selectByNameLike(String info) {
		// TODO Auto-generated method stub
		return userMapper.selectByNameLike(info);
	}
	
	
	

}
