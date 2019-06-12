package com.oa.bean;

public class Process {
    private Integer processId;

    private String processNo;

    private String processName;

    private String remark;
    
    public Process() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public Process(String processNo, String processName, String remark) {
		super();
		this.processNo = processNo;
		this.processName = processName;
		this.remark = remark;
	}



	public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo == null ? null : processNo.trim();
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}