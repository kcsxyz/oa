package com.oa.service.deptOffice.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.FilesExample;
import com.oa.bean.Project;
import com.oa.bean.ProjectExample;
import com.oa.bean.ProjectExample.Criteria;
import com.oa.dao.ProjectMapper;
import com.oa.service.deptOffice.ProjectManageService;
@Service
public class ProjectManageServiceImpl implements ProjectManageService {
    @Resource
	private  ProjectMapper projectMapper;



	public int deleteByPrimaryKey(Integer ids) {
		int i = projectMapper.deleteByPrimaryKey(ids);
		return i;
	}


	public void deleteDeptBatch(List<Integer> listId) {
		ProjectExample project = new ProjectExample();
		Criteria c = project.createCriteria();
		c.andProjectIdIn(listId);
		projectMapper.deleteByExample(project);
	}


	public int insertSelective(Project project) {
		int i = projectMapper.insertSelective(project);
		return i;
	}


	public int updateByPrimaryKeySelective(Project project) {
		int i = projectMapper.updateByPrimaryKeySelective(project);
		return i;
	}


	public List<Project> selectByExample(String Info,String startTime,String finalTime) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
		ProjectExample example = new ProjectExample();
		Criteria c1 = example.createCriteria();
		Criteria c2 = example.createCriteria();
		if(startTime != null&&!startTime.equals("") && finalTime != null&& !finalTime.equals("")) {
		    Date beforeTime = sdf.parse(startTime);
		    Date finallyTime  = sdf.parse(finalTime);
		    Calendar rightNow = Calendar.getInstance();
				rightNow.setTime(finallyTime);
				rightNow.add(Calendar.HOUR,23);
				rightNow.add(Calendar.MINUTE,59);
				rightNow.add(Calendar.SECOND,59);
			Date endTime = rightNow.getTime();
			c1.andCreateTimeBetween(beforeTime, endTime);
			}
		if(Info!=null) {
			c1.andProjectNameLike("%"+"Info"+"%");
			c2.andCreateNameLike("%"+"Info"+"%");
			example.or(c2);
		}
		
		List<Project> p = projectMapper.selectByExample(example);
		return p;
	}

	public Project selectByPrimaryKey(Integer projectId) {
		Project project = projectMapper.selectByPrimaryKey(projectId);
		return project;
	}

	public int checkProjectByname(String projectName) {
		ProjectExample example = new ProjectExample();
		Criteria c = example.createCriteria();
		c.andProjectNameEqualTo(projectName);
		List<Project> list = projectMapper.selectByExample(example);
		if(list.size()!=0) {
			return 1;
		}else {
			return 0;
		}
	}
    
}
