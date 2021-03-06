package com.oa.controller.personSetting;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import com.oa.bean.PersonTel;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.bean.WorkLog;
import com.oa.service.personSetting.PersonTelService;
import com.oa.service.personSetting.UserService;
import com.oa.service.system.DeptService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("personTel")
public class PersonTelController {
	@Resource
	private PersonTelService personTelService;	
	@Resource
	private UserService userService;
	@Resource
	private DeptService deptService;
	
	/**
	 * @param uid
	 * @param model
	 * @return
	 * 获取个人通讯录
	 */
	
	@RequestMapping("/getPersonTel")
	public String getPersonTel(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<User> userlist=new ArrayList<>();
			List<PersonTel> personTelList=personTelService.selectByUid(user.getUid());	
			for (PersonTel personTel : personTelList) {
					userlist.add(userService.getUser(personTel.getPersonId()));							
			}
			List<Dept> deptlist=deptService.getDeptList();
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<PersonTel> page = new PageInfo<PersonTel>(personTelList, 3);
			model.addAttribute("deptlist",deptlist);
			model.addAttribute("pageInfo", page);
			model.addAttribute("userlist",userlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personSetting/mailList";
	}
	/**
	 * @param personTel
	 * @param model
	 * @return
	 * 新增
	 */
	@RequestMapping("/addPersonTel")
	public String addPersonTel(String pid,Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		ResponseResult rr=new ResponseResult();
		PersonTel personTel=new PersonTel();
		personTel.setUserId(user.getUid());
		personTel.setPersonId(pid);
		if (personTelService.getPersonTel(user.getUid(),pid)==null) {
			personTelService.addpersonTel(personTel);
		}	
		
		return "redirect:/personTel/getPersonTel";
	}
	/**
	 * @param id
	 * @param session
	 * @return
	 * 单个删除
	 */
	@RequestMapping("/deletePersonTel/{id}")
	public String deletePersonTel(@PathVariable("id") String id,HttpSession session) {
		User user=(User) session.getAttribute("user");
		personTelService.deletePersonTel(user.getUid(), id);
		return "redirect:/personTel/getPersonTel";
	}
	/**
	 * @param logId
	 * @param session
	 * @return
	 * 批量删除
	 */
	@RequestMapping(value="/deletePersonTel/{id}",method=RequestMethod.POST)
	public String deleteWorkLog(@PathVariable("id")String logId,HttpSession session) {
		User user=(User) session.getAttribute("user");
		String ids=logId;
		//批量删除
		if (ids.contains("-")) {
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				personTelService.deletePersonTel(user.getUid(),string);
			}
		} else {
			personTelService.deletePersonTel(user.getUid(), logId);
		}
		return "redirect:/personTel/getPersonTel";			
	}
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return所有通讯录
	 */
	@RequestMapping("/allPersonTel")
	public String allPersonTel(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<Dept> deptlist=deptService.getDeptList();
			
			List<User> userlist=userService.selectUser();		
			
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<User> page = new PageInfo<User>(userlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("deptlist",deptlist);
			model.addAttribute("userlist",userlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personSetting/allMailList";
	}
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @param id
	 * @param session
	 * @return根据部门查询个人通讯录
	 */
	@RequestMapping("/selectPersonTelByDept")
	public String selectPersonTelByDept(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model,Integer id,HttpSession session) {
			User users=(User) session.getAttribute("user");
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<PersonTel> personTellist=personTelService.selectByDept(users.getUid(),id);
			List<User> userlist=new ArrayList<>();
			for (PersonTel personTel : personTellist) {
				User user=userService.getUser(personTel.getPersonId());				
				userlist.add(user);
			}
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<User> page = new PageInfo<User>(userlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("userlist",userlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personSetting/mailList";
	}
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @param info
	 * @param session
	 * @return个人通讯录模糊查询
	 */
	@RequestMapping("/selectPersonTelLike")
	public String selectPersonTelLike(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model,String info,HttpSession session) {
			User users=(User) session.getAttribute("user");
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<PersonTel> personTellist=personTelService.selectLike(users.getUid(),info);
			List<User> userlist=new ArrayList<>();
			for (PersonTel personTel : personTellist) {
				User user=userService.getUser(personTel.getPersonId());				
				userlist.add(user);
			}
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<User> page = new PageInfo<User>(userlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("userlist",userlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personSetting/mailList";
	}
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @param id
	 * @param session
	 * @return所有通讯录部门查询
	 */
	@RequestMapping("/selectPersonTelDept")
	public String selectPersonTelDept(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model,Integer id) {
			
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<User> userlist=userService.selectByDept(id);
			
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<User> page = new PageInfo<User>(userlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("userlist",userlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personSetting/allMailList";
	}
	
	@RequestMapping("/selectPersonTelByName")
	public String selectPersonTelLikeName(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model,String info) {
			
		try {
			// startPage后紧跟着的就是一个分页查询
			PageHelper.startPage(pageNo, pageSize);
			List<User> userlist=userService.selectByNameLike(info);
			
			// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
			PageInfo<User> page = new PageInfo<User>(userlist, 3);
			model.addAttribute("pageInfo", page);
			model.addAttribute("userlist",userlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personSetting/allMailList";
	}
}
