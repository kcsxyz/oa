package com.oa.service.personSetting;

import com.oa.bean.User;

public interface UserService {
	//根据UID查询
	User getUser(String uid);
	//登录
	User login(String uid, String password);
	//修改密码
	User updatePassword(String repwd);
	

}
