package com.ssafy.exception;


/**
 * 사용자 예외 클래스: 식별키 중복시에 예외 발생
 */
public class DuplicateException extends Exception{
	private String key;
	
//	public DuplicateException() {
//		this();
//	}
	
	public DuplicateException(String key) {
		super("[중복예외] " + key);
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
}
