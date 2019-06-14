package com.oa.dao;

import com.oa.bean.Leave;
import com.oa.bean.LeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaveMapper {
    long countByExample(LeaveExample example);

    int deleteByExample(LeaveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    int insertSelective(Leave record);

    List<Leave> selectByExample(LeaveExample example);

    Leave selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Leave record, @Param("example") LeaveExample example);

    int updateByExample(@Param("record") Leave record, @Param("example") LeaveExample example);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);

	List<Leave> getNeedAuditLeave(@Param("queryStr")String queryStr,@Param("deptId") Integer deptId,@Param("roleName") String roleName);

	List<Leave> getSeMaNeedLeaveList(@Param("queryStr")String queryStr, @Param("roleName") String roleName);
	
	Leave getLeaveById(@Param("id") Integer id);
	
}