package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.User;

public interface UserService {
	//根据UID查询
	User getUser(String uid);
	//登录
	User login(String uid, String password);
	
	//根据id获取密码
	String getPasswordByUid(String uid);
	//修改密码
	void updatePassword(String uid, String repassword);
	//增加用户
	int addUser(User user);
	//删除用户
	void deleteUserByUid(String uid);
	//修改用户
	void updateUser(User user);
	//查询所有用户
	List<User> selectUser();
	//模糊查询
	List<User> selectLikeUser(String userInfo);
	
	void deleteUserBatch(List<String> listId);
	
}
