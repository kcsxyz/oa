package com.oa.controller.personSetting;

import java.util.Date;
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
	
	/**
	 * @param session
	 * @param sessionStatus
	 * @return
	 * //注销
	 */
	@RequestMapping("/outLogin")
	@ResponseBody
	public String outLogin(HttpSession session,SessionStatus sessionStatus){
        session.removeAttribute("user");//我这里是先取出httpsession中的user属性
        session.invalidate();  //然后是让httpsession失效
        sessionStatus.setComplete();//最后是调用sessionStatus方法
        System.out.println("注销成功");
        return "login";
    }
	
	
	/**
	 * @param uid
	 * @param password
	 * @param repassword
	 * @return
	 * //修改密码
	 */
	@RequestMapping("/updatePassword")
	@ResponseBody
	public String updatePassword(String uid,String password,String repassword) {
		String pwd=md5.GetMD5Code(password);
		String repwd=md5.GetMD5Code(repassword);			
		if(pwd.equals(userService.getPasswordByUid(uid))) {			
			userService.updatePassword(uid,repwd);
			System.out.println("密码修改成功");			
			return "updatePasswordSuccess";			
		}
		else {
			System.out.println("密码修改失败");
			return "updatePasswordError";
		}			
	}
	
	
		/**
		 * @param user
		 * @param session
		 * @return
		 *  //新增用户
		 */
		@RequestMapping("/addUser")
		@ResponseBody
		public String insertUser(User user,HttpSession session,Model model) {
			User user1=userService.getUser(user.getUid());
			if(user1==null) {
			user1.setPassword(md5.GetMD5Code(user.getPassword()));			
			user1.setCreateTime(new Date());	
			//需要修改
			user.setCreateName((String) session.getAttribute(user1.getName()));
			model.addAttribute(user1);
			userService.addUser(user1);
			System.out.println("添加成功");
			return "addUserSuccess";
			}else {
				System.out.println("用户已存在");
				return "addUserError";
			}
		}
		
		
		/**
		 * @param uid
		 * @return
		 * //删除用户
		 */
		@RequestMapping("/deleteUserByUid")
		@ResponseBody
		public String deleteUserByUid(String uid) {
			User user=userService.getUser(uid);
			if(user!=null) {
				userService.deleteUserByUid(uid);
				System.out.println("用户已删除");
				return "deleteUserByUidSuccess";
			}else {
				System.out.println("用户删除失败");
				return "deleteUserByUidError";
			}			
		}
		
		/**
		 * @param user
		 * @param session
		 * @return
		 * 修改用户
		 */
		@RequestMapping("/updateUser")
		@ResponseBody
		public String updateUser(User user,HttpSession session,Model model) {
			User user1=userService.getUser(user.getUid());
			if(user1!=null) {			
			user1.setPassword(userService.getPasswordByUid(user.getUid()));
			//需要修改
			user1.setModifiedName((String) session.getAttribute(user.getName()));
			user1.setModifiedTime(new Date());
			userService.updateUser(user1);
			System.out.println("修改成功");
			return "updateUserSuccess";
			}else {
				System.out.println("修改失败");
				return "updateUserUserError";
			}
		}
		/**
		 * @param uid
		 * @param repassword
		 * @return
		 * 重置密码
		 */
		@RequestMapping("/rePassword")
		@ResponseBody
		public String rePassword(String uid,String repassword)  throws Exception{			
			String repwd=md5.GetMD5Code(repassword);
			User user=userService.getUser(uid);		
			if(user!=null) {			
				user.setPassword(repwd);
				userService.updateUser(user);
				System.out.println("密码重置成功");			
				return "rePasswordSuccess";			
			}
			else {
				System.out.println("密码重置失败");
				return "rePasswordError";
			}			
		}
		
		 /**
		 * @param model
		 * @return
		 * @throws Exception
		 * 查询所有用户
		 */
		@RequestMapping("/alluser")
		@ResponseBody
		public String  queryUser(Model model) throws Exception{
		        List<User> userlist = userService.selectUser();
		        model.addAttribute("userlist",userlist);
		        for(User users:userlist) {
					System.out.println(users);
				}
		        return "alluser";		         
		    }
		/**
		 * @param uid
		 * @param name
		 * @param deptId
		 * @param model
		 * @return
		 * 模糊查询
		 */
		@RequestMapping("/selectLikeUser")
		@ResponseBody
		public String selectLikeUser(String userInfo,Model model) {
			List<User> userlist = userService.selectLikeUser(userInfo);
			model.addAttribute("userlist",userlist);
	        for(User users:userlist) {
				System.out.println(users);
			}
			return "selectLikeUser";			
		}
		/**
		 * @param ids
		 * @return
		 * 批量删除
		 */
		@RequestMapping("/deleteList")
		@ResponseBody
		public String delete(String[] uids){
			//循环遍历让每一个id都执行删除方法
			for (String string : uids) {
				userService.deleteUserByUid(string);
			}
			return "deleteList";
		}
			
		
}
