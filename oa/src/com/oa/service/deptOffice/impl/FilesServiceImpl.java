package com.oa.service.deptOffice.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Files;
import com.oa.bean.FilesExample;
import com.oa.bean.FilesExample.Criteria;
import com.oa.bean.Project;
import com.oa.bean.ProjectExample;
import com.oa.dao.FilesMapper;
import com.oa.dao.ProjectMapper;
import com.oa.service.deptOffice.FilesService;
@Service
public class FilesServiceImpl implements FilesService {
	@Resource
	private FilesMapper filesMapper;
	
	@Resource
	private ProjectMapper projectMapper;

	@Override
	public int insertSelective(Files files) {
		
		return filesMapper.insertSelective(files);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		int i=filesMapper.deleteByPrimaryKey(id);
		return i;
	}

	@Override
	public void deleteDeptBatch(List<String> listId) {
		FilesExample example = new FilesExample();
		Criteria c = example.createCriteria();
		c.andFileIdIn(listId);
		filesMapper.deleteByExample(example);
	}

	@Override
	public int updateByPrimaryKeySelective(Files files) {
		
		return filesMapper.updateByPrimaryKeySelective(files);
	}

	@Override
	public List<Files> selectByParams(Map<String, String> params) {
		 List<Files> files = filesMapper.selectByParams(params);
		return files;
	}

	@Override
	public int checkFileById(String fileId) {
		FilesExample example = new FilesExample();
		Criteria c = example.createCriteria();
		c.andFileIdEqualTo(fileId);
		List<Files> list = filesMapper.selectByExample(example);
		if(list.size()!=0) {
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public boolean checkFileByname(String fileName) {
		FilesExample example = new FilesExample();
		Criteria c = example.createCriteria();
		c.andFileNameEqualTo(fileName);
		return filesMapper.selectByExample(example) !=null;
	}

	@Override
	public Files selectByPrimaryKey(String fileId) {
		Files f = filesMapper.selectByPrimaryKey(fileId);
		return f;
	}

	@Override
	public List<Project> selectByExample(ProjectExample example) {
		List<Project> projects = projectMapper.selectByExample(example);
		return projects;
	}

}
