package com.oa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.bean.Files;
import com.oa.bean.Notice;
import com.oa.bean.Project;
import com.oa.bean.ProjectExample;
import com.oa.bean.ProjectExample.Criteria;
import com.oa.bean.User;
import com.oa.bean.WorkPlan;
import com.oa.dao.FilesMapper;
import com.oa.dao.NoticeMapper;
import com.oa.dao.ProjectMapper;
import com.oa.dao.UserMapper;
import com.oa.dao.WorkPlanMapper;
import com.oa.service.common.NoticeService;
import com.oa.service.common.impl.NoticeServiceImpl;
import com.oa.service.deptOffice.UserPowerService;

public class CommonTest {
    @Autowired
	private NoticeMapper noticeMapper;
	
   @Test
	public void test1() throws ParseException {
		String Info = "2";
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		NoticeMapper um= ac.getBean("noticeMapper", NoticeMapper.class);
		List<Notice> n =um.selectByTime();
		for (Notice notice : n) {
			System.out.println(notice);
		}
	}

		@Test
		public void test2() throws ParseException {
			
			 Map<String, Object> map = new HashMap<String, Object>();
			    String Info = "";
				String startDate = "2019-05-29 00:00:00";
				String endDate = "2019-06-02 23:03:14";
				map.put("type", 0);
				map.put("Info", Info);
		       map.put("startTime",startDate);
		       map.put("endTime",endDate);

			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			NoticeMapper um= ac.getBean("noticeMapper", NoticeMapper.class);
			List<Notice> n =um.selectByParams(map);
			for (Notice notice : n) {
				System.out.println(notice);
			}
	}
		
		public void workPlanTest1() {
			
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			WorkPlanMapper wm = ac.getBean("workPlanMapper",WorkPlanMapper.class);
			WorkPlan workplan = new WorkPlan();
			workplan.setId(1);
			workplan.setStatus(2);
		    wm.updateByPrimaryKeySelective(workplan);
		}
		
		
		
	
			public void UserPowerTest1() {
				
				ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
				UserMapper us= ac.getBean("userMapper",UserMapper.class);
				User user = new User();
				user.setUid("1100");
				user.setPassword("123");
				user.setName("张三1");
				us.insertSelective(user);
			}
		
	
		public void UserPowerTest2() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserMapper us= ac.getBean("userMapper",UserMapper.class);
			User user = new User();
			user.setUid("1100");
			user.setPassword("111");
			user.setName("张");
			us.updateByPrimaryKeySelective(user);
		}
		
		@Test
		public void filesTest() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			FilesMapper m = ac.getBean("filesMapper",FilesMapper.class);
			Map<String,String>  map = new HashMap<>();
			map.put("Info", "111");
		//	List<Files>  f = m.selectByParams(map);
		    //    for (Files files : f) {
			//		System.out.println(files);
			//	}
			}
		
		public void projectTest1() throws ParseException {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			ProjectMapper pm = ac.getBean("projectMapper",ProjectMapper.class);
			ProjectExample example = new ProjectExample();
			Criteria c3 = example.createCriteria();
			String Time = "2019-06-02";
			String time = "2019-06-03";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
		    Date startTime = sdf.parse(Time);
		    Date endTime =  sdf.parse(time);
		    Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(endTime);
			rightNow.add(Calendar.HOUR,23);
			rightNow.add(Calendar.MINUTE,59);
			rightNow.add(Calendar.SECOND,59);
			Date endTime1 = rightNow.getTime();
		    System.out.println(endTime1);
		    Date date1 = new java.sql.Date(endTime.getTime());
		    System.out.println(endTime1+"---"+date1);
			c3.andCreateTimeBetween(startTime,endTime1);
			List<Project> p = pm.selectByExample(example);
			for (Project project : p) {
				System.out.println(project);
			}
			
		}
		@SuppressWarnings("unused")
		@Test
		public void test001() throws ParseException {
			String startTime = null;
			String finalTime = null;
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			ProjectMapper pm = ac.getBean("projectMapper",ProjectMapper.class);
			ProjectExample example = new ProjectExample();
			Criteria c1 = example.createCriteria();
			Criteria c2 = example.createCriteria();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
			if(startTime != null&&!startTime.equals("") && finalTime != null&& !finalTime.equals("")) {
			
				    Date beforeTime = sdf.parse(startTime);
				    Date finallyTime  = sdf.parse(finalTime);
				    Calendar rightNow = Calendar.getInstance();
						rightNow.setTime(finallyTime);
						rightNow.add(Calendar.HOUR,23);
						rightNow.add(Calendar.MINUTE,59);
						rightNow.add(Calendar.SECOND,59);
					Date endTime = rightNow.getTime();
					c1.andCreateTimeBetween(beforeTime, endTime);
			}
			c1.andProjectNameLike("%"+"2"+"%");
			c2.andCreateNameLike("%"+"2"+"%");
			example.or(c2);
			List<Project> p = pm.selectByExample(example);
			for (Project project : p) {
				System.out.println(project);
			}
		}
		
		public void workPlanTest2() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			WorkPlanMapper wm = ac.getBean("workPlanMapper",WorkPlanMapper.class);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("deptId", 2);
			List<WorkPlan> workPlans = wm.selectByMap(map);
		//	int total = wm.selectCount(map);
			for (WorkPlan workPlan : workPlans) {
				System.out.println(workPlan);
			//	System.out.println("------------"+workPlan.getUser().getDept().getDeptName()+total);
			}
		}
		
		public void UserPowerTest121() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserMapper us= ac.getBean("userMapper",UserMapper.class);
			
		}
}
