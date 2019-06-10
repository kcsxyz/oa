package com.oa.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Leave {
    private Integer id;

    private String userId;

    private String userName;

    private String leaveType;

    private String leaveReason;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd") //yyyy-MM-dd:HH:mm:ss
    private Date endTime;

    private Date createTime;

    private String processNo;

    private Integer currentNo;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo == null ? null : processNo.trim();
    }

    public Integer getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(Integer currentNo) {
        this.currentNo = currentNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}