package com.oa.service.deptOffice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.User;
import com.oa.dao.UserMapper;
import com.oa.service.deptOffice.UserPowerService;

@Service
public class UserPowerServiceImpl implements UserPowerService {
    @Resource
	private UserMapper userMapper;

	@Override
	public int insertSelective(User user) {
		int i = insertSelective(user);
		System.out.println("sevice中user的 i"+i);
		return i;
	}
    
    
	
} 
