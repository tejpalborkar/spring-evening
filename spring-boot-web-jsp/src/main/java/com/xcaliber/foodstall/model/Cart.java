package com.xcaliber.foodstall.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "user_id")
	private int userId;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinTable(
	            name = "cart_item",
	            joinColumns = @JoinColumn(name = "cart_id"),
	            inverseJoinColumns = @JoinColumn(name = "item_id"))
//	@OneToMany(cascade = { CascadeType.ALL })
//	@JoinColumn(name = "cart_id")
	private Set<Item> items;

	@Column(name = "is_checkedout")
	private Boolean isCheckedout;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Boolean getIsCheckedout() {
		return isCheckedout;
	}

	public void setIsCheckedout(Boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}

}
