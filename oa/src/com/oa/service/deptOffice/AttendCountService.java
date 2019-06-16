package com.oa.service.deptOffice;

import java.util.List;

import com.oa.bean.AttendCount;

public interface AttendCountService {

	List<AttendCount> selectAttendCountList(AttendCount attendCount);

	void deleteByPrimaryKeys(Integer[] ids);
	
	//统计考勤情况
	public void insertSelective();

}
