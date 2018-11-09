package com.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	public User() {
		super();
	}

	public User(Long id, String firstName, String lastName, String userName, String emailId, String password,
			String securityQuestion, String securityAnswer, Date createDate, Date lastUpdateDate, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.createDate = createDate;
		this.lastUpdateDate = lastUpdateDate;
		this.status = status;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1736733181752845673L;
	private Long id;

	private String firstName;
	private String lastName;
	private String userName;
	private String emailId;
	private String password;
	private String securityQuestion;
	private String securityAnswer;
	private Date createDate;
	private Date lastUpdateDate;
	private String status = "ACTIVE";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User(Long id, String userName, String password, Date createDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", emailId=" + emailId + ", password=" + password + ", securityQuestion=" + securityQuestion
				+ ", securityAnswer=" + securityAnswer + ", createDate=" + createDate + ", lastUpdateDate="
				+ lastUpdateDate + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void copyFrom(User u) {
		this.setFirstName(u.getFirstName());
		this.setLastName(u.getLastName());
		this.setUserName(u.getUserName());
		this.setEmailId(u.getEmailId());
		this.setSecurityQuestion(u.getSecurityQuestion());
		this.setSecurityAnswer(u.getSecurityAnswer());
		this.setLastUpdateDate(u.getLastUpdateDate());
		this.setStatus(u.getStatus());
	}
}
