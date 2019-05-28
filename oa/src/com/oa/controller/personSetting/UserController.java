package com.oa.controller.personSetting;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.oa.bean.User;
import com.oa.service.personSetting.UserService;
import com.oa.utils.md5;


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
	
	/**
	 * @param name
	 * @param password
	 * @param model
	 * @return
	 * 登录
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String Login(
			String uid,String password,Model model){
		String pwd=md5.GetMD5Code(password);
		User user=userService.login(uid,pwd);
		if(user!=null){
            model.addAttribute(user);
            System.out.println("登录成功");	
            return "loginSuccess";         
        }
			System.out.println("登录失败");	
			return "loginError";				
	}
	//注销
	@RequestMapping("/outLogin")
	@ResponseBody
	public String outLogin(HttpSession session,SessionStatus sessionStatus){
        session.removeAttribute("user");//我这里是先取出httpsession中的user属性
        session.invalidate();  //然后是让httpsession失效
        sessionStatus.setComplete();//最后是调用sessionStatus方法
        System.out.println("注销成功");
        return "index";
    }
	
	//修改密码
	@RequestMapping("/updatePassword")
	@ResponseBody
	public String updatePassword(String uid,String password,String repassword) {
		String pwd=md5.GetMD5Code(password);
		String repwd=md5.GetMD5Code(repassword);
		User user=userService.getUser(uid);
		if(user.getPassword()==pwd) {
			user=userService.updatePassword(repwd);
			System.out.println("密码修改成功");
			return "updatePasswordError";			
		}
		else {
			System.out.println("密码修改失败");
			return "updatePasswordError";
		}			
	}

}
