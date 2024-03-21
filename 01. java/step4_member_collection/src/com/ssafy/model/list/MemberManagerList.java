package com.ssafy.model.list;

// import는 같은 패키지와 java.lang 제외하고는 모두 명시적으로 해줘야 함 
import java.util.ArrayList;
import com.ssafy.model.dto.Member;

public class MemberManagerList {
	// 자료구조로 List > ArrayList사용
	private static MemberManagerList instance= new MemberManagerList();
	private ArrayList<Object> list = new ArrayList<>();
	
	private MemberManagerList() {};
	
	public static MemberManagerList getInstance() {
		return instance;
	}
	
	// 현재 등록한 객체의 숫자 반환 메서드
	public int getSize() {
		return list.size();
	}
	
	// 객체 저장 유무 체크
	public int isExist(String memberId) {
		for(int i = 0; i < getSize(); i++) {
			
			// jdk 1.4 기준으로는 이렇게 해줘야함
			Object obj = list.get(i);
			//
			if(obj instanceof Member) {
				Member dto = (Member)obj;
				if(dto.getMemberId().equals(memberId)){
					return i;
				}
			}
			
			// jdk14일 경우 이렇게 가능하게 편해졌음
//			if(list.get(i).getMemberId().equals(memberId)) {
//				return i;
//			}
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
		int index = 0;
		
		//jdk 1.4
		for(int inde = 0; index < list.size(); index++) {
			Object obj = list.get(index);
			if(obj instanceof Member dto) {
				if (dto.getMemberId().equals(memberId)) {
					return (Member)list.get(index);
				}
			}
		}
		
		//jdk 1.5
//		for(int i = 0; i < getSize(); i++) {
//			if(list.get(i).getMemberId().equals(memberId)) {
//				index = i; break;
//			}
//		}
//		
//		return list.get(index);
		return null;
	}
}
