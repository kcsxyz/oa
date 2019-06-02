package com.oa.service.common.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Notice;
import com.oa.bean.NoticeExample;
import com.oa.bean.NoticeExample.Criteria;
import com.oa.dao.NoticeMapper;
import com.oa.service.common.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
 
	@Resource
	private NoticeMapper  noticeMapper;

	/**
	 * 发布公告
	 */
	public void saveNotice(Notice notice) {
	       if(notice == null) {
	    	   System.out.println("发布数据失败，可能没发布信息");
	       }
		  	 try {
				noticeMapper.insert(notice);
			} catch (Exception e) {
				System.out.println("发布失败");
				e.printStackTrace();
			}
			
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
	public int deleteByPrimaryKey(Integer noticeId) {
		return noticeMapper.deleteByPrimaryKey(noticeId);
	}
	
	/**
	 * 批量删除
	 */
	public int deleteMany(Integer[] ids) {
		return noticeMapper.deleteMany(ids);
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
		for (Notice notice : notices) {
			System.out.println(notice);
		}
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
	public List<Notice> selectByParams(Map<String, String> params) {
		List<Notice> notices =noticeMapper.selectByParams(params);
		
		for (Notice notice : notices) {
		
			System.out.println(notice);
		}
		return notices;
				
	}

	


	

	
	
	
	

}
