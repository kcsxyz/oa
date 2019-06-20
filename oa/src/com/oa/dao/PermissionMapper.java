package com.oa.dao;

import com.oa.bean.Permission;
import com.oa.bean.PermissionExample;
import com.oa.bean.RolePermission;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer permId);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer permId);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> selectByExampleWithPermission(PermissionExample example);
    
    List<Permission> getPermissionListByUserRole(@Param("roleId") Integer roleId);

	List<RolePermission> getRolePermission(Integer id);

	List<Permission> getParPermissionList(Integer id);
    
}