package com.oa.bean;

public class ProcessNode {
    private Integer processNodeId;

    private Integer processNo;

    private String processNodeName;

    private String processNodeRole;

    private String remark;

    public Integer getProcessNodeId() {
        return processNodeId;
    }

    public void setProcessNodeId(Integer processNodeId) {
        this.processNodeId = processNodeId;
    }

    public Integer getProcessNo() {
        return processNo;
    }

    public void setProcessNo(Integer processNo) {
        this.processNo = processNo;
    }

    public String getProcessNodeName() {
        return processNodeName;
    }

    public void setProcessNodeName(String processNodeName) {
        this.processNodeName = processNodeName == null ? null : processNodeName.trim();
    }

    public String getProcessNodeRole() {
        return processNodeRole;
    }

    public void setProcessNodeRole(String processNodeRole) {
        this.processNodeRole = processNodeRole == null ? null : processNodeRole.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}