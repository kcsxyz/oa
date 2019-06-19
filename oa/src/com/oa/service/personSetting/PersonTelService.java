package com.oa.service.personSetting;

import java.util.List;

import com.oa.bean.PersonTel;

public interface PersonTelService {
	//根据UID查询
	List<PersonTel> selectByUid(String uid);
	//新增
	int addpersonTel(PersonTel personTel);
	
	//单个删除
	void deletePersonTel(String uid, String id);
	
	List<PersonTel> selectByDept(String uid,Integer id);
	
	List<PersonTel> selectLike(String uid, String info);
	
	Object getPersonTel(String uid, String pid);

}
