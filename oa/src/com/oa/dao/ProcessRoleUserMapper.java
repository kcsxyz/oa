package com.oa.dao;

import com.oa.bean.ProcessRoleUser;
import com.oa.bean.ProcessRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessRoleUserMapper {
    long countByExample(ProcessRoleUserExample example);

    int deleteByExample(ProcessRoleUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessRoleUser record);

    int insertSelective(ProcessRoleUser record);

    List<ProcessRoleUser> selectByExample(ProcessRoleUserExample example);

    ProcessRoleUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessRoleUser record, @Param("example") ProcessRoleUserExample example);

    int updateByExample(@Param("record") ProcessRoleUser record, @Param("example") ProcessRoleUserExample example);

    int updateByPrimaryKeySelective(ProcessRoleUser record);

    int updateByPrimaryKey(ProcessRoleUser record);
}