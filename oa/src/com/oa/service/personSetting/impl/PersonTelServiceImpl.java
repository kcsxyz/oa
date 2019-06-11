package com.oa.service.personSetting.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.PersonTel;
import com.oa.bean.PersonTelExample;
import com.oa.bean.PersonTelExample.Criteria;
import com.oa.dao.PersonTelMapper;
import com.oa.service.personSetting.PersonTelService;
@Service
public class PersonTelServiceImpl implements PersonTelService {
	@Resource
	private PersonTelMapper personTelMapper;

	@Override
	public List<PersonTel> selectByUid(String uid) {
		// TODO Auto-generated method stub
		PersonTelExample de=new PersonTelExample();
		Criteria ct=de.createCriteria();
		ct.andUserIdEqualTo(uid);
		return personTelMapper.selectByExample(de);
	}

	@Override
	public int addpersonTel(PersonTel personTel) {
		int i=personTelMapper.insert(personTel);
		return i;
	}

	public void deletePersonTel(String uid, String id) {			
				
		personTelMapper.deleteByUid(uid, id);
	}
}
