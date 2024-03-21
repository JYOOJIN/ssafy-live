package com.ssafy.ws04.step3;

/**
 * <pre>
 * 도서 도메인 클래스
 * </pre>
 * 
 * @author 이지영
 * @since jdk8
 * @version ver.1.0
 */
public class Book {
	//멤버변수 형식 : [modifiers] 타입 변수명 [= 명시적초기값];
	
	/** 도서번호 : 식별키 생략불가 */
	public String isbn;
	/** 도서명 : 생략 불가 */
	public String title;
	/** 저자명 : 명시적 초기화 홍길동 */
	public String author = "홍길동";
	/** 출판사 */
	public String publisher;
	/** 가격 */
	public int price;
	/** 도서설명 */
	public String desc;
	
	
	
	public Book() {
		//super();
		//System.out.println("Book() call...");
	}

//
//	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
//		super();
//		this.isbn = isbn;
//		this.title = title;
//		this.author = author;
//		this.publisher = publisher;
//		this.price = price;
//		this.desc = desc;
//		//System.out.println("Book(args) 전체데이터초기화 생성자 call...");
//	}



	@Override
	public String toString() {
		return isbn+"\t| " +title+"\t| "+ author+"\t| "+publisher+"\t| "+ price +"\t| "+ desc;
	}
	
	
	
	
}
