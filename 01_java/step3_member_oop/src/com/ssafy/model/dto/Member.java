package com.ssafy.model.dto;

import java.net.FileNameMap;
import java.util.Objects;

/**
 * <pre>
 * 회원 도메인 클래스
 * </pre>
 * @author 김영빈
 */
public class Member {
	/** 회원 아이디 식별키(중복불가, 생략불가: PK) */
	private String memberId;
	/** 회원 비밀번호 : 필수, 사용자 입력 */
	private String memberPw;
	/** 이름 : 필수, 사용자 입력 */
	private String name;
	/** 핸드폰 번호 : 필수, 사용자 입력 */
	private String mobile;
	/** 이메일 : 필수, 사용자 입력 */
	private String email;
	/** 가입 날짜 : 필수, 시스템 제공 */
	private String entryDate;
	/** 등급 : 필수, 시스템 제공 */
	private char grade;
	
	public Member() {
		
	}

	/**
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 */
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
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
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

	// 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(memberPw);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(mobile);
		builder.append(", ");
		builder.append(email);
		builder.append(", ");
		builder.append(entryDate);
		builder.append(", ");
		builder.append(grade);
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, entryDate, grade, memberId, memberPw, mobile, name);
	}

	// 1. 자기자신과 비교하는지
	// 2. null이 들어온 건 아닌지
	// 3. 비교하는 대상과 같은 클래스가 맞는지
	// 3가지를 먼저 비교한 다음 모두 만족한다면 멤버변수 값이 모두 일치하는지 검사함
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(email, other.email) && Objects.equals(entryDate, other.entryDate) && grade == other.grade
				&& Objects.equals(memberId, other.memberId) && Objects.equals(memberPw, other.memberPw)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name);
	}	
}
