package com.ssafy.model.service;

import java.util.ArrayList;
import java.util.Collections;

import com.ssafy.exception.DuplicateException;
import com.ssafy.exception.RecordNotFoundException;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.SpecialMember;
import com.ssafy.model.dto.GeneralMember;
import com.ssafy.model.dto.IdComparator;

public class MemberManager implements IMemberManager {
	// 자료구조로 List > ArrayList사용
	private static MemberManager instance= new MemberManager();
	private ArrayList<Member> list = new ArrayList<>();
	
	private MemberManager() {};
	
	public static MemberManager getInstance() {
		return instance;
	}

	// 객체 저장 유무 체크해서 있으면 인덱스를, 없으면 -1을 반환
	public int isExist(String memberId) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMemberId().equals(memberId)) {
				return i;
			}
		}
		
		return -1;
	}
	
	// 멤버를 받아서 중복되는 id가 이미 존재하면 예외를 발생시키고 아니라면 멤버를 추가한다
	@Override
	public void signUp(Member dto) throws DuplicateException {
		if(isExist(dto.getMemberId()) == -1) {
			list.add(dto);
			return;
		}
		
		throw new DuplicateException(dto.getMemberId());
	}
	
	// id를 받아서 해당하는 멤버가 없을 경우 예외 발생, 있다면 해당 객체를 반환한다.
	@Override
	public Member searchById(String memberId) throws RecordNotFoundException {
		int index = isExist(memberId);
		
		if (index < 0) {
			throw new RecordNotFoundException(memberId); 
		}
		return list.get(index);
	}
	
	// 모든 멤버의 정보를 출력하되
	// type에 "name"이 들어오면 이름을 기준으로 출력한다.
	// type에 "entryDate"가 들어오면 가입일을 기준으로 정렬해서 출력한다.
	@Override
	public ArrayList<Member> getList(String type){
		if(type.equals("name")) {
			ArrayList<Member> nameSortedList = list;
			Collections.sort(nameSortedList);
			
			return nameSortedList;
		}
		else if(type.equals("entryDate")) {
			ArrayList<Member> entryDateSortedList = list;
			Collections.sort(entryDateSortedList, new IdComparator());
			
			return entryDateSortedList;
		}
		else {
			return list;
		}
	}

	// id를 기준으로 해당 멤버를 삭제한다.
	@Override
	public void removeMember(String id) throws RecordNotFoundException {
		int index = isExist(id);
		
		if(index < 0) {
			throw new RecordNotFoundException(id);
		}
		
		list.remove(index);
	}

	@Override
	public void updateMemberPw(String id, String pw) throws RecordNotFoundException {
		int index = isExist(id);
		
		if(index < 0) {
			throw new RecordNotFoundException(id);
		}
		
		list.get(index).setPassword(pw);
	}

	@Override
	public void updateMemberName(String id, String name) throws RecordNotFoundException {
		int index = isExist(id);
		
		if(index < 0) {
			throw new RecordNotFoundException(id);
		}
		
		list.get(index).setName(name);
	}

	@Override
	public void updateMemberEmail(String id, String email) throws RecordNotFoundException {
		int index = isExist(id);
		
		if(index < 0) {
			throw new RecordNotFoundException(id);
		}
		
		list.get(index).setEmail(email);
	}

	@Override
	public void updateMemberMobile(String id, String mobile) throws RecordNotFoundException {
		int index = isExist(id);
		
		if(index < 0) {
			throw new RecordNotFoundException(id);
		}
		
		list.get(index).setMobile(mobile);
	}
	
	/** 마일리지가 특정 이상이면 출력하기 */
    @Override
    public void getMileageList(int mileage) {
        System.out.printf("마일리지가 %d 이상인 회원 목록 입니다.\n",mileage);
        boolean flag = false;
        for(int i = 0; i < list.size(); i++ ) {
            if(list.get(i) instanceof GeneralMember) {
                if(((GeneralMember) list.get(i)).getMileage() >= mileage) {
                    System.out.println(list.get(i));
                    flag = true;
                }
            }
        }
        // 찾는 회원이 없으면 에러를 throws
        if(!flag) {
            System.out.printf("마일리지가 %d 이상인 회원은 없습니다.\n", mileage);
        }
        else {
            System.out.println("등급 수정을 하시겠습니까? 1: 예, 2: 아니오");
        }
    }
    
    /** 등록된 회원의 등급을 업그레이드한다 */
    @Override
    public void upgradeMemberGrade(String memberId) {
        System.out.printf("%s id를 가진 회원을 등급을 업그레이드합니다.\n", memberId);
        Member temp_member;
        boolean flag = false;
        for(int i = 0; i < list.size(); i++) {
            temp_member = list.get(i);
            if(temp_member.getMemberId().equals(memberId)) {
                // 일반 회원이면 변경 가능
                if(temp_member instanceof GeneralMember) {
                    if(temp_member.getGrade() == 'G') {
                        // 특별 회원 객체 생성
                        SpecialMember sm = new SpecialMember(temp_member.getMemberId(), temp_member.getPassword(), temp_member.getName(),
                                                            temp_member.getMobile(), temp_member.getEmail(), temp_member.getEntryDate(), 'S',
                                                            "김훈민", 30);
                        // 기존에 등록되어 있었던 일반 회원 객체 삭제
                        list.remove(temp_member);
                        // 특별 회원 추가
                        list.add(sm);
                        System.out.println("등급 업그레이드 완료");
                        flag = true;
                        break;
                    }
                    else {
                        System.out.println("선택한 회원이 일반 회원이 아닙니다.");
                    }
                }
            }
        }
        // 변경하고자 검색한 회원이 없는 상황
        if(!flag) {
            System.out.println("해당 회원이 없습니다.");
        }
    }
}
