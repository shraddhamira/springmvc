package com.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Expense {

	private Long id;
	private String description;
	private Date createDate;
	private Long userId;
	private Float amount;
	private Long subCategoryId;

	public Expense(Long id, String description, Date createDate, Long userId,
			Long subCategoryId, Float amount) {
		super();
		this.id = id;
		this.description = description;
		this.createDate = createDate;
		this.userId = userId;
		this.subCategoryId = subCategoryId;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the amount
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	/**
	 * @return the subCategoryId
	 */
	public Long getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId
	 *            the subCategoryId to set
	 */
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Expense other = (Expense) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", description=" + description
				+ ", createDate=" + createDate + ", userId=" + userId
				+ ", amount=" + amount + ", subCategoryId=" + subCategoryId
				+ "]";
	}
}
