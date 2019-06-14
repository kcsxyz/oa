package com.oa.dao;

import com.oa.bean.User;
import com.oa.bean.UserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //根据用户id和密码查询
    User findUserByNameAndPwd(@Param("uid")String uid, @Param("password")String password);
    //更新密码
	int updatePassword(User user);
	//查询所有用户
	List<User> getUserList();
	//模糊查询
	List<User> selectLikeUser(@Param("userInfo")String userInfo);
	//人力资源中的查询
	List<User> selectByParams(@Param("param") Map<String,String> param);
	
	User getUserMap(@Param("uid")String uid);

	List<User> selectByDept(Integer id);

	List<User> selectByNameLike(String info);
}