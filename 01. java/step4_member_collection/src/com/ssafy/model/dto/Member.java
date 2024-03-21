package com.ssafy.model.dto;

import java.util.Objects;

/**
 * @author 김영빈
 */
public class Member {
	private String memberId;
	private String name;
	private int age;
	
	// 기본 생성자
	Member(){};
	
	// 모든 멤버변수 초기화하는 생성자
	Member(String memberId, String name, int age){
		this.memberId = memberId;
		this.name = name;
		this.age = age;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, memberId, name);
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
		return age == other.age && memberId == other.memberId && Objects.equals(name, other.name);
	}
}
