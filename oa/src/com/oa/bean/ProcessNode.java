package com.oa.bean;

public class ProcessNode {
    private Integer processNodeId;

    private String processNo;

    private String processNodeName;

    private String processNodeRole;

    private String remark;
    
    
    public ProcessNode() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	public ProcessNode(String processNo, String processNodeName, String processNodeRole, String remark) {
		super();
		this.processNo = processNo;
		this.processNodeName = processNodeName;
		this.processNodeRole = processNodeRole;
		this.remark = remark;
	}


	public Integer getProcessNodeId() {
        return processNodeId;
    }

    public void setProcessNodeId(Integer processNodeId) {
        this.processNodeId = processNodeId;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo == null ? null : processNo.trim();
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