package com.xcaliber.foodstall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcaliber.foodstall.dao.CategoryDao;
import com.xcaliber.foodstall.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryRespository;

	
	@Override
	public List<Category> findAll() {
		return categoryRespository.getAll();
	}

}
