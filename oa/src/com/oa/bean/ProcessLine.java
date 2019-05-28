package com.oa.bean;

public class ProcessLine {
    private Integer processLineId;

    private Integer processNo;

    private Integer preNodeId;

    private Integer nextNodeId;

    private String remark;

    public Integer getProcessLineId() {
        return processLineId;
    }

    public void setProcessLineId(Integer processLineId) {
        this.processLineId = processLineId;
    }

    public Integer getProcessNo() {
        return processNo;
    }

    public void setProcessNo(Integer processNo) {
        this.processNo = processNo;
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