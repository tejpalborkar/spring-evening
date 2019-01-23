package com.xcaliber.foodstall.service;

import java.util.List;

import com.xcaliber.foodstall.model.Item;

public interface ItemService {
	
	List<Item> findByCategoryName(String name);

	Item findById(Integer itemId);
	
	
}
