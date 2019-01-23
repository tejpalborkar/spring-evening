package com.xcaliber.foodstall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcaliber.foodstall.dao.CategoryDao;
import com.xcaliber.foodstall.dao.ItemDao;
import com.xcaliber.foodstall.model.Category;
import com.xcaliber.foodstall.model.Item;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao itemRespository;
	
	@Autowired
	private CategoryDao categoryRespository;
	

	@Override
	public List<Item> findByCategoryName(String name) {
		
		Category category = categoryRespository.findByName(name);
		List<Item> items = itemRespository.findByCategoryId(category.getCategoryId());
		return items;
	}


	@Override
	public Item findById(Integer itemId) {
		// TODO Auto-generated method stub
		return itemRespository.findById(itemId);
	}

	
	

}
