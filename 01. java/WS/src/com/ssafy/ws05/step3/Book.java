package com.ssafy.ws05.step3;

import java.util.Objects;

/**
 * <pre>
 * 도서 도메인 클래스
 * </pre>
 * 
 * @author 김영빈 extends 이지영
 * @since jdk8
 * @version ver.1.0
 */
public class Book {
	//멤버변수 형식 : [modifiers] 타입 변수명 [= 명시적초기값];
	
	/** 도서번호 : 식별키 생략불가 */
	private String isbn;
	/** 도서명 : 생략 불가 */
	private String title;
	/** 저자명 : 명시적 초기화 홍길동 */
	private String author = "홍길동";
	/** 출판사 */
	private String publisher;
	/** 가격 */
	private int price;
	/** 도서설명 */
	private String desc;
	
	// 디폴트 생성자
	public Book() {
	}

	// 모든 멤버변수를 초기화하는 생성자
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	

	public Book(String isbn, String title) {		
		this.isbn = isbn;
		this.title = title;
	}
	
//	중복정의 규칙을 위반하였기에 에러	
//	public Book(String isbn, String author) {		
//		this.isbn = isbn;
//		this.author = author;
//	}

	/**
	 * @return the isbn
	 */
	// isbn의 getter
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	// isbn의 setter
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	// title의 getter
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	//title의 setter
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	// author의 getter
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	// author의 setter
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return the publisher
	 */
	// publisher의 getter
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%6s | ", isbn));
		builder.append(String.format("%10s | ", title));
		builder.append(String.format("%3s | ", author));
		builder.append(String.format("%6s | ", publisher));
		builder.append(String.format("%6d | ", price));
		builder.append(String.format("%6s | ", desc));
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}
	
//	@Override
//	public boolean equals(Object objs) {
//		boolean ret = false;
//		
//		if(objs != null && objs instanceof Book) {
//			Book curBook= (Book)objs;
//			if(this.isbn.equals(curBook.getIsbn())) {
//				ret = true;
//			}
//		}
//		
//		return ret;
//	}
	
	
}
