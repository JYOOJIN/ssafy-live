package com.ssafy.view;
import java.io.*;
import java.util.*;

import com.ssafy.model.service.MemberManager;

public class StartView {
	private MemberManager mm = MemberManager.getInstance();
	private Scanner in = new Scanner(System.in);
	
	public StartView() {
		//mm.initData();
		mm.loadData();
	}

	public void printTitle(String title) {
		System.out.println();
		System.out.println("=============================");
		System.out.println(title);
		System.out.println("=============================");
	}

	public void printLine() {
		System.out.println("=============================");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void mainMenu() {
//		System.out.println("=============================");
//		System.out.println("회원관리시스템 (ver.1.0)");
//		System.out.println("=============================");
//		System.out.println("1. 로그인");
//		System.out.println("2. 회원가입");
//		System.out.println("3. 아이디찾기");
//		System.out.println("4. 비밀번호찾기");
//		System.out.println("9. 프로그램종료");
//		System.out.println("=============================");

		printTitle("회원관리시스템 (ver.1.0)");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비밀번호찾기");
		System.out.println("9. 프로그램종료");
		printLine();

		System.out.print("메뉴번호: " );
		int menuNo = in.nextInt();
		switch(menuNo) {
		case 1:
			loginMenu();
			break;
		case 2:
			joinMenu();
			break;
		case 3:
			findIdMenu();
			break;
		case 4:
			findPwMenu();
			break;
		case 9:
			exitMenu();
			break;
		default :
			printMessage("Error: 올바르지 않은 메뉴번호입니다. 다시 입력하세요");
		}
	}

	public void serviceMainMenu(String memberId) {
		printTitle("회원관리시스템 (ver.1.0)");
		printMessage("[로그인] " + memberId + "님");
		System.out.println("1. 로그아웃");
		System.out.println("2. 내정보조회");
		System.out.println("3. 암호변경");
		System.out.println("4. 게시글조회");
		printLine();

		System.out.print("메뉴번호: " );
		int menuNo = in.nextInt();
		switch(menuNo) {
		case 1:
			logoutMenu();
			break;
		case 2:
			myInfoMenu();
			break;
		case 3:
			updatePwMenu();
			break;
		case 4:
			boardListMenu();
			break;
		default :
			printMessage("Error: 올바르지 않은 메뉴번호입니다. 다시 입력하세요");
		}
	}

	public void loginMenu() {
		printTitle("로그인");
		System.out.print("아이디 : ");
		String memberId = in.next();

		System.out.print("비밀번호 : ");
		String memberPw = in.next();

		printMessage(memberId + "님 회원전용 서비스를 이용하세요");
		serviceMainMenu(memberId);
	}	

	public void joinMenu() {
		printTitle("회원가입");
	}
	
	public void findIdMenu() {
		printTitle("아이디찾기");
	}	

	public void findPwMenu() {
		printTitle("비밀번호찾기");
	}	

	public void exitMenu() {
		printTitle("프로그램을 종료합니다.");
		mm.saveDataText();
		mm.saveData();
		System.exit(1);
	}	

	public void logoutMenu() {
		printTitle("로그아웃");
		mainMenu();
	}

	public void myInfoMenu() {
		printTitle("내정보조회");
	}

	public void updatePwMenu() {
		printTitle("암호변경");
	}

	public void boardListMenu() {
		printTitle("게시글조회");
	}
}