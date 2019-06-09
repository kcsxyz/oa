package com.oa.bean;

public class RolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permId;
    
    public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

	public RolePermission(Integer roleId, Integer permId) {
		super();
		this.roleId = roleId;
		this.permId = permId;
	}

	
    
    
}