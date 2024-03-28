package com.ssafy.model.service;

public class CommonException extends Exception {
	public CommonException() {
		super("사용자 예외");
	}
	public CommonException(String str) {
		super(str);
	}
}
