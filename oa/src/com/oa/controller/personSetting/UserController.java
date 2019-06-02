package com.oa.controller.personSetting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.service.personSetting.UserService;
import com.oa.utils.md5;


	@Controller
	@RequestMapping("/user")
	public class UserController {
		@Resource
		private UserService userService;
		
		/**
		 * @param uid
		 * @return
		 * 根据id查询
		 */
		@RequestMapping("/getUser")
		@ResponseBody
		public ResponseResult getUser(String uid) {
			ResponseResult rr=new ResponseResult();
			
			User user =userService.getUser(uid);
			if(user!=null) {
			//System.out.println(user.toString());
			rr.setStateCode(1);
			}else {
				rr.setMessage("工号不存在");
				rr.setStateCode(0);
			}
			return rr;
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
	public ResponseResult Login(String uid,String password,String code,HttpSession session){
		ResponseResult rr=new ResponseResult();
		String sessioncode = (String) session.getAttribute("code");
		//System.out.println(sessioncode);
		String pwd=md5.GetMD5Code(password);
		if(sessioncode.equals(code.toUpperCase())) {
			User user=userService.login(uid,pwd);
			if(user!=null){
				session.setAttribute("user", user);
	            //System.out.println("登录成功");
	            rr.setStateCode(1);                   
	        }else {
	        	rr.setStateCode(0);
	            rr.setMessage("密码错误");
	           // System.out.println("登录失败");
	        }
		}else {
			rr.setMessage("验证码错误");
			rr.setStateCode(0);
		}
				
			return rr;				
	}
	
	/**
	 * @param session
	 * @param sessionStatus
	 * @return
	 * //注销
	 */
	@RequestMapping("/outLogin")
	@ResponseBody
	public ResponseResult outLogin(HttpSession session,SessionStatus sessionStatus){
		ResponseResult rr=new ResponseResult();
        session.removeAttribute("user");//我这里是先取出httpsession中的user属性
        session.invalidate();  //然后是让httpsession失效
        sessionStatus.setComplete();//最后是调用sessionStatus方法
        //System.out.println("注销成功");
        if(session.getAttribute("user")==null) {
        rr.setMessage("注销成功");
        rr.setStateCode(1);
        }else {
        	rr.setMessage("注销失败");
        	rr.setStateCode(0);
        }
        return rr;
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
	public ResponseResult updatePassword(String uid,String password,String repassword) {
		ResponseResult rr=new ResponseResult();
		String pwd=md5.GetMD5Code(password);
		String repwd=md5.GetMD5Code(repassword);			
		if(pwd.equals(userService.getPasswordByUid(uid))) {			
			userService.updatePassword(uid,repwd);
			//System.out.println("密码修改成功");			
			
			rr.setStateCode(1);
		}
		else {
			//System.out.println("密码修改失败");
			rr.setMessage("密码修改失败");
			rr.setStateCode(0);
		}		
		return rr;
	}
	
	
		/**
		 * @param user
		 * @param session
		 * @return
		 *  //新增用户
		 */
		@RequestMapping("/addUser")
		@ResponseBody
		public ResponseResult insertUser(User user,Model model,HttpSession session) {
			ResponseResult rr=new ResponseResult();
			User user1=userService.getUser(user.getUid());
			if(user1==null) {
			user1.setPassword(md5.GetMD5Code(user.getPassword()));			
			user1.setCreateTime(new Date());	
			//需要修改
			user1.setCreateName((String) session.getAttribute(user1.getName()));
			model.addAttribute("user", user1);
			userService.addUser(user1);
			//System.out.println("添加成功");
			
			rr.setStateCode(1);			
			}else {
				//System.out.println("用户已存在");
				rr.setMessage("用户已存在");
				rr.setStateCode(0);
			}
			return rr;
		}
		
		
		/**
		 * @param uid
		 * @return
		 * //删除用户
		 */
		@RequestMapping("/deleteUserByUid")
		@ResponseBody
		public ResponseResult deleteUserByUid(String uid) {
			ResponseResult rr=new ResponseResult();
			User user=userService.getUser(uid);
			if(user!=null) {
				userService.deleteUserByUid(uid);
				//System.out.println("用户已删除");
				
				rr.setStateCode(1);				
			}else {
				//System.out.println("用户删除失败");
				rr.setMessage("用户删除失败");
				rr.setStateCode(0);
			}		
			return rr;
		}
		
		/**
		 * @param user
		 * @param session
		 * @return
		 * 修改用户
		 */
		@RequestMapping("/updateUser")
		@ResponseBody
		public ResponseResult updateUser(User user,HttpSession session,Model model) {
			ResponseResult rr=new ResponseResult();
			User user1=userService.getUser(user.getUid());
			if(user1!=null) {			
			user1.setPassword(userService.getPasswordByUid(user.getUid()));
			//需要修改
			user1.setModifiedName((String) session.getAttribute(user.getName()));
			user1.setModifiedTime(new Date());
			userService.updateUser(user1);
			model.addAttribute("user", user1);
			System.out.println("修改成功");			
			rr.setStateCode(1);
			}else {
				//System.out.println("修改失败");
				rr.setMessage("修改成功");
				rr.setStateCode(1);
			}
			return rr;
		}
		/**
		 * @param uid
		 * @param repassword
		 * @return
		 * 重置密码
		 */
		@RequestMapping("/rePassword")
		@ResponseBody
		public ResponseResult rePassword(String uid,String repassword,Model model)  throws Exception{			
			ResponseResult rr=new ResponseResult();
			String repwd=md5.GetMD5Code(repassword);
			User user=userService.getUser(uid);		
			if(user!=null) {			
				user.setPassword(repwd);
				userService.updateUser(user);
				model.addAttribute("user", user);
				//System.out.println("密码重置成功");
				
				rr.setStateCode(1);		
			}
			else {
				//System.out.println("密码重置失败");
				rr.setMessage("重置密码失败");
				rr.setStateCode(0);
			}	
			return rr;		
		}
		
		 /**
		 * @param model
		 * @return
		 * @throws Exception
		 * 查询所有用户
		 */
		@RequestMapping("/alluser")
		@ResponseBody
		public ResponseResult  queryUser(Model model) throws Exception{
			ResponseResult rr=new ResponseResult();
		        List<User> userlist = userService.selectUser();
		       model.addAttribute("userlist", userlist);
		       /* for(User users:userlist) {
					System.out.println(users);
				}*/
		        if(userlist.size()!=0) {
		        	rr.setStateCode(1);
		        }else {
		        	rr.setMessage("用户查询失败");
		        	rr.setStateCode(0);
		        }
		        
		        return rr;		         
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
		public ResponseResult selectLikeUser(String userInfo,Model model) {
			ResponseResult rr=new ResponseResult();
			List<User> userlist = userService.selectLikeUser(userInfo);
			 model.addAttribute("userlist", userlist);
	       /* for(User users:userlist) {
				System.out.println(users);
			}*/
			 if(userlist.size()>0) {
				 rr.setStateCode(1);
			 }else {
				 rr.setStateCode(0);
				 rr.setMessage("未查到数据");
			 }
			return rr;			
		}
		/**
		 * @param ids
		 * @return
		 * 批量删除
		 */
		@RequestMapping("/deleteList")
		@ResponseBody
		public ResponseResult delete(String uids){
			ResponseResult rr = new ResponseResult();
			String ids=uids;
			//批量删除
			if (ids.contains("-")) {
				List<String> listId = new ArrayList<>();
				String[] split_ids = ids.split("-");
				for (String string : split_ids) {
					listId.add(string);
					userService.deleteUserBatch(listId);
				}
				rr.setStateCode(1);
			// 单个删除
			} else {
				Integer id1 = Integer.parseInt(ids);
				userService.deleteUserByUid(ids);
				rr.setStateCode(1);
					}
			return rr;	
		}		


	}
