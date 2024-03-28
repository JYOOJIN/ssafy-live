package com.ssafy.model.dto;

public class AdminMember extends Member {
	private String position;

	public AdminMember() {
		super();
	}

	public AdminMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			char grade, String position) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.position = position;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append(String.format("%6s", position));
		
		return sb.toString();
	}
}
