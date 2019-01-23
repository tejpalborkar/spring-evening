package com.xcaliber.foodstall.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcaliber.foodstall.auth.service.UserUtil;
import com.xcaliber.foodstall.dao.CartDao;
import com.xcaliber.foodstall.model.Cart;
import com.xcaliber.foodstall.model.Item;
import com.xcaliber.foodstall.model.User;

@Transactional
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartRespository;

	@Autowired
	private UserUtil userUtil;

	@Override
	public Cart createCart(Cart cart) {
		cartRespository.create(cart);
		return cart;
	}

	@Transactional
	@Override
	public Cart addItemsToCart(List<Item> items) {

		User user = userUtil.getLoggedInUser();
		Cart cart = cartRespository.findCartByUserId(user.getUserId());

		if (cart == null) {
			cart = new Cart();
			cart.setUserId(user.getUserId());
			cart.setItems(new HashSet(items));
			cart.setIsCheckedout(false);
			cartRespository.create(cart);
			/*
			 * cart.setItems(items); cartRespository.update(cart);
			 */

		} else {
			Set<Item> oldItems = cart.getItems();
			if (oldItems.isEmpty()) {
				cart.getItems().addAll(items);
			} else {
				oldItems.addAll(items);
			}
			cartRespository.update(cart);
		}

		return cart;
	}

	@Override
	public Cart getCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return cartRespository.findCartByUserId(userId);
	}

	@Override
	public Cart findCart(Integer cartId) {
		// TODO Auto-generated method stub
		return cartRespository.findOne(cartId);
	}

	@Override
	public void checkoutCart(Cart cart) {
		cart.setIsCheckedout(true);
		cartRespository.update(cart);
		
	}

}
