package com.oa.controller.common;


import java.util.ArrayList;
import java.util.Date;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Notice;
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
	@RequestMapping("/saveNotice")
	@ResponseBody
	public void saveNotice(
			 HttpSession session,
			 String title, //uname是输入框中的id值,把uname的值赋给username
			 String content, 
			 int type,      
			@RequestParam("browse_power") String browsePower,
			@RequestParam("uid") String createName
			){
		      // String createName = (String) session.getAttribute("uid"); 
			     Notice notice = new Notice();
			     notice.setTitle(title);
			     notice.setContent(content);
			     notice.setBrowsePower(browsePower);
			     notice.setCreateName(createName);
			     notice.setCreateTime(new Date());
			     notice.setType(type);
		
		try {
			noticeService.saveNotice(notice);
			System.out.println("发布成功");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 通过id查询
	 * @return
	 */
	@RequestMapping("/findBynoticeId")
	@ResponseBody
	public Notice findBynoticeId(Integer noticeId) {
		Notice notice = null;
		try {
			notice = noticeService.selectByPrimaryKey(noticeId);
			System.out.println(notice.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notice;
	
	}
	
	/**
	 * 根据id删除单条数据
	 */

	@RequestMapping("/deleteBynoticeId")
	@ResponseBody
	public void deleteBynoticeId(Integer noticeId) {
		try {
			noticeService.deleteByPrimaryKey(noticeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteMany")
	@ResponseBody
	public void deletemany(@RequestParam("ids") Integer[] ids) {
		System.out.println(ids.toString()+"-----------"+ids.length);
	
			try {
				noticeService.deleteMany(ids);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	@ResponseBody
	public String updateNotice(
			 HttpSession session,
			 Integer noticeId,
			 String title, //uname是输入框中的id值,把uname的值赋给username
			 String content, 
			 int type,
			@RequestParam("browse_power") String browsePower,
			@RequestParam("uid") String createName
			){
		        // String createName = (String) session.getAttribute("uid");
			     Notice notice = new Notice();
			     notice.setNoticeId(noticeId);
			     notice.setTitle(title);
			     notice.setContent(content);
			     notice.setBrowsePower(browsePower);
			     notice.setCreateName(createName);
			     notice.setCreateTime(new Date());
			     notice.setType(type);
		
		try {
			noticeService.updateByPrimaryKeySelective(notice);
			System.out.println("修改成功");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "修改成功";
		
	}
	
	/**
	 * 模糊查询
	 * @return
	 */
	@RequestMapping("/findByMany")
	@ResponseBody
	public List<Notice> findByMany(
			@RequestParam("noticeInfo") String noticeInfo,
			
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            Model model
			) {
		// startPage后紧跟着的就是一个分页查询
		PageHelper.startPage(pageNo, pageSize);
		List<Notice> notices = noticeService.selectByExample();
		// 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
		PageInfo<Notice> page = new PageInfo<Notice>(notices, 3);
		model.addAttribute("pageInfo", page);	
			return notices;
		
	}
	/**
	 * 模糊查询
	 * @return
	 */
	@RequestMapping("/selectByParams")
	@ResponseBody
	public List<Notice> selectByParams(
			HttpSession session,
			String type,
			String Info,
			String startTime,
			String endTime,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            Model model
			) {
		System.out.println(type+"------"+Info+"----"+startTime+"---"+endTime);
		 Map<String, String> map = new HashMap<String, String>();
		    map.put("type", type);
			map.put("Info", Info);
	        map.put("startTime",startTime);
	        map.put("endTime",endTime);
	       
	    
		
	        String deptName ="办公室";
	     	 // startPage后紧跟着的就是一个分页查询
	    	//PageHelper.startPage(pageNo, pageSize);
	        List<Notice> notices = noticeService.selectByParams(map);
	       // 用PageInfo对查询后的结果进行包装，然后放到页面即可，第二个参数为navigatePages 页码数量
	       //  PageInfo<Notice> page = new PageInfo<Notice>(notices, 3);
		  //	model.addAttribute("pageInfo", page);
	       PageHelper.startPage(pageNo, pageSize);
	       List<Notice> newNotices = new ArrayList<Notice>();
	       for(int i=0;i<notices.size();i++) {
	    		Notice notice = notices.get(i);
			    if(notice.getBrowsePower().equals("所有部门") || notice.getBrowsePower().contains(deptName)){
			    	newNotices.add(notice);
			     	System.out.println("进入循环");
			    }
			    
	    	}
	    	PageInfo<Notice> page = new PageInfo<Notice>(newNotices, 3);
			//model.addAttribute("pageInfo", page);
	    	System.out.println(page.getList().size());
			return newNotices;
		
	}
	

}

