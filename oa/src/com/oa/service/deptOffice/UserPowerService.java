
package com.oa.service.deptOffice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oa.bean.User;
import com.oa.bean.UserExample;

public interface UserPowerService {
	/**
	 * 录入信息
	 * @param record
	 * @return
	 */
	 int insertSelective(User user);
	 /**
	    * 单个修改
	  * @param record
	  * @return
	  */
	 int updateByPrimaryKeySelective(User user);
	 /**
	  * 根据id查询
	  * @param uid
	  * @return
	  */
	 User selectByPrimaryKey(String uid);
	/**
	 * 根据id删除
	 */
	 int deleteByPrimaryKey(String uid);
	 /**
	  * 批量删除
	  * @param example
	  * @return
	  */
	void deleteDeptBatch(List<String> listId);
	/**
	 * 条件查找
	 * @param map
	 * @return
	 */
	List<User> selectByParams(@Param("param")Map<String, String> param);
	  
}

