package com.oa.service.deptOffice;

import java.util.List;

import com.oa.bean.Attend;
import com.oa.bean.WorkTime;

public interface AttendService {

	int insertAttend(Attend attend) throws Exception;

	WorkTime selectUsing();

	Attend selectSaveDayIsAttend(String uid);

	List<WorkTime> getWorkTimeList();

	List<Attend> getAttendList();

	WorkTime getWorkTime();

}
