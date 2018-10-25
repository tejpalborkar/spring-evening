package com.assisimilate.spring.autowiring;

/**
 * @author tejpal.borkar
 *
 */
public class Engine {

	private String chasisNo;

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	@Override
	public String toString() {
		return "Engine [chasisNo=" + chasisNo + "]";
	}

	
	
}
