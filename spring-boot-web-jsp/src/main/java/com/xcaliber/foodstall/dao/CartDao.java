package com.xcaliber.foodstall.dao;

import com.xcaliber.foodstall.model.Cart;

public interface CartDao {

	Cart findCartByUserId(Integer userId);

	Cart findCartByCartId(Integer CartId);

	void create(Cart cart);

	void update(Cart cart);

	Cart findOne(Integer cartId);

	void merge(Cart cart);
}
