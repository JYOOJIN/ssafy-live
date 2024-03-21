package com.ssafy.exception;

/**
 * 사용자 예외 클래스: 식별키 중복시에 예외 발생
 */
public class DuplicateException extends Exception{
	private String key;
	
	public DuplicateException(String key) {
		super("[중복예외] " + key + "는 이미 존재하는 id입니다");
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
}
