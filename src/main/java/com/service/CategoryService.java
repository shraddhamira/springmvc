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
		list.add(new Category(1L, "Grocery",1001L));
		list.add(new Category(1L, "Investment",1002L));
	}

	public List<Category> getAllCategories(Long userId) {
		List<Category> list = new ArrayList<Category>();
		for (Category category : this.list) {
			if(category.getUserId().equals(userId))
				list.add(category);
		}
		return list;
	}

	public void addCategory(String description, Long userId) {
		Category category = new Category(list.size() + 1L, description, userId);
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
