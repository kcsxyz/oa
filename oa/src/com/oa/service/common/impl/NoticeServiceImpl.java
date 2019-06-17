
package com.oa.service.common.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Dept;
import com.oa.bean.DeptExample;
import com.oa.bean.Notice;
import com.oa.bean.NoticeExample;
import com.oa.bean.NoticeExample.Criteria;
import com.oa.dao.DeptMapper;
import com.oa.dao.NoticeMapper;
import com.oa.service.common.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
 
	@Resource
	private NoticeMapper  noticeMapper;
	@Resource
	private DeptMapper  deptMapper;
	/**
	 * 发布公告
	 */
	public int saveNotice(Notice notice) {

		int   i =noticeMapper.insert(notice);
			return i;
			
	}

	/**
	 * 根据公告id查询
	 */
	public Notice selectByPrimaryKey(Integer noticeId) {
		Notice notice=noticeMapper.selectByPrimaryKey(noticeId);
		return notice;
	}
	
	
	/**
	 * 根据id删除单条信息
	 */
	public void deleteDept(Integer id) {
		noticeMapper.deleteByPrimaryKey(id);
		
	}
	
	/**
	 * 批量删除
	 */
	public void deleteDeptBatch(List<Integer> listId) {
		NoticeExample de = new NoticeExample();
		Criteria ct = de.createCriteria();
		ct.andNoticeIdIn(listId);
		noticeMapper.deleteByExample(de);
		
	}



	/**
	 * 修改
	 */
	public int updateByPrimaryKeySelective(Notice notice) {
		int i = 0;
		try {
			i = noticeMapper.updateByPrimaryKey(notice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 查询所有
	 */
	public List<Notice> selectByExample() {
		List<Notice>  notices = noticeMapper.selectFindAll();
		return notices;
	}

	/**
	 * 模糊查询根据  title、content、type
	 */
	public List<Notice> findByMany(String noticeInfo) {
		List<Notice> notices = noticeMapper.findByMany(noticeInfo);
		for (Notice notice : notices) {
			System.out.println(notice);
		}
		return notices;
	}
    /**
         * 条件查询：模糊查询根据  title、content、type以及查询时间段
     */
	public List<Notice> selectByParams(Map<String, Object> params) {
		List<Notice> notices =noticeMapper.selectByParams(params);
		
		return notices;
				
	}
//	/**
//	 * 根据id删除单条信息
//	 */
//	public int deleteByPrimaryKey(Integer noticeId) {
//		return noticeMapper.deleteByPrimaryKey(noticeId);
//	}
//	
//	/**
//	 * 批量删除
//	 */
//	public int deleteMany(Integer[] ids) {
//		return noticeMapper.deleteMany(ids);
//	}

	public List<Dept> selectByDept(DeptExample example) {
		 List<Dept> depts = deptMapper.selectByExample(null);
		return depts;
	}

	@Override
	public List<Notice> selectByTime() {
		 List<Notice> notices = noticeMapper.selectByTime();
		return notices;
	}


	

}