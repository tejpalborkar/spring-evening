package com.xcaliber.foodstall.dao;

import java.util.List;

import com.xcaliber.foodstall.model.Category;

public interface CategoryDao {

	List<Category> getAll();

	Category findByName(String name);
}
