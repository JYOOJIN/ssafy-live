package com.ssafy.view;	// 1. package 선언문

import com.ssafy.model.dto.Member;	// 2. import 선언문
import com.ssafy.model.dto.GeneralMember;
import com.ssafy.model.dto.SpecialMember;
//import com.ssafy.model.dto.*;	// 권장 X
public class MemberTest {	// 3

	public static void main(String[] args) {
		Member m1 = new Member();
		m1.setMemberId("user01");
		System.out.println(m1);
		
		GeneralMember g1 = new GeneralMember();
		g1.setMemberId("user02");
		System.out.println(g1);
		
		SpecialMember s1 = new SpecialMember();
		s1.setMemberId("user03");
		System.out.println(s1);
	}
}
