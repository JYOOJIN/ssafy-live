package com.ssafy.ws05.step3;

public class BookManager {
	/** 배열의 최대크기를 상수 final이기 떄문에 public 가능 */
	public static final int MAX_SIZE = 100;
	/** 도서객체를 저장하기 위한 자료 저장구조 : 배열 */
	private Book[] books;
	/** 현재 등록된 도서의 갯수 및 추가 등록되는 도서의 배열의 인덱스 위치 */
	private int size;
	
	/** 
	 * 기본생성자
	 * 도서들을 저장위한 자료저장구조 배열객체 생성 및 할당
	 * 배열의 크기를 MAX_SIZE로 생성 초기화
	 */
	public BookManager() {
		books = new Book[MAX_SIZE];
	}
	
	/**
	 * 도서 등록
	 * @param book 등록 도서 객체
	 */
	public void add(Book book) {
		if(isExists(book.getIsbn()) == -1) {
			if(size == MAX_SIZE) {
				System.out.println("저장공간 부족");
			}
			else {
				books[size++] = book;
			}
		}
	}

	/**
	 * 도서 삭제
	 * @param isbn 도서번호
	 */
	public void remove(String isbn) {
		int index = isExists(isbn);
		if(index < 0) {
			System.out.println("없는 번호");
		}
		else {
			Book temp = books[size-1];
			books[size-1] = books[index];
			books[index] = temp;
			
			books[size-- -1] = null;
		}
	}
	
	/**
	 * 현재 등록된 전체 도서 배열
	 * @return 등록된 도서 배열
	 */
	public Book[] getList() {
		Book[] temp;
		int size = 0;
		for(int i = 0; i < MAX_SIZE; i++) {
			if(books[i] == null) {
				size = i; break;
			}
		}
		
		temp = new Book[size];
		for(int i = 0; i < size; i++) {
			temp[i] = books[i];
		}
		
		return temp;
	}
	
	/**
	 * 도서 상세 조회
	 * @param isbn 도서번호
	 * @return 해당 도서 객체, 단 미존재시 null 반환
	 */
	public Book searchByisbn(String isbn) {
		
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn))
				return books[i];
		}
		return null;
	}
	
	/**
	 * [추가 기능] 어디에 쓰는 메소드? 어디서 사용해야 효율적?
	 * @param isbn
	 * @return
	 */
	
	public int isExists(String isbn) {
		for(int index = 0; index < size; index++) {
			if(books[index].getIsbn().equals(isbn)) {
				return index;
			}
		}
		return -1;
	}

}
