package com.ssafy.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		this("해당 정보를 찾을 수 없습니다.");
	}

	public RecordNotFoundException(String message) {
		super(message);
	}
}
