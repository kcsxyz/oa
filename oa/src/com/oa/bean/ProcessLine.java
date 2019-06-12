package com.oa.bean;

public class ProcessLine {
    private Integer processLineId;

    private String processNo;

    private Integer preNodeId;

    private Integer nextNodeId;

    private String remark;

    
    public ProcessLine() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public ProcessLine(String processNo, Integer preNodeId, Integer nextNodeId, String remark) {
		super();
		this.processNo = processNo;
		this.preNodeId = preNodeId;
		this.nextNodeId = nextNodeId;
		this.remark = remark;
	}


	public Integer getProcessLineId() {
        return processLineId;
    }

    public void setProcessLineId(Integer processLineId) {
        this.processLineId = processLineId;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo == null ? null : processNo.trim();
    }

    public Integer getPreNodeId() {
        return preNodeId;
    }

    public void setPreNodeId(Integer preNodeId) {
        this.preNodeId = preNodeId;
    }

    public Integer getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(Integer nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}