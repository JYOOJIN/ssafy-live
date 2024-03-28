package com.ssafy.model.service;

//import는 같은 패키지와 java.lang 제외하고는 모두 명시적으로 해줘야 함 
import java.util.ArrayList;

import com.ssafy.exception.DuplicateException;
import com.ssafy.exception.RecordNotFoundException;
import com.ssafy.model.dto.Member;

public class MemberManager {
	// 자료구조로 List > ArrayList사용
	private static MemberManager instance= new MemberManager();
	private ArrayList<Member> list = new ArrayList<>();
	
	private MemberManager() {};
	
	public static MemberManager getInstance() {
		return instance;
	}
	
	// 현재 등록한 객체의 숫자 반환 메서드
	public int getSize() {
		return list.size();
	}
	
	// 객체 저장 유무 체크
	public int isExist(String memberId) {
		for(int i = 0; i < getSize(); i++) {
			if(list.get(i).getMemberId().equals(memberId)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void addMember(Member dto) throws DuplicateException {
		if(isExist(dto.getMemberId()) == -1) {
			list.add(dto);
			return;
		}
		
		throw new DuplicateException(dto.getMemberId());
	}
	
	public Member getMember(String memberId) throws RecordNotFoundException {
		int index = isExist(memberId);
		
		if (index < 0) {
			throw new RecordNotFoundException();
			//return null; 
		}
		return list.get(index);
	}
	
	public ArrayList<Member> getMember() throws CommonException{
		if(list.isEmpty()) {
			throw new CommonException("등록 정보 없음");
		}
		return list;
	}
	
	public boolean setMember(Member dto) {
		int index = isExist(dto.getMemberId());
		
		if(index < 0) {
			System.out.println("없는 멤버");
		}
		else {
			list.set(index, dto);
		}
		
		return true;
	}
	
	public void setMemberName(String memberId, String name) {
		int index = isExist(memberId);
		
		if(index < 0) {
			System.out.println("없는 아이디");
		}
		else {
			list.get(index).setName(name);
		}
	}
	
	public void removeMember(String memberId) {
		int index = isExist(memberId);
		
		if(index >= 0) {
			list.remove(index);
		}
	}
	
	public void printMemberList() {
		
	}
	
	public void printMemberListByName(String name) {
		
	}
}
