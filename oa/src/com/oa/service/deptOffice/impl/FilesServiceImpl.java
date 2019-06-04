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
import com.oa.dao.FilesMapper;
import com.oa.service.deptOffice.FilesService;
@Service
public class FilesServiceImpl implements FilesService {
	@Resource
	private FilesMapper filesMapper;

	@Override
	public int insertSelective(Files files) {
		
		return filesMapper.insertSelective(files);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return filesMapper.deleteByPrimaryKey(id);
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
	public boolean checkFileById(String fileId) {
		
		return filesMapper.selectByPrimaryKey(fileId) !=null;
	}

	@Override
	public boolean checkFileByname(String fileName) {
		FilesExample example = new FilesExample();
		Criteria c = example.createCriteria();
		c.andFileNameEqualTo(fileName);
		return filesMapper.selectByExample(example) !=null;
	}

}
