
package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.Schedule;

public interface ScheduleService {
	//查询所有工作日程
	List<Schedule> selectSchedule();
	//根据id查询
	Schedule getScheduleById(Integer id);
	//新增用户
	int addSchedule(Schedule schedule);
	//批量删除
	void deleteScheduleBatch(List<Integer> listId);
	//批量删除
	void deleteSchedule(Integer id1);
	//修改
	void updateSchedule(Schedule schedule);
	//模糊查询
	List<Schedule> selectLikeSchedule(String info, String startTime, String endTime);

}