package com.oa.dao;

import com.mysql.fabric.xmlrpc.base.Data;
import com.oa.bean.Schedule;
import com.oa.bean.ScheduleExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleMapper {
    long countByExample(ScheduleExample example);

    int deleteByExample(ScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

	List<Schedule> selectSchedule(String string);

	List<Schedule> getScheduleList(String uid, String info,String start, String end);

	Schedule selectByDate(Date de);
   
}