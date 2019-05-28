package com.oa.controller.personSetting;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.bean.User;
import com.oa.service.personSetting.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public void getUser() {
		
		User user =userService.getUser("admin");
		System.out.println(user.toString());
		
	}
}
