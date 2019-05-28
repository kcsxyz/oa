package com.oa.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.bean.User;
import com.oa.dao.UserMapper;
import com.oa.utils.md5;
/**
 * @author Administrator
 *
 */
public class UserTest {
	
	//保存用户
	@Test
	public void save() throws Exception{
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper UserMapper=ac.getBean("userMapper", UserMapper.class);
		User user=new User();
		user.setUid("admin");
		user.setPassword(md5.GetMD5Code("admin"));
		user.setName("tom");
		UserMapper.insert(user);
	}

}

