package com.ssafy.model.dto;

import java.util.Objects;

/**
 * @author 김영빈
 */
public class Member implements Comparable<Member> {
	private String memberId;
	private String memberPw;
	private String name;
	private String mobile;
	private String email;
	private String entryDate;
	private char grade;
	
	public Member() {};
	
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			char grade) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.entryDate = entryDate;
		this.grade = grade;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return memberPw;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.memberPw = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public char getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%9s | ", memberId));
		sb.append(String.format("%9s | ", memberPw));
		sb.append(String.format("%6s | ", name));
		sb.append(String.format("%12s | ", mobile));
		sb.append(String.format("%20s | ", email));
		sb.append(String.format("%11s | ", entryDate));
		sb.append(String.format("%3c | ", grade));
		
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, entryDate, grade, memberId, mobile, name, memberPw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return this.memberId.equals(other.getMemberId());
	}

	@Override
	public int compareTo(Member m) {
		String name1 = this.name;
		String name2 = m.getName();
		
		return name1.compareTo(name2);
	}
	
}