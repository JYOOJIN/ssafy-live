package com.ssafy.model.list;

//import는 같은 패키지와 java.lang 제외하고는 모두 명시적으로 해줘야 함 
import java.util.ArrayList;
import com.ssafy.model.dto.Member;

public class MemberManagerGenericList {
	// 자료구조로 List > ArrayList사용
	private static MemberManagerGenericList instance= new MemberManagerGenericList();
	private ArrayList<Member> list = new ArrayList<>();
	
	private MemberManagerGenericList() {};
	
	public static MemberManagerGenericList getInstance() {
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
	
	public void addMember(Member dto) {
		if(isExist(dto.getMemberId()) == -1) {
			list.add(dto);
		}
		else {
			throw new RuntimeException("[예외] 동일아이디 존재");
		}
	}
	
	public Member getMember(String memberId) {
		int index = isExist(memberId);
		
		if (index < 0) return null; 
		return list.get(index);
	}
	
	public ArrayList<Member> getMember(){
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
