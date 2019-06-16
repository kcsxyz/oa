package com.oa.controller.deptOffice;

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
import com.oa.bean.Attend;
import com.oa.bean.Permission;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.bean.WorkTime;
import com.oa.service.deptOffice.AttendService;
import com.oa.utils.WorkTimeUtils;

@Controller
@RequestMapping("attend")
public class AttendController {
	
	@Resource
	private AttendService attendService;
	
	@RequestMapping("/workTimePage")
	public String workTimePage() {
		
		return "system/workTime";
	}
	
	@RequestMapping("/attentPage")
	public String attentPage() {
		
		return "deptOffice/attend";
	}
	
	 @RequestMapping("/attendList")
	 @ResponseBody
	 public ResponseResult attendList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {	
	    	ResponseResult rr =new ResponseResult();
	        //考勤时间工作
	    	PageHelper.startPage(pageNo, pageSize);
	    	List<Attend> attendList = attendService.getAttendList();
	    	PageInfo<Attend> pageInfo = new PageInfo<Attend>(attendList,3);
	    	if(attendList !=null) {
	    		rr.add("pageInfo", pageInfo);
	    		rr.setStateCode(1);
	    	}else {
	    		rr.setStateCode(0);
	    	}
	        
	        return rr;
	        
	    }

    @RequestMapping("/workTimeList")
    @ResponseBody
    public ResponseResult workTimeList(Model model) {	
    	ResponseResult rr =new ResponseResult();
        //考勤时间工作
    	List<WorkTime> workTimeList = attendService.getWorkTimeList();
    	if(workTimeList !=null) {
    		rr.add("workTimeList", workTimeList);
    		rr.setStateCode(1);
    	}else {
    		rr.setStateCode(0);
    	}
        
        return rr;
        
    }
	/**保存打卡
	 * @param attend
	 * @param session
	 * @return
	 */
	@RequestMapping("/addSave")
	@ResponseBody
	public ResponseResult saveAttend(Attend attend,HttpSession session) {
		ResponseResult rr =new ResponseResult();
		try {
			User user = (User) session.getAttribute("user");
			attend.setUserId("admin");
			int i = attendService.insertAttend(attend);
			rr.setStateCode(1);
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			rr.setMessage(e.getMessage());
			rr.setStateCode(0);
			//e.printStackTrace();
		}
		
		return rr;
	}
	
	@RequestMapping("/isAttend")
    @ResponseBody
    public Date isAttend(HttpSession session)
    {
		User user = (User) session.getAttribute("user");
        Attend attend = attendService.selectSaveDayIsAttend("admin");
       System.out.println("attend"+attend.toString());
        WorkTime workShif = attendService.selectUsing();
        Date date = new Date();
        long currDate = date.getTime();

        if (attend != null)
        {

            //早打卡 打卡开始时间 < 当前打卡时间 < 下班时间
            if (WorkTimeUtils.attendStartMorTime(date,workShif) <= currDate && currDate < WorkTimeUtils.MorWorkEndTime(date,
                    workShif))
            {
                if (attend.getAttendMorStart() != null)
                {
                }
            }
            //中午下班打卡
            else if (WorkTimeUtils.leaveMorStartTime(date,workShif) <= currDate && currDate <= WorkTimeUtils.leaveMorEnddate(date,
                    workShif))
            {
                if (attend.getAttendMorLeave() != null)
                {
                    return attend.getAttendMorLeave();
                }
            }
            //下午上班打卡
            else if (WorkTimeUtils.attendAfterNoonStatrTime(date,
                    workShif) <= currDate && currDate < WorkTimeUtils.attendAfterNoonEndTime(date,workShif))
            {
                if (attend.getAttendNoonStart() != null)
                {
                    return attend.getAttendNoonStart();
                }
            }
            else if (WorkTimeUtils.AttendAfterNoonLeaveStartTime(date,
                    workShif) <= currDate && currDate <= WorkTimeUtils.AttendAfterNoonLeaveEndTime(date,workShif))
            {
                if (attend.getAttendNoonLeave() != null)
                {
                    return attend.getAttendNoonLeave();
                }
            }
        }
        return null;
    }
	
	/**
     * 获取工作时间，返回前台
     */
    @RequestMapping("/getWorkTime")
    @ResponseBody
    public Map<String, Long> getWorkTime()
    {

        WorkTime workShif = attendService.selectUsing();
        Date date = new Date();
        Map<String, Long> map = new HashMap<>();

        if (workShif != null)
        {

            //早上上班时间
            map.put("morWorkStartTime", WorkTimeUtils.MorWorkStartTime(date,workShif));
            // 早上下班时间
            map.put("morWorkEndTime", WorkTimeUtils.MorWorkEndTime(date,workShif));

            //早上开始打卡时间
            map.put("attendStartMorTime", WorkTimeUtils.attendStartMorTime(date,workShif));
            //早上结束打卡时间
            map.put("attendEndMorTime", WorkTimeUtils.attendEndMorTime(date,workShif));

            //早上下班打卡开始时间
            map.put("leavMorStartTime", WorkTimeUtils.leaveMorStartTime(date,workShif));
            //早上下班打卡结束时间
            map.put("leavMorEndtTime", WorkTimeUtils.leaveMorEnddate(date,workShif));


            //下午上班打卡开始时间
            map.put("attendAfterNoonStatrTime", WorkTimeUtils.attendAfterNoonStatrTime(date,workShif));
            //下午上班打卡结束时间
            map.put("attendAfterNoonEndTime", WorkTimeUtils.attendAfterNoonEndTime(date,workShif));

            //下午上班开始时间
            map.put("afterNoonStarWorkTime", WorkTimeUtils.AfterNoonStarWorkTime(date,workShif));
            //下午上班结束时间
            map.put("afterNonEndWorkTime", WorkTimeUtils.AfterNonEndWorkTime(date,workShif));

            //下午下班开始打卡时间
            map.put("attendAfterNoonStartTime", WorkTimeUtils.AttendAfterNoonLeaveStartTime(date,workShif));
            //下午下班结束打卡时间
            map.put("attendAfterNoonEndTime", WorkTimeUtils.AttendAfterNoonLeaveEndTime(date,workShif));

        }
        return map;
    }

	
}
