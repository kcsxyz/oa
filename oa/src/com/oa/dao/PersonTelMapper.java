package com.oa.dao;

import com.oa.bean.PersonTel;
import com.oa.bean.PersonTelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonTelMapper {
    long countByExample(PersonTelExample example);

    int deleteByExample(PersonTelExample example);

    int deleteByPrimaryKey(Integer telId);

    int insert(PersonTel record);

    int insertSelective(PersonTel record);

    List<PersonTel> selectByExample(PersonTelExample example);

    PersonTel selectByPrimaryKey(Integer telId);

    int updateByExampleSelective(@Param("record") PersonTel record, @Param("example") PersonTelExample example);

    int updateByExample(@Param("record") PersonTel record, @Param("example") PersonTelExample example);

    int updateByPrimaryKeySelective(PersonTel record);

    int updateByPrimaryKey(PersonTel record);
    //根据UID删除
	void deleteByUid(String uid, String id);
	
	List<PersonTel> getPersonTelMap(String uid);

	List<PersonTel> selectPersonTelByDept(String uid,Integer id);

	List<PersonTel> selectLike(String uid, String info);

	PersonTel getPersonTel(String uid, String pid);
}