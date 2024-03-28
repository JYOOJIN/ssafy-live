package com.ssafy.exception;

public class RecordNotFoundException extends Exception {
	private String id;
	
	public RecordNotFoundException() {
		this("해당 정보를 찾을 수 없습니다.");
	}

	public RecordNotFoundException(String id) {
		super("[검색 오류]" + id + "는 등록되지 않은 id입니다");
	}
	
	private String getId() {
		return id;
	}
}
