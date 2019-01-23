package com.xcaliber.foodstall.model;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="snacks")
public class Snack {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	@Column(name = "snacks_id")
	private int snacksId;
	
	@Column(name="pasta")
	private String pasta;
	
	@Column(name="poha")
	private String poha;
	
	public Snack() {
		
	}

	public Snack(int snacksId, String pasta, String poha) {
		super();
		this.snacksId = snacksId;
		this.pasta = pasta;
		this.poha = poha;
	}

	@Override
	public String toString() {
		return "Snack [snacksId=" + snacksId + ", pasta=" + pasta + ", poha=" + poha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pasta == null) ? 0 : pasta.hashCode());
		result = prime * result + ((poha == null) ? 0 : poha.hashCode());
		result = prime * result + snacksId;
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
		Snack other = (Snack) obj;
		if (pasta == null) {
			if (other.pasta != null)
				return false;
		} else if (!pasta.equals(other.pasta))
			return false;
		if (poha == null) {
			if (other.poha != null)
				return false;
		} else if (!poha.equals(other.poha))
			return false;
		if (snacksId != other.snacksId)
			return false;
		return true;
	}

	public int getSnacksId() {
		return snacksId;
	}

	public void setSnacksId(int snacksId) {
		this.snacksId = snacksId;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}

	public String getPoha() {
		return poha;
	}

	public void setPoha(String poha) {
		this.poha = poha;
	}
	
	
}
