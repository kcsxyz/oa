package com.oa.controller.deptOffice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Dept;
import com.oa.bean.Notice;
import com.oa.bean.ResponseResult;
import com.oa.bean.Role;
import com.oa.bean.User;
import com.oa.service.deptOffice.UserPowerService;

@Controller
@RequestMapping("userpower")
public class UserPowerController {
    @Resource
	private UserPowerService userPowerService;
	
    /**
         * 录入用户信息
     * @param user
     * @return
     */
    @RequestMapping(value="/showAdduser", method=RequestMethod.GET)
	public String showAdduser(Model model) {
		 model.addAttribute(new User());
		   List<Dept> depts = userPowerService.selectByDept();
		 model.addAttribute("userDept", depts);
		    List<Role> roles = userPowerService.selectByRole();
		 model.addAttribute("userRole", roles);
		return "addRenLi";
	}
    @RequestMapping("/saveUser")
    public String  saveUser(HttpSession session,@PathParam("uid") String uid,User user) {
        User user1 = (User)session.getAttribute("user");
	    String createName = user1.getUid();
	    System.out.println(createName);
    	String password = "123456";
    	user.setUid(uid);
    	user.setCreateTime(new Date());
    	user.setPassword(password);
    	user.setCreateName(createName);
        userPowerService.insertSelective(user);
		return "redirect:/userpower/findUser";
    }
    
    /**
         * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String  updateUser(
    		 User user,
    		 HttpSession session,
    		 @PathParam("uid") String uid,
			 Model model
    		) {
        User user1 = (User)session.getAttribute("user");
 	    String modifiedName = user1.getUid();
	    user.setUid(uid);
	    user.setModifiedName(modifiedName);
	    user.setModifiedTime(new Date());
		userPowerService.updateByPrimaryKeySelective(user);
		return "redirect:/userpower/findUser";
    }
    
    @RequestMapping("/findByid/{id}")
	public String getDeptById(@PathVariable("id") String uid,Model model) {
		User userPower = userPowerService.selectByPrimaryKey(uid);
		 List<Dept> depts = userPowerService.selectByDept();
		   List<Role> roles = userPowerService.selectByRole();
	    model.addAttribute("userRole", roles);
		model.addAttribute("userDept", depts);
		model.addAttribute("userPower", userPower);
		return "updateRenLi";
	}
    
	/**根据id删除部门
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteUser/{ids}")
	public String deleteDept(@PathVariable("ids") String ids) {
		// 批量刪除
		if (ids.contains("-")) {
			List<String> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(string);
				userPowerService.deleteDeptBatch(listId);
			}
		// 单个删除
		} else {
			
			userPowerService.deleteByPrimaryKey(ids);
				}
		return "redirect:/userpower/findUser";
	}
	
	@RequestMapping("/findUser")
	public String findUser(
			HttpSession session,
		    String Info,
			String uid,
			Integer sex,
			Integer deptId,
			String createName,
			String dateStart,
			String finalTime,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            Model model
			) {
		  Map<String, String> map = new HashMap<String, String>();
		  if(dateStart != null&&!dateStart.equals("") && finalTime != null&& !finalTime.equals("")) {
				 String startTime= dateStart+" "+"00:00:00";
				 String endTime = finalTime+" "+"23:59:59";
				 map.put("startTime", startTime);
			     map.put("endTime", endTime);
			 }
		  if(sex != null ) {
			  String sexs = sex.toString();
				map.put("sex", sexs);
		  }
		  if(deptId != null) {
				String deptIds = deptId.toString();
		        map.put("deptId", deptIds);
		  }
		    map.put("Info", Info);
			map.put("uid", uid);
			map.put("createName",createName);
		 PageHelper.startPage(pageNo, pageSize);
		 List<User> users = userPowerService.selectByParams(map);
		 PageInfo<User> page = new PageInfo<User>(users, 3);
	    model.addAttribute("pageInfo", page);     
	    List<Dept> depts = userPowerService.selectByDept();
		 model.addAttribute("userDept", depts);
		return "renLi";

	}
	
	@RequestMapping("/userManage")
	public String userManage(
			HttpSession session,
		    String Info,
			String uid,
			Integer sex,
			Integer deptId,
			String createName,
			String dateStart,
			String finalTime,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            Model model
			) {
		  Map<String, String> map = new HashMap<String, String>();
		  if(dateStart != null&&!dateStart.equals("") && finalTime != null&& !finalTime.equals("")) {
				 String startTime= dateStart+" "+"00:00:00";
				 String endTime = finalTime+" "+"23:59:59";
				 map.put("startTime", startTime);
			     map.put("endTime", endTime);
			 }
		  if(sex != null ) {
			  String sexs = sex.toString();
				map.put("sex", sexs);
		  }
		  if(deptId != null) {
				String deptIds = deptId.toString();
		        map.put("deptId", deptIds);
		  }
		    map.put("Info", Info);
			map.put("uid", uid);
			map.put("createName",createName);
		 PageHelper.startPage(pageNo, pageSize);
		 List<User> users = userPowerService.selectByParams(map);
		 PageInfo<User> page = new PageInfo<User>(users, 3);
	    model.addAttribute("pageInfo", page);     
	    List<Dept> depts = userPowerService.selectByDept();
		 model.addAttribute("userDept", depts);
		return "/system/userManage";

	}
	
	  /**验证名称是否存在
		 * @param uid
		 * @return
		 */
		@RequestMapping("/checkUserByUid")
		@ResponseBody
		public ResponseResult checkUserByUid(String uid) {
			ResponseResult rr = new ResponseResult();
			int re= userPowerService.checkUerById(uid);
			if(re!=0) {
				rr.setMessage("工号已存在");
				rr.setStateCode(0);
			}else {
				rr.setMessage("工号可用");
				rr.setStateCode(1);
				
			}
			return rr;
		}	
		
		       /**验证电话是否存在
				 * @param uid
				 * @return
				 */
				@RequestMapping("/checkUserByPhone")
				@ResponseBody
				public ResponseResult checkUserByPhone(String phone) {
					ResponseResult rr = new ResponseResult();
					int re= userPowerService.checkUerByPhone(phone);
					if(re!=0) {
						rr.setMessage("电话号码已存在");
						rr.setStateCode(0);
					}else {
						rr.setMessage("电话号码可用");
						rr.setStateCode(1);
						
					}
					return rr;
				}	
		
		  /**验证身份证是否存在
				 * @param uid
				 * @return
				 */
				@RequestMapping("/checkUserByIdCard")
				@ResponseBody
				public ResponseResult checkUserByIdCard(String idCard) {
					ResponseResult rr = new ResponseResult();
					int re= userPowerService.checkUerByidCard(idCard);
					if(re!=0) {
						rr.setMessage("身份证号码已存在");
						rr.setStateCode(0);
					}else {
						rr.setMessage("身份证号码无重复");
						rr.setStateCode(1);
					}
					return rr;
				}	
		   /**
		     * 修改用户信息
		     * @param user
		     * @return
		     */
		    @RequestMapping("/updateUserPassword")
		    public String  updateUserPassword(
		    		 User user,
		    		 HttpSession session,
					@PathParam("uid") String uid,
					 Model model
		    		) {
		    	User user1 = (User)session.getAttribute("user");
		 	    String modifiedName = user1.getUid();
			    user.setUid(uid);
			    user.setModifiedName(modifiedName);
			    user.setModifiedTime(new Date());
				userPowerService.updateByPassword(user);
				return "redirect:/userpower/findUser";
		    }
    
		    
}
