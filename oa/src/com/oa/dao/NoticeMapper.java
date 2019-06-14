package com.oa.dao;

import com.oa.bean.Notice;
import com.oa.bean.NoticeExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;
@ResponseBody
public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);
    
    int deleteMany(Integer[] ids);

    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);
    
    List<Notice> selectFindAll();
    
    List<Notice> selectByTime();
    
    List<Notice> findByMany(String noticeInfo);
    
    List<Notice> selectByParams(@Param("param") Map<String, Object> params);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

	
}