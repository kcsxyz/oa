package com.oa.service.personSetting.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.User;
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

}
