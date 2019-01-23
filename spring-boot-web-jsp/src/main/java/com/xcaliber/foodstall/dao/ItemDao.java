package com.xcaliber.foodstall.dao;

import java.util.List;

import com.xcaliber.foodstall.model.Item;
import com.xcaliber.foodstall.repository.GenericDao;

public interface ItemDao {

	List<Item> findByCategoryId(int categoryId);

	Item findById(Integer itemId);
}
