package com.oa.dao;

import com.oa.bean.WorkLog;
import com.oa.bean.WorkLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkLogMapper {
    long countByExample(WorkLogExample example);

    int deleteByExample(WorkLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(WorkLog record);

    int insertSelective(WorkLog record);

    List<WorkLog> selectByExample(WorkLogExample example);

    WorkLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") WorkLog record, @Param("example") WorkLogExample example);

    int updateByExample(@Param("record") WorkLog record, @Param("example") WorkLogExample example);

    int updateByPrimaryKeySelective(WorkLog record);

    int updateByPrimaryKey(WorkLog record);

	List<WorkLog> getWorkLogByCreateName(String uid);

	List<WorkLog> selectList(String uid, String workLogInfo, String start, String end);
    
}