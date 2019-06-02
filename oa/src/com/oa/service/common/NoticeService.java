package com.oa.service.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oa.bean.Notice;
import com.oa.bean.NoticeExample;

public interface NoticeService {
	/**
	  * 发布公布
	 * @param notice
	 * @return 
	 */
     int saveNotice(Notice notice);
     
     /**
           * 根据公告id查询
      * @param noticeId
      * @return
      */
     Notice selectByPrimaryKey(Integer noticeId);  
     
//     /**
//           * 根据id删除单条id信息
//      * @param noticeId
//      * @return
//      */
//     int deleteByPrimaryKey(Integer noticeId);
//     /**
//      * 批量删除
//      */
//     int deleteMany(Integer[] ids);
     
     /**
           * 根据单个id删除
      * @param id
      */
       void deleteDept(Integer id);
       /**
              * 批量删除
        * @param listId
        */
       void deleteDeptBatch(List<Integer> listId);
     /**
          * 修改公告
      * @param notice
      * @return
      */
    int updateByPrimaryKeySelective(Notice notice);
    /**
         *  查询所有
     * @param example
     * @return
     */
    List<Notice> selectByExample();
    /**
         * 模糊查询根据  title、content、type
     * @param noticeInfo
     * @return
     */
    List<Notice> findByMany(String noticeInfo);
    
    /**
     * 条件查询：模糊查询根据  title、content、type以及查询时间段
     * @param params
     * @return
     */
    List<Notice> selectByParams(@Param("param") Map<String, String> params); 
}
