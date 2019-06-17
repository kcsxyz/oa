package com.oa.service.personSetting.impl;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Leave;
import com.oa.bean.LeaveExample;
import com.oa.bean.LeaveExample.Criteria;
import com.oa.dao.LeaveMapper;
import com.oa.service.personSetting.LeaveService;
@Service
public class LeaveServiceImpl implements LeaveService {
	@Resource 
	private LeaveMapper leaveMapper;

	@Override
	public List<Leave> selectLeave() {
		// TODO Auto-generated method stub
		return leaveMapper.selectByExample(null);
	}

	@Override
	public Leave getLeaveById(Integer id) {
		// TODO Auto-generated method stub
		return leaveMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addLeave(Leave leave) {
		// TODO Auto-generated method stub
		int i=leaveMapper.insert(leave);
		return i;
	}

	@Override
	public void deleteLeaveBatch(List<Integer> listId) {
		// TODO Auto-generated method stub
		LeaveExample de=new LeaveExample();
		Criteria ct=de.createCriteria();
		ct.andIdIn(listId);		
		leaveMapper.deleteByExample(de);
	}

	@Override
	public void deleteLeave(Integer id1) {
		leaveMapper.deleteByPrimaryKey(id1);
	}

	@Override
	public int updateLeave(Leave leave) {
		int i=leaveMapper.updateByPrimaryKeySelective(leave);
		return i;		
	}

	@Override
	public List<Leave> selectLikeLeave(String info, String startTime, String endTime) {
		LeaveExample de = new LeaveExample();
		Criteria ct = de.createCriteria();
		ct.andLeaveTypeLike("%"+info+"%");
		Criteria ct2 = de.createCriteria();
		ct2.andLeaveReasonLike("%"+info+"%");
		Criteria ct3 = de.createCriteria();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		Date date1;
		Date date2;
		try {
			date1 = formatter.parse(startTime);
			date2=formatter.parse(endTime);
			ct3.andCreateTimeBetween(date1, date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		de.or(ct2);
		de.or(ct3);
		return leaveMapper.selectByExample(de);
	}
	
}
