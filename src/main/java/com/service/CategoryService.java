/**
 * 
 */
package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pojo.Category;

/**
 * @author Shraddha
 *
 */
@Service
public class CategoryService {
	static List<Category> list = new ArrayList<Category>();

	static {
		list.add(new Category(1L, "Grocery"));
		list.add(new Category(1L, "Investment"));
	}

	public List<Category> getAllCategories() {
		return list;
	}

	public void addCategory(String description) {
		Category category = new Category(list.size() + 1L, description);
		list.add(category);
	}

	public void updateCategory(Long id, String description) {
		for (Category category : list) {
			if (category.getId().equals(id)) {
				category.setDescription(description);
				break;
			}
		}
	}

	public void deleteCategory(Long id) {
		Category category = null;
		for (int i = 0; i < list.size(); i++) {
			category = list.get(i);
			if (category.getId().equals(id)) {
				break;
			} else {
				category = null;
			}
		}
		list.remove(category);
	}

	public Category getCategory(Long id) {
		for (Category category : list) {
			if (category.getId().equals(id)) {
				return category;
			}
		}
		return null;
	}
}
