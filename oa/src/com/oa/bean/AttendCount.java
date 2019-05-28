package com.oa.bean;

import java.util.Date;

public class AttendCount {
    private Integer id;

    private String userId;

    private Integer deptId;

    private Integer absenceCount;

    private String dateYear;

    private String dateMoth;

    private Integer leaveTimeLength;

    private Integer lateTimeLength;

    private Integer lateCount;

    private Date createTime;

    private Integer status;

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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getAbsenceCount() {
        return absenceCount;
    }

    public void setAbsenceCount(Integer absenceCount) {
        this.absenceCount = absenceCount;
    }

    public String getDateYear() {
        return dateYear;
    }

    public void setDateYear(String dateYear) {
        this.dateYear = dateYear == null ? null : dateYear.trim();
    }

    public String getDateMoth() {
        return dateMoth;
    }

    public void setDateMoth(String dateMoth) {
        this.dateMoth = dateMoth == null ? null : dateMoth.trim();
    }

    public Integer getLeaveTimeLength() {
        return leaveTimeLength;
    }

    public void setLeaveTimeLength(Integer leaveTimeLength) {
        this.leaveTimeLength = leaveTimeLength;
    }

    public Integer getLateTimeLength() {
        return lateTimeLength;
    }

    public void setLateTimeLength(Integer lateTimeLength) {
        this.lateTimeLength = lateTimeLength;
    }

    public Integer getLateCount() {
        return lateCount;
    }

    public void setLateCount(Integer lateCount) {
        this.lateCount = lateCount;
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