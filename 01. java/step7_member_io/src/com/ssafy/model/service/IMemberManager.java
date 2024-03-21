package com.ssafy.model.service;

import java.util.ArrayList;

import com.ssafy.exception.DuplicateException;
import com.ssafy.exception.RecordNotFoundException;
import com.ssafy.model.dto.Member;

public interface IMemberManager {
	// 회원가입해서 배열에 멤버를 등록하는 메소드
	public void signUp(Member m) throws DuplicateException;
	// Id로 회원을 검색해서 Member를 리턴하는 메소드
	public Member searchById(String id) throws RecordNotFoundException;
	// 현재 배열에 저장된 모든 멤버를 조회하는 메소드
	// type에 따라서 이름 또는 가입일을 기준으로 정렬해서 출력함
	public ArrayList<Member> getList(String type);
	// 비밀번호를 수정하는 메소드
	public void updateMemberPw(String id, String pw) throws RecordNotFoundException;
	// 이름을 수정하는 메소드
	public void updateMemberName(String id, String name) throws RecordNotFoundException;
	// 이메일을 수정하는 메소드
	public void updateMemberEmail(String id, String email) throws RecordNotFoundException;
	// 비밀번호를 수정하는 메소드
	public void updateMemberMobile(String id, String mobile) throws RecordNotFoundException;
	// 멤버를 삭제하는 메소드
	public void removeMember(String id) throws RecordNotFoundException;
	/** 마일리지가 특정 이상이면 출력하기 */
	void getMileageList(int mileage);
	/** 등록된 회원의 등급을 업그레이드한다 */
	void upgradeMemberGrade(String memberId);
}
