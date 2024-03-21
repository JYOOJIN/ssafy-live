package com.ssafy.model.dto;

import java.net.FileNameMap;

/**
 * <pre>
 * 회원 도메인 클래스
 * </pre>
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
	/** 마일리지 : 선택, 시스템 제공 : 일반회원 관련된 속성 */
	private int mileage;
	/** 담당자 : 선택, 시스템 제공 : 우수회원 관련된 속성 */
	private String manager;
	
	public Member() {
		System.out.println("[객체생성시공통기능]광주5반은 보석입니다!!!!");
	}
	
	
	
	
	
	/**
	 * 회원가입시에 사용자 입력정보를 기반으로 초기화 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this(); //현재 객체의 기본생성자
		//super();	
		// 부모의 기본 생성자 수행, 생략가능, 자식의 생성자에서 명시적으로 부모의 생성자를 지정하지않으면 자동으로 super()가 작성됨.
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		System.out.println("필수데이터 초기화 생성자 수행");
	}

	//회원의 모든데이터를 초기화 생성자를 중복 정의
	/**
	 * 회원이 모든 데이터를 초기화 해주는 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 * @param manager
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			char grade, int mileage, String manager) {
		//super();
//		this.memberId = memberId;
//		this.memberPw = memberPw;
//		this.name = name;
//		this.mobile = mobile;
//		this.email = email;
		
		//현재 객체의 다른 생성자를 호출 수행
		// 해당 생성자의 첫번째 수행문으로 위치해야함!!!
		this(memberId,memberPw, name, mobile,email);
		
		this.entryDate = entryDate;
		this.grade = grade;
		this.mileage = mileage;
		this.manager = manager;
		System.out.println("전체데이터 초기화 생성자 수행");
	}
	
	//일반회원의 정보를 기반으로 초기화 생성자
	/**
	 * 일반회원의 데이터를 초기화 해주는 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			char grade, int mileage) {
//		super();
//		this.memberId = memberId;
//		this.memberPw = memberPw;
//		this.name = name;
//		this.mobile = mobile;
//		this.email = email;
		this(memberId,memberPw, name, mobile,email);
		
		this.entryDate = entryDate;
		this.grade = grade;
		this.mileage = mileage;
		System.out.println("일반회원데이터 초기화 생성자 수행");
		
		// this()는 맨 첫줄에 위치해야함.
		//this(memberId,memberPw, name, mobile,email);
	}
	
	
	/**
	 * 우수회원의 데이터를 초기화 해주는 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param manager
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			char grade, String manager) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.entryDate = entryDate;
		this.grade = grade;
		this.manager = manager;
		System.out.println("우수회원데이터 초기화 생성자 수행");
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
		if(isMemberPw(memberPw)) {
			this.memberPw = memberPw;	//검증받은 데이터에 대해서 변경 처리
			return;	// 반환타입이 void 이어도 개발자가 호출측으로 제어권을 임의로 넘겨줄 수 있음.
		}
		System.out.println("[오류] 데이터를 올바르게 입력하세요 : 비밀번호는 6~20 이내입니다.");
	}


	/**
	 * /비밀번호 검증 규칙 : 필수, 6~20자리 이내	
	 * @param memberPw
	 * @return 검증규칙 올바르면 true, 그렇지 않으면 false
	 * @see java.lang.String#length()
	 */
	private boolean isMemberPw(String memberPw) {
		if(memberPw.length()>=6 && memberPw.length()<=20) {
			return true;
		}
		return false;
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
		builder.append(", ");
		builder.append(mileage);
		builder.append(", ");
		builder.append(manager);
		return builder.toString();
	}


}
