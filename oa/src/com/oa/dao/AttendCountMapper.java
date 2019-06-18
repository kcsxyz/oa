package com.oa.dao;

import com.oa.bean.AttendCount;
import com.oa.bean.AttendCountExample;
import com.oa.bean.Leave;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendCountMapper {
    long countByExample(AttendCountExample example);

    int deleteByExample(AttendCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttendCount record);

    int insertSelective(AttendCount record);

    List<AttendCount> selectByExample(AttendCountExample example);

    AttendCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttendCount record, @Param("example") AttendCountExample example);

    int updateByExample(@Param("record") AttendCount record, @Param("example") AttendCountExample example);

    int updateByPrimaryKeySelective(AttendCount record);

    int updateByPrimaryKey(AttendCount record);

	Object deleteByPrimaryKeys(Integer[] ids);
	
	/**
     * 统计请假天数
     */
    List<Leave> selectByUserIdAndDate(Leave leaveForm);
}