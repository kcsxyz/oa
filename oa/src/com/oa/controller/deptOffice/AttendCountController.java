package com.oa.controller.deptOffice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Attend;
import com.oa.bean.AttendCount;
import com.oa.bean.ResponseResult;
import com.oa.service.deptOffice.AttendCountService;

@Controller
@RequestMapping("attendCount")
public class AttendCountController {
	
	@Resource
	private AttendCountService attendCountService;
	
	@RequestMapping("/tolist")
    public String toList()
    {
        return "/deptOffice/attendCount";
    }


    /**
     *
     * @描述 表格列表
     *
     * @date 2018/9/16 10:52
     */
    @RequestMapping("/attendCountList")
    @ResponseBody
    public ResponseResult attendCountList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,AttendCount attendCount)
    {
    	ResponseResult rr =new ResponseResult();
    	PageHelper.startPage(pageNo, pageSize);
        List<AttendCount> attendCounts = attendCountService.selectAttendCountList(attendCount);
        PageInfo<AttendCount> pageInfo = new PageInfo<AttendCount>(attendCounts,3);
        if(attendCounts !=null) {
    		rr.add("pageInfo", pageInfo);
    		rr.setStateCode(1);
    	}else {
    		rr.setStateCode(0);
    	}
        
        return rr;
    }


    /**
     *
     * @描述 批量删除
     *
     */
    @RequestMapping("/del")
    @ResponseBody
    public ResponseResult del(Integer[] ids)
    {
    	ResponseResult rr =new ResponseResult();
        try
        {
        	attendCountService.deleteByPrimaryKeys(ids);
        }
        catch (Exception e)
        {
            return rr.fail(e.getMessage());
        }
        return rr.success();
    }
}
