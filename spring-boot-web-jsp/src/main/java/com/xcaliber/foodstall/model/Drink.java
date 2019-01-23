package com.xcaliber.foodstall.model;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="drinks")
public class Drink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	@Column(name = "drinks_id")
	private int snacksId;
	
	@Column(name="coke")
	private String coke;
	
	@Column(name="sprite")
	private String sprite;
	
	public Drink() {
		
	}

	public Drink(int snacksId, String coke, String sprite) {
		super();
		this.snacksId = snacksId;
		this.coke = coke;
		this.sprite = sprite;
	}

	@Override
	public String toString() {
		return "Drink [snacksId=" + snacksId + ", coke=" + coke + ", sprite=" + sprite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coke == null) ? 0 : coke.hashCode());
		result = prime * result + snacksId;
		result = prime * result + ((sprite == null) ? 0 : sprite.hashCode());
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
		Drink other = (Drink) obj;
		if (coke == null) {
			if (other.coke != null)
				return false;
		} else if (!coke.equals(other.coke))
			return false;
		if (snacksId != other.snacksId)
			return false;
		if (sprite == null) {
			if (other.sprite != null)
				return false;
		} else if (!sprite.equals(other.sprite))
			return false;
		return true;
	}

	public int getSnacksId() {
		return snacksId;
	}

	public void setSnacksId(int snacksId) {
		this.snacksId = snacksId;
	}

	public String getCoke() {
		return coke;
	}

	public void setCoke(String coke) {
		this.coke = coke;
	}

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}
	
}
