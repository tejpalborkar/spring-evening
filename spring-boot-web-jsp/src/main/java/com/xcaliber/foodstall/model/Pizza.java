package com.xcaliber.foodstall.model;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="pizza")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	@Column(name = "pizza_id")
	private int pizzaId;
	
	@Column(name="cheese_pizza")
	private String cheesePizza;
	
	@Column(name="veg_pizza")
	private String vegPizza;
	
	public Pizza() {
		
	}

	public Pizza(int pizzaId, String cheesePizza, String vegPizza) {
		super();
		this.pizzaId = pizzaId;
		this.cheesePizza = cheesePizza;
		this.vegPizza = vegPizza;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", cheesePizza=" + cheesePizza + ", vegPizza=" + vegPizza + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cheesePizza == null) ? 0 : cheesePizza.hashCode());
		result = prime * result + pizzaId;
		result = prime * result + ((vegPizza == null) ? 0 : vegPizza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (cheesePizza == null) {
			if (other.cheesePizza != null)
				return false;
		} else if (!cheesePizza.equals(other.cheesePizza))
			return false;
		if (pizzaId != other.pizzaId)
			return false;
		if (vegPizza == null) {
			if (other.vegPizza != null)
				return false;
		} else if (!vegPizza.equals(other.vegPizza))
			return false;
		return true;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getCheesePizza() {
		return cheesePizza;
	}

	public void setCheesePizza(String cheesePizza) {
		this.cheesePizza = cheesePizza;
	}

	public String getVegPizza() {
		return vegPizza;
	}

	public void setVegPizza(String vegPizza) {
		this.vegPizza = vegPizza;
	}

}
