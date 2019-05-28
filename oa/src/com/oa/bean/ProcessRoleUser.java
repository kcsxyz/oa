package com.oa.bean;

public class ProcessRoleUser {
    private String processRoleName;

    private String userId;

    private Integer deptId;

    public String getProcessRoleName() {
        return processRoleName;
    }

    public void setProcessRoleName(String processRoleName) {
        this.processRoleName = processRoleName == null ? null : processRoleName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}