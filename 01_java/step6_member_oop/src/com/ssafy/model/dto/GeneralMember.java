package com.ssafy.model.dto;

public class GeneralMember extends Member {
	private int mileage;

	public GeneralMember() {
		super();
	}

	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			char grade, int mileage) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.mileage = mileage;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append(String.format("%7d", mileage));
		
		return sb.toString();
	}
	
	
}