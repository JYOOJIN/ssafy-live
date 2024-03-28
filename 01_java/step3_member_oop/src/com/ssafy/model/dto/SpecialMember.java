package com.ssafy.model.dto;

/**
 * 
 */
public class SpecialMember extends Member {
	private String manager;
	private int discountRate;
	
	public SpecialMember() {
		
	}

	/**
	 * @return the discountRate
	 */
	public int getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate the discountRate to set
	 */
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		
		builder.append(", ");
		builder.append(manager);
		builder.append(", ");
		builder.append(discountRate);
		
		return builder.toString();
	}
}
