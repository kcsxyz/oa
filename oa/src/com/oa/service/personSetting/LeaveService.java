package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.Leave;

public interface LeaveService {
	//查询所有
	List<Leave> selectLeave();
	//根据id查询
	Leave getLeaveById(Integer id);
	//新增请假
	int addLeave(Leave leave);
	//批量删除
	void deleteLeaveBatch(List<Integer> listId);
	//单个删除
	void deleteLeave(Integer id1);
	//修改
	int updateLeave(Leave leave);
	//模糊查询
	List<Leave> selectLikeLeave(String info, String startTime, String endTime);

}
