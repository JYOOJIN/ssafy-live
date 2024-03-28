package com.ssafy.view;	// 1. package 선언문

import com.ssafy.model.dto.Member;	// 2. import 선언문
//import com.ssafy.model.dto.*;	// 권장 X
public class MemberTest {	// 3

	public static void main(String[] args) {
		Member dto2 = new Member("user01", "password01", "홍길동", "01012341000","user01@ssafy.com");

		System.out.println("[변경전] "+dto2);
		// Encapsulation : 데이터는 멤버변수를 통해서 직접 접근 불가 (다른클래스에서는 접근 권한 없음)
		// public setter() / getter() 메서드를 통해서 데이터 접근 가능
		// 이름 변경 : 본인의 이름으로 변경해보세요
		dto2.setName("이지영");
		// 비밀번호 : 올바르게 변경 / 올바르지 않게 변경해 보세요
		dto2.setMemberPw("happyday2024");
		dto2.setMemberPw("happy");
		
		//데이터 변경후 전체정보 출력
		System.out.println("[변경후] "+dto2);
	}
	
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		//멤버 패키지가 달라서 에러가 뜸
		Member dto1 = new Member();
		System.out.println();
		// 필수데이터(사용자 입력데이터) 초기화 생성자 이용한 객체 생성
		Member dto2 = new Member("user01", "password01", "홍길동", "01012341000","user01@ssafy.com");
	
		System.out.println(dto2);
		
		// 문제발생 : 회원의 정보를 마음데로 변경되는 문제!!
		// => 해결 : Encapsulation을 통해 접근제한
		// public-> private로 변경시 접근 불가 -> 에러
//		dto2.memberId = "hello";
//		dto2.memberPw="1234";
//		dto2.name = "바보바보바보";
		System.out.println(dto2);
	}

}
