package com.oa.bean;

import java.util.Date;

public class Attend {
    private Integer attendId;

    private String userId;

    private Integer deptId;

    private Date currDate;

    private String week;

    private Date attendMorStart;

    private Date attendMorLeave;

    private Date attendNoonStart;

    private Date attendNoonLeave;

    private Integer status;

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
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

    public Date getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Date getAttendMorStart() {
        return attendMorStart;
    }

    public void setAttendMorStart(Date attendMorStart) {
        this.attendMorStart = attendMorStart;
    }

    public Date getAttendMorLeave() {
        return attendMorLeave;
    }

    public void setAttendMorLeave(Date attendMorLeave) {
        this.attendMorLeave = attendMorLeave;
    }

    public Date getAttendNoonStart() {
        return attendNoonStart;
    }

    public void setAttendNoonStart(Date attendNoonStart) {
        this.attendNoonStart = attendNoonStart;
    }

    public Date getAttendNoonLeave() {
        return attendNoonLeave;
    }

    public void setAttendNoonLeave(Date attendNoonLeave) {
        this.attendNoonLeave = attendNoonLeave;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}