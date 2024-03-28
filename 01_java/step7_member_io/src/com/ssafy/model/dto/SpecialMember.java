package com.ssafy.model.dto;

public class SpecialMember extends Member {
	private String manager;
	private int discountRate;
	
	
	public SpecialMember() {
		super();
	}
	public SpecialMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			char grade, String manager, int discountRate) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.manager = manager;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append(String.format("%6s | ", manager));
		sb.append(String.format("%3d", discountRate));
		
		return sb.toString();
	}
}	
