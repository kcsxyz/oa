package com.oa.controller.deptOffice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.bean.ResponseResult;
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
    @RequestMapping("/saveUser")
    @ResponseBody
    public ResponseResult  saveUser(User user) {
    	ResponseResult rr = new ResponseResult();
		int i =userPowerService.insertSelective(user);
		if(i!=0) {
			rr.setStateCode(1);
			rr.setMessage("录入用户信息成功");
		}else {
			rr.setStateCode(0);
			rr.setMessage("录入用户信息失败");
		}
		return rr;
    }
    
    /**
         * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public ResponseResult  updateUser(User user) {
    	ResponseResult rr = new ResponseResult();
		int i =userPowerService.updateByPrimaryKeySelective(user);
		if(i!=0) {
			rr.setStateCode(1);
			rr.setMessage("修改用户信息成功");
		}else {
			rr.setStateCode(0);
			rr.setMessage("修改用户信息失败");
		}
		return rr;
    }
    
    @RequestMapping("/findByid")
    @ResponseBody
	public User getDeptById(@RequestParam("id") String uid,Model model) {
		User userPower = userPowerService.selectByPrimaryKey(uid);
		model.addAttribute("userPower", userPower);
		return userPower;
	}
    
	/**根据id删除部门
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public ResponseResult deleteDept(@RequestParam("ids") String ids) {
		ResponseResult rr = new ResponseResult();
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
		return rr.success();
	}
	
	@RequestMapping("/findUser")
	@ResponseBody
	public String findUser(
			HttpSession session,
		    String Info,
			String uid,
			Integer sex,
			String idCard,
			Integer deptId,
			String createName,
			String startTime,
			String endTime,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            Model model
			) {
		System.out.println(Info+"---"+uid+"---"+sex+"---"+deptId);
		  Map<String, String> map = new HashMap<String, String>();
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
			map.put("idCard", idCard);
			map.put("createName",createName);
		    map.put("startTime",startTime);
		    map.put("endTime",endTime);
	        System.out.println(map.get("uid"));
	       
		 List<User> users = userPowerService.selectByParams(map);
		 for (User user : users) {
			System.out.println(user);
		}
		 
	        
		return "success";
	}
	
	
	
    
}
