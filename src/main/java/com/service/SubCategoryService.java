package com.service;

import java.util.ArrayList;
import java.util.List;

import com.pojo.SubCategory;

public class SubCategoryService {
	static List<SubCategory> list = new ArrayList<SubCategory>();

	static {
		list.add(new SubCategory(1L, 2L,"Mutual Funds"));
		list.add(new SubCategory(2L,2L, "RD"));
	}

	public List<SubCategory> getAllCategories() {
		return list;
	}

	public void addSubCategory(String description, Long parentCategoryId) {
		SubCategory SubCategory = new SubCategory(list.size() + 1L,parentCategoryId, description);
		list.add(SubCategory);
	}

	public void updateSubCategory(Long id, String description) {
		for (SubCategory SubCategory : list) {
			if (SubCategory.getId().equals(id)) {
				SubCategory.setDescription(description);
				break;
			}
		}
	}

	public void deleteSubCategory(Long id) {
		SubCategory SubCategory = null;
		for (int i = 0; i < list.size(); i++) {
			SubCategory = list.get(i);
			if (SubCategory.getId().equals(id)) {
				break;
			} else {
				SubCategory = null;
			}
		}
		list.remove(SubCategory);
	}

	public SubCategory getSubCategory(Long id) {
		for (SubCategory SubCategory : list) {
			if (SubCategory.getId().equals(id)) {
				return SubCategory;
			}
		}
		return null;
	}
}
