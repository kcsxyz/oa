package com.oa.bean;

import java.util.Date;

public class WorkLog {
    private Integer logId;

    private String title;

    private String content;

    private Date createTime;

    private String createName;

    private Date modifiedTime;

    private String modifiedName;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName == null ? null : modifiedName.trim();
    }

	@Override
	public String toString() {
		return "WorkLog [logId=" + logId + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", createName=" + createName + ", modifiedTime=" + modifiedTime + ", modifiedName=" + modifiedName
				+ "]";
	}
   
}