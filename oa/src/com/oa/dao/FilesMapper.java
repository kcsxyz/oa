package com.oa.dao;

import com.oa.bean.Files;
import com.oa.bean.FilesExample;
import com.oa.bean.WorkPlan;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FilesMapper {
    long countByExample(FilesExample example);

    int deleteByExample(FilesExample example);

    int deleteByPrimaryKey(String fileId);

    int insert(Files record);

    int insertSelective(Files record);

    List<Files> selectByExample(FilesExample example);
    
    List<Files> selectByParams(@Param("param") Map<String, String> params);

    Files selectByPrimaryKey(String fileId);
    
    int updateByExampleSelective(@Param("record") Files record, @Param("example") FilesExample example);

    int updateByExample(@Param("record") Files record, @Param("example") FilesExample example);

    int updateByPrimaryKeySelective(Files record);

    int updateByPrimaryKey(Files record);
}