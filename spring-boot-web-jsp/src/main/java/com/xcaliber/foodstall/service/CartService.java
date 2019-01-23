package com.xcaliber.foodstall.service;

import java.util.List;

import com.xcaliber.foodstall.model.Cart;
import com.xcaliber.foodstall.model.Item;

public interface CartService {
	
	Cart createCart(Cart cart);
	
	Cart addItemsToCart(List<Item> items);
	
	Cart getCartByUserId(Integer userId);
	
	Cart findCart(Integer cartId);

	void checkoutCart(Cart cart);
}
