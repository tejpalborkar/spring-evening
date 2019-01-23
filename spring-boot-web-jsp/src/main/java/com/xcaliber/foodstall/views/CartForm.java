package com.xcaliber.foodstall.views;

import java.util.List;

public class CartForm {
	
	List<Integer> items;

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CartForm [items=" + items + "]";
	}
	
	

}
