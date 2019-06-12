package com.oa.controller.personSetting;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			rr.setStateCode(1);
			}else {
				rr.setMessage("工号不存在");
				rr.setStateCode(0);
			}
			return rr;
		}	
		//跳转到登录页面
		@RequestMapping("/toLogin")
		public String Login() {
			return "personSetting/login";
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
	public ResponseResult Login(String uid,String password,String code,HttpSession session,Model model){
		ResponseResult rr=new ResponseResult();
		String sessioncode = (String) session.getAttribute("code");
		//System.out.println(sessioncode);
		String pwd=md5.GetMD5Code(password);
		if(sessioncode.equals(code.toUpperCase())) {
			User user=userService.login(uid,pwd);
			if(user!=null){
				User user1=userService.getUser(user.getUid());
				model.addAttribute("user",user1);
				session.setAttribute("user", user1);
				//System.out.println(user1);
	            //System.out.println("登录成功");
	            rr.setStateCode(1);	            
	        }else {
	        	rr.setStateCode(0);
	            rr.setMessage("密码错误");
	            //System.out.println("登录失败");	            
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
        rr.setStateCode(1);
        }else {
        	rr.setMessage("注销失败");
        	rr.setStateCode(0);
        }
        return rr;
    }
	
	@RequestMapping("/toupdatePassword")
	public String toupdatePassword() {
		System.out.println(1);
		return "personSetting/changePassword";
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
	public ResponseResult updatePassword(HttpSession session,String password,String repassword) {
		ResponseResult rr=new ResponseResult();
		String pwd=md5.GetMD5Code(password);
		String repwd=md5.GetMD5Code(repassword);
		User user=(User) session.getAttribute("user");
		if(pwd.equals(userService.getUser(user.getUid()).getPassword())) {			
			userService.updatePassword(user.getUid(),repwd);
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
				User users=(User) session.getAttribute("user");
				//需要修改
				user1.setCreateName(users.getUid());
				user1.setHeadPic("/oa/upload/admin-d48744e902d6ac5.gif");
				int i=userService.addUser(user1);
				if(i<0) {					
					model.addAttribute("user", user1);
					//System.out.println("添加成功");				
					rr.setStateCode(1);	
				}else {
					rr.setMessage("添加失败");
					rr.setStateCode(0);
				}
						
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
			rr.setStateCode(1);
			}else {
				//System.out.println("修改失败");
				rr.setMessage("修改失败");
				rr.setStateCode(0);
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
		//跳转到修改头像页面
		@RequestMapping("/changeHead")
		public String changeHead() {
			return "personSetting/personalDetail";
		}
		 	/**
		 	 * @param file
		 	 * @param user
		 	 * @param request
		 	 * @param model
		 	 * @return
		 	 * @throws IOException
		 	 * 修改头像
		 	 */
		 	@RequestMapping("/fileUpload")
		 	@ResponseBody
		    public ResponseResult fileUpload(MultipartFile file,HttpSession session,HttpServletRequest request,Model model) throws IOException {
			 ResponseResult rr = new ResponseResult();
		        /**
		         * 上传图片
		         */			 
			 	User user=(User) session.getAttribute("user");
			 	String path = request.getServletContext().getRealPath("/upload/");
			 	System.out.println(path);
		        //图片上传成功后，将图片的地址写到数据库		        
		        //获取原始图片的拓展名
		        String originalFilename = file.getOriginalFilename();
		        //新的文件名字
		        String newFileName = user.getUid()+originalFilename;
		        //封装上传文件位置的全路径
		        File targetFile = new File(path,newFileName);
		         //把本地文件上传到封装上传文件位置的全路径
		        file.transferTo(targetFile);
		        user.setHeadPic("/oa/upload/"+newFileName);	
		        model.addAttribute(user);		        
		        userService.updateUser(user);
		        if(user.getHeadPic()!=null) {
		        	rr.setStateCode(1);
		        }else {
		        	rr.setStateCode(0);
		        	rr.setMessage("头像修改失败");
		        }
		        return rr; 
		    }
	}
