package com.oa.dao;

import com.oa.bean.ProcessLine;
import com.oa.bean.ProcessLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessLineMapper {
    long countByExample(ProcessLineExample example);

    int deleteByExample(ProcessLineExample example);

    int deleteByPrimaryKey(Integer processLineId);

    int insert(ProcessLine record);

    int insertSelective(ProcessLine record);

    List<ProcessLine> selectByExample(ProcessLineExample example);

    ProcessLine selectByPrimaryKey(Integer processLineId);

    int updateByExampleSelective(@Param("record") ProcessLine record, @Param("example") ProcessLineExample example);

    int updateByExample(@Param("record") ProcessLine record, @Param("example") ProcessLineExample example);

    int updateByPrimaryKeySelective(ProcessLine record);

    int updateByPrimaryKey(ProcessLine record);
}