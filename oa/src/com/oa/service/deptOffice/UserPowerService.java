package com.oa.service.deptOffice;

import com.oa.bean.User;

public interface UserPowerService {
	/**
	 * 录入信息
	 * @param record
	 * @return
	 */
	 int insertSelective(User user);
}
