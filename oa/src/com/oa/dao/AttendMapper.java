package com.oa.dao;

import com.oa.bean.Attend;
import com.oa.bean.AttendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendMapper {
    long countByExample(AttendExample example);

    int deleteByExample(AttendExample example);

    int deleteByPrimaryKey(Integer attendId);

    int insert(Attend record);

    int insertSelective(Attend record);

    List<Attend> selectByExample(AttendExample example);

    Attend selectByPrimaryKey(Integer attendId);

    int updateByExampleSelective(@Param("record") Attend record, @Param("example") AttendExample example);

    int updateByExample(@Param("record") Attend record, @Param("example") AttendExample example);

    int updateByPrimaryKeySelective(Attend record);

    int updateByPrimaryKey(Attend record);
    
    Attend selectSaveDayIsAttend(@Param("userId") String userId);
    
    List<Attend> getAttendList();
    
    /**
     * 列表
     * @param attend
     * @return
     */
    List<Attend> selectByMothAndUserId(Attend attend);
    
}