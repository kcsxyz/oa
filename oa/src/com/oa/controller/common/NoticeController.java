
package com.oa.controller.common;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.oa.bean.Notice;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.service.common.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	
	
	/**
	 * 发布公告
	 * @param title
	 * @param content
	 * @param type
	 * @param browsePower
	 * @param createName
	 */
	@RequestMapping(value="/showPushNotice", method=RequestMethod.GET)
	public String showPushNotice(Model model) {
		model.addAttribute(new Notice());
		 List<Dept> depts = noticeService.selectByDept(null);
		 model.addAttribute("noticeDept", depts);
		return "addBulletin";
	}
	
	@RequestMapping(value="/saveNotice",method=RequestMethod.GET)
	@ResponseBody
	public ResponseResult  saveNotice(
		    HttpSession session,
			Notice notice,
			Model model
			){
		        ResponseResult rr = new ResponseResult();
	          	List<Notice> Notices = noticeService.selectByExample();
	          	User user = (User)session.getAttribute("user");
	     	    String createName = user.getUid();
			     notice.setCreateName(createName);
			     notice.setCreateTime(new Date());
			     int i = noticeService.saveNotice(notice);
			model.addAttribute("saveNotices",Notices);
			  if(i!=0) {
				   rr.setStateCode(1);
				   rr.setMessage("发布成功");
			   }else {
				   rr.setStateCode(0);
					rr.setMessage("发布失败");
			   }
			return rr;
	}
	
	/**
	 * 通过id查询
	 * @return
	 */
	@RequestMapping("/findBynoticeId/{noticeId}")
	public String findBynoticeId(@PathVariable Integer noticeId,Model model) {
		 Notice notice = noticeService.selectByPrimaryKey(noticeId);
		 List<Dept> depts = noticeService.selectByDept(null);
		 model.addAttribute("noticeDept", depts);
		 model.addAttribute("noticeFindById",notice);
		return "updateBulletin";
	
	}
	
	/**
	 * 通过最近时间查询
	 * @return
	 */
	@RequestMapping("/findByNearTime")
	public ResponseResult findByNearTime(Model model) {
		ResponseResult rr = new ResponseResult();
		List<Notice> noticeTime = noticeService.selectByTime(); 
		 //model.addAttribute("findByNearTime",noticeTime);
		rr.add("findByNearTime", noticeTime);
		return rr;
	
	}
	
	/**根据id删除部门
	 * @param ids
	 * @return
	 */
	 @RequestMapping("/deleteNotice/{ids}")
	public String deleteDept(@PathVariable("ids") String ids) {
		ResponseResult rr = new ResponseResult();
		// 批量刪除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(Integer.parseInt(string));
				noticeService.deleteDeptBatch(listId);
			}
		// 单个删除
		} else {
			Integer id = Integer.parseInt(ids);
			noticeService.deleteDept(id);
				}
		return "redirect:/notice/selectByParams";	
	}
	

	/**
	 * 修改公告
	 * @param title
	 * @param content
	 * @param type
	 * @param browsePower
	 * @param createName
	 */
	@RequestMapping("/updateNotice")
	public String updateNotice(
			 HttpSession session,
			 Integer noticeId,
			 Notice notice,
			 Model model
			){
	         	ResponseResult rr = new ResponseResult();
	         	User user = (User)session.getAttribute("user");
	     	    String createName = user.getUid();
			     notice.setNoticeId(noticeId);
			     notice.setCreateName(createName);
			     notice.setCreateTime(new Date());
			int i = noticeService.updateByPrimaryKeySelective(notice);
			if(i!=0) {
				rr.setStateCode(1);
				rr.setMessage("修改成功");
			}else {
				rr.setStateCode(0);
				rr.setMessage("修改失败");
			}
		
			return "redirect:/notice/selectByParams";
	}
	

	/**
	 * 模糊查询
	 * @return
	 * @throws ParseException 
	 */
	
	@RequestMapping("/selectByParams")
	public String selectByParams(
			HttpSession session,
			Integer type,
			String Info,
			String dateStart,
			String finalTime,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            Model model
			) throws ParseException {
		 Map<String, Object> map = new HashMap<String, Object>();		 
		 if(dateStart != null&&!dateStart.equals("") && finalTime != null&& !finalTime.equals("")) {
			 String startTime= dateStart+" "+"00:00:00";
			 String endTime = finalTime+" "+"23:59:59";
			 System.out.println(startTime+endTime);
			 map.put("startTime", startTime);
		     map.put("endTime", endTime);
		 }
		  User user = (User)session.getAttribute("user");
	      String uDeptName = user.getDept().getDeptName();
	      System.out.println(uDeptName);
	      if(type !=null ) {
	    	   map.put("type", type);
	      }
	      if(Info !=null ) {
	    		map.put("Info", Info);
	      }
	      if(uDeptName !=null ) {
	    	  map.put("browsePower", uDeptName);
	      }
	     	map.put("allDept", "所有部门");
			PageHelper.startPage(pageNo, pageSize);
			List<Notice> newNotices = noticeService.selectByParams(map);
			for (Notice notice : newNotices) {
				System.out.println(notice);
			}
	    	PageInfo<Notice> page = new PageInfo<Notice>(newNotices, 3);
			model.addAttribute("pageInfo", page);
			return "bulletinManage";
		
	}
	

}