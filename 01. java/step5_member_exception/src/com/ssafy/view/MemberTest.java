package com.ssafy.view;

import java.util.ArrayList;

import com.ssafy.exception.DuplicateException;
import com.ssafy.exception.RecordNotFoundException;
import com.ssafy.model.dto.Member;
import com.ssafy.model.service.MemberManager;

public class MemberTest {
	public static void main(String[] args) throws Exception {
		MemberManager mngr = MemberManager.getInstance();
		try {
			mngr.getMember();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Member m1 = new Member("01", "홍", 15);
		Member m2 = new Member("21", "김", 19);
		Member m3 = new Member("01", "이", 25);
		Member m4 = new Member("11", "이", 25);
		try {
			mngr.addMember(m1);
			mngr.addMember(m2);
			mngr.addMember(m3);
			mngr.addMember(m4);
		}catch(DuplicateException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
//		
//		try {
//			mngr.addMember(m1);
//		}catch(DuplicateException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			mngr.addMember(m2);
//		}catch(DuplicateException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			mngr.addMember(m3);
//		}catch(DuplicateException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		ArrayList<Member> list = mngr.getMember();
		for(Member m: list) {
			System.out.println(m);
		}
		
		try {
			Member dto = mngr.getMember("33");
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printMemberList() {
		
	}
}
