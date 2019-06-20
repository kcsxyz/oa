package com.oa.service.deptOffice;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.oa.bean.Files;
import com.oa.bean.FilesExample;
import com.oa.bean.Project;

public interface ProjectManageService {
	/**
	 * 创建项目
	 * @param record
	 * @return
	 */
	int insertSelective(Project project);
	
	/**
	 * 根据id删除
	 */
	 int deleteByPrimaryKey(Integer uid);
	 /**
	  * 批量删除
	  * @param example
	  * @return
	  */
	void deleteDeptBatch(List<Integer> listId);
	
	Project selectByPrimaryKey(Integer projectId);
	/**
	 * 修改
	 * @param record
	 * @return
	 */
    int updateByPrimaryKeySelective(Project project);
    /**
         *  条件查询
     * @param example
     * @return
     */
    List<Project> selectByExample(String Info,String startTime,String finalTime)throws ParseException;
    /**
     * 验证项目名是否相同
     * @param projectName
     * @return
     */
    int checkProjectByname(String projectName);
}
