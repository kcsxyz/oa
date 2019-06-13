package com.oa.service.deptOffice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oa.bean.Files;
import com.oa.bean.Project;
import com.oa.bean.ProjectExample;

public interface FilesService {
	/**
	 * 上传文件
	 * @param project
	 * @return
	 */
	int insertSelective(Files files);
	/**
	 * 根据id删除
	 */
	 int deleteByPrimaryKey(String id);
	 /**
	  * 批量删除
	  * @param example
	  * @return
	  */
	void deleteDeptBatch(List<String> listId);
	/**
	 * 修改
	 * @param record
	 * @return
	 */
    int updateByPrimaryKeySelective(Files files);
    /**
         * 查询文件
     * @param params
     * @return
     */
    List<Files> selectByParams(@Param("param") Map<String, String> params);
  /**
   * 根据id查询
   * @param fileId
   * @return
   */
    Files selectByPrimaryKey(String fileId);
    /**
         * 判断id是否重复
     */
	int checkFileById(String fileId);
	/**
	  * 判断name是否重复
	 * @param fileName
	 * @return
	 */
	boolean checkFileByname(String fileName);
	
	 List<Project> selectByExample(ProjectExample example);
}
