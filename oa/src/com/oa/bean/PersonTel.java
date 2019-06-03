package com.oa.bean;

public class PersonTel {
    private Integer telId;

    private String userId;

    private String personId;
    
    private User user;

   

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

	@Override
	public String toString() {
		return "PersonTel [telId=" + telId + ", userId=" + userId + ", personId=" + personId + "]";
	}
    
}