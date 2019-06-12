package com.oa.dao;

import com.oa.bean.ProcessNode;
import com.oa.bean.ProcessNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessNodeMapper {
    long countByExample(ProcessNodeExample example);

    int deleteByExample(ProcessNodeExample example);

    int deleteByPrimaryKey(Integer processNodeId);

    int insert(ProcessNode record);

    int insertSelective(ProcessNode record);

    List<ProcessNode> selectByExample(ProcessNodeExample example);

    ProcessNode selectByPrimaryKey(Integer processNodeId);

    int updateByExampleSelective(@Param("record") ProcessNode record, @Param("example") ProcessNodeExample example);

    int updateByExample(@Param("record") ProcessNode record, @Param("example") ProcessNodeExample example);

    int updateByPrimaryKeySelective(ProcessNode record);

    int updateByPrimaryKey(ProcessNode record);
    
    Integer getProcessNodeId(String processNo);
}