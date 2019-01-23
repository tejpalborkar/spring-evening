package com.xcaliber.foodstall.model;

public class Menu {

	private String orderItem;

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "Menu [orderItem=" + orderItem + "]";
	}

}
