package com.ssafy.ws05.step3;

import com.ssafy.ws05.step3.Book;

public class BookTest {

	public static void main(String[] args) {
		// 테스트를 위한 도서 객체
		Book book1 = new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법");
		Book book2 = new Book("21425","Java Pro2","김하나","jaen.kr",25000,"Java 응용");
		Book book3 = new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");
		
		// 도서 관리기능을 위한 도서관리 객체 생성
		BookManager mngr = new BookManager();
		
		//도서 등록
		mngr.add(book1);
		mngr.add(book2);
		mngr.add(book3);
		
		
		//도서 전체 조회
		System.out.println("**********************도서목록***********************");
		for(int i = 0; i<mngr.getList().length; i++) {
			System.out.println(mngr.getList()[i].toString());
		}
		
		//도서 상세 조회
		String isbn = "21424";
		Book book4 = mngr.searchByisbn(isbn);
		System.out.println("**********************도서조회:"+isbn+"***********************");
		System.out.println(book4);
		
		//도서 삭제
		System.out.println("**********************도서삭제:"+isbn+"***********************");
		mngr.remove(isbn);
		
		//도서 목록
		System.out.println("**********************도서목록***********************");
		for(int i = 0; i<mngr.getList().length; i++) {
			System.out.println(mngr.getList()[i].toString());
		}
	}

}
