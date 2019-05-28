package com.oa.bean;

import java.util.Date;

public class WorkTime {
    private Integer id;

    private Date attendMorStartTime;

    private Date attendMorEndTime;

    private Date workMorStartTime;

    private Date workMorEndTime;

    private Date attendMorLeaveStartTime;

    private Date attendMorLeaveEndTime;

    private Date attendAfternoonStartTime;

    private Date attendAfternoonEndTime;

    private Date workStartTimeAfternoon;

    private Date workEndTimeAfternoon;

    private Date attendAfterLeaveStartTime;

    private Date attendAfterLeaveEndTime;

    private Date createTime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAttendMorStartTime() {
        return attendMorStartTime;
    }

    public void setAttendMorStartTime(Date attendMorStartTime) {
        this.attendMorStartTime = attendMorStartTime;
    }

    public Date getAttendMorEndTime() {
        return attendMorEndTime;
    }

    public void setAttendMorEndTime(Date attendMorEndTime) {
        this.attendMorEndTime = attendMorEndTime;
    }

    public Date getWorkMorStartTime() {
        return workMorStartTime;
    }

    public void setWorkMorStartTime(Date workMorStartTime) {
        this.workMorStartTime = workMorStartTime;
    }

    public Date getWorkMorEndTime() {
        return workMorEndTime;
    }

    public void setWorkMorEndTime(Date workMorEndTime) {
        this.workMorEndTime = workMorEndTime;
    }

    public Date getAttendMorLeaveStartTime() {
        return attendMorLeaveStartTime;
    }

    public void setAttendMorLeaveStartTime(Date attendMorLeaveStartTime) {
        this.attendMorLeaveStartTime = attendMorLeaveStartTime;
    }

    public Date getAttendMorLeaveEndTime() {
        return attendMorLeaveEndTime;
    }

    public void setAttendMorLeaveEndTime(Date attendMorLeaveEndTime) {
        this.attendMorLeaveEndTime = attendMorLeaveEndTime;
    }

    public Date getAttendAfternoonStartTime() {
        return attendAfternoonStartTime;
    }

    public void setAttendAfternoonStartTime(Date attendAfternoonStartTime) {
        this.attendAfternoonStartTime = attendAfternoonStartTime;
    }

    public Date getAttendAfternoonEndTime() {
        return attendAfternoonEndTime;
    }

    public void setAttendAfternoonEndTime(Date attendAfternoonEndTime) {
        this.attendAfternoonEndTime = attendAfternoonEndTime;
    }

    public Date getWorkStartTimeAfternoon() {
        return workStartTimeAfternoon;
    }

    public void setWorkStartTimeAfternoon(Date workStartTimeAfternoon) {
        this.workStartTimeAfternoon = workStartTimeAfternoon;
    }

    public Date getWorkEndTimeAfternoon() {
        return workEndTimeAfternoon;
    }

    public void setWorkEndTimeAfternoon(Date workEndTimeAfternoon) {
        this.workEndTimeAfternoon = workEndTimeAfternoon;
    }

    public Date getAttendAfterLeaveStartTime() {
        return attendAfterLeaveStartTime;
    }

    public void setAttendAfterLeaveStartTime(Date attendAfterLeaveStartTime) {
        this.attendAfterLeaveStartTime = attendAfterLeaveStartTime;
    }

    public Date getAttendAfterLeaveEndTime() {
        return attendAfterLeaveEndTime;
    }

    public void setAttendAfterLeaveEndTime(Date attendAfterLeaveEndTime) {
        this.attendAfterLeaveEndTime = attendAfterLeaveEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}