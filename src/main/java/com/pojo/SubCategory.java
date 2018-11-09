package com.pojo;

public class SubCategory {
	private Long id;
	private Long parentCategoryId;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubCategory(Long id, Long parentCategoryId, String description) {
		super();
		this.id = id;
		this.parentCategoryId = parentCategoryId;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Subcategory [id=" + id + ", ParentCategoryId="
				+ parentCategoryId + ", description=" + description + "]";
	}
}
