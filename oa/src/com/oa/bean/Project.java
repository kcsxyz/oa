package com.oa.bean;

import java.util.Date;
import java.util.List;

public class Project {
    private Integer projectId;

    private String projectName;

    private String createName;

    private Date createTime;
    
    private List<Files> files;

	public List<Files> getFiles() {
	return files;
}

	public void setFiles(List<Files> files) {
	this.files = files;
}

	public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", createName=" + createName
				+ ", createTime=" + createTime + ", files=" + files + "]";
	}



}