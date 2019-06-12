package com.oa.controller.personSetting;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.bean.PersonTel;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.service.personSetting.PersonTelService;
import com.oa.service.personSetting.UserService;

@Controller
@RequestMapping("persontel")
public class PersonTelController {
	@Resource
	private PersonTelService personTelService;	
	@Resource
	private UserService userService;
	/**
	 * @param uid
	 * @param model
	 * @return
	 * 获取个人通讯录
	 */
	@RequestMapping("/getPersonTel")
	@ResponseBody
	public ResponseResult getPersonTel(String uid,Model model) {
		ResponseResult rr=new ResponseResult();
		List<PersonTel> personTelList=personTelService.selectByUid(uid);
		List<User> userList=new ArrayList<User>();
		for (PersonTel personTel : personTelList) {			
			User user=userService.getUser(personTel.getPersonId());
			userList.add(user);			
		}
		if(userList.size()>0) {
			model.addAttribute(userList);
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("未查询到数据");
		}
		return rr;
	}
	/**
	 * @param personTel
	 * @param model
	 * @return
	 * 新增
	 */
	@RequestMapping("/addPersonTel")
	@ResponseBody
	public ResponseResult addPersonTel(PersonTel personTel,Model model) {
		ResponseResult rr=new ResponseResult();
		personTel.setUserId("1");
		personTel.setPersonId("3");
		int i=personTelService.addpersonTel(personTel);
		if(i<0) {
			rr.setStateCode(1);
		}else {
			rr.setStateCode(0);
			rr.setMessage("添加失败");
		}
		return rr;
	}
	@RequestMapping("/deletePersonTel")
	@ResponseBody
	public ResponseResult deletePersonTel(String uid,String id) {
		ResponseResult rr = new ResponseResult();
		uid="1";
		id="2-3";
		//批量删除
		if (id.contains("-")) {			
			String[] split_ids = id.split("-");
			for (String string : split_ids) {				
				personTelService.deletePersonTel(uid,string);
			}
			rr.setStateCode(1);
		// 单个删除
		} else {			
			personTelService.deletePersonTel(uid,id);;
			rr.setStateCode(1);
				}
		return rr;			
	}
}
