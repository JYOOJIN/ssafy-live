package com.ssafy.view;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ssafy.exception.DuplicateException;
import com.ssafy.exception.RecordNotFoundException;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.GeneralMember;
import com.ssafy.model.dto.SpecialMember;
import com.ssafy.model.dto.AdminMember;
import com.ssafy.model.service.MemberManager;

public class MemberTest {
	public static void main(String[] args) throws Exception {
		MemberManager mm = MemberManager.getInstance();
		
		Member m1 = new GeneralMember("user01", "password01", "홍길동", "01012341111", "user01@work.com", "2017/05/05", 'G', 7500);
		Member m2 = new GeneralMember("user02", "password02", "강감찬", "01012341112", "user02@work.com", "2017/05/06", 'G', 9500);
		Member m3 = new GeneralMember("user03", "password03", "이순신", "01012341113", "user03@work.com", "2017/05/07", 'G', 3000);
		Member m4 = new SpecialMember("user04", "password04", "김유신", "01012341114", "user04@work.com", "2017/05/08", 'S', "송중기", 30);
		Member m5 = new AdminMember("user05", "password05", "유관순", "01012341115", "user05@work.com", "2017/05/09", 'A', "선임");
		
		// 기본 멤버를 추가하고 시작한다
		try {
			mm.signUp(m1);
			mm.signUp(m2);
			mm.signUp(m3);
			mm.signUp(m4);
			mm.signUp(m5);
		}catch(DuplicateException e) {
			System.out.println(e.getMessage());
		}
		
		// 콘솔 화면 시작
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Member session = null;
		while(true) {
			if(session == null) {
				System.out.println("수행할 명령을 선택하시오");
				System.out.println("1. 로그인");
				System.out.println("2. 회원 가입");
				System.out.println("3. ID / 비밀번호 찾기");
				System.out.println("4. 종료");
				
				int order = Integer.parseInt(bf.readLine());
				
				switch(order){
				case 1:
					// 아이디 비밀번호 입력
					System.out.println("ID와 비밀번호를 입력하세요: ");
					StringTokenizer st = new StringTokenizer(bf.readLine());
					
					String id = st.nextToken();
					String pw = st.nextToken();
					
					// 아이디를 바탕으로 멤버를 가져와서 비밀번호를 비교
					// 비밀번호가 불일치하다는 예외를 사용하면 좋겠으나 시간상 간략화
					Member temp = null;
					try {
						temp = mm.searchById(id);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					if(!temp.getPassword().equals(pw)) {
						System.out.println("비밀번호가 입력하지 않습니다.");
					}
					else {
						session = temp;
					}
					break;
				case 2:
					// 회원 가입
					System.out.println("다음의 항목을 순서대로 입력하세요");
					System.out.println("ID, 비밀번호, 이름, 전화번호, 이메일, 가입일");
					st = new StringTokenizer(bf.readLine());
					Member tmp = new GeneralMember(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
							st.nextToken(), st.nextToken(), 'G', 0);
					
					// 아이디 중복시 예외 발생
					try {
						mm.signUp(tmp);
					}catch(DuplicateException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 3:
					// 아이디 비밀번호 찾기 미구현 상태
					System.out.println("미구현");
					break;
				case 4:
					return;
				default:
					return;
				}
			}
			else {
				// 로그인 후 명령 수행
				// 원래 관리자 계정으로 로그인 시에만 수행되어야 하나 시간상 간략화
				System.out.println("수행할 명령을 선택하시오");
				System.out.println("1. 전체 회원 정보 확인");
				System.out.println("2. 회원 정보 수정");
				System.out.println("3. 회원 정보 삭제");
				System.out.println("4. 회원 승급");
				System.out.println("5. 로그 아웃");
				
				int order = Integer.parseInt(bf.readLine());
				
				switch(order){
				case 1:
					// 정렬 기준을 입력
					System.out.println("정렬 기준을 선택해 주세요. 1 : 이름, 2: 가입일");
					
					int seq = Integer.parseInt(bf.readLine());
					
					if(seq == 1) {
						ArrayList<Member> arr = mm.getList("name");
						
						for(Member m : arr) {
							System.out.println(m);
						}
					}
					else {
						ArrayList<Member> arr = mm.getList("entryDate");
						
						for(Member m : arr) {
							System.out.println(m);
						}
					}
					break;
				case 2:
					// 회원 정보 수정
					System.out.println("수정할 회원의 ID를 입력해 주세요");
					String id = bf.readLine();
					System.out.println("수정할 항목을 선택하세요. 1: 비밀번호, 2: 이름, 3: 전화번호, 4: 이메일");
					
					int value = Integer.parseInt(bf.readLine());
					
					switch(value) {
					case 1:
						// 비밀번호는 updateMemberPw 호출
						System.out.println("새로운 비밀번호를 입력하세요 :");
						String pw = bf.readLine();
						
						try {
							mm.updateMemberPw(id, pw);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						// 이름은 updateMemberName 호출
						System.out.println("새로운 이름을 입력하세요 :");
						String name = bf.readLine();
						
						try {
							mm.updateMemberName(id, name);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						// 전화번호는 updateMemberMobile 호출
						System.out.println("새로운 전화번호를 입력하세요 :");
						String mobile = bf.readLine();
						
						try {
							mm.updateMemberMobile(id, mobile);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						// 이메일은 updateMemberEmail 호출
						System.out.println("새로운 이메일을 입력하세요 :");
						String email = bf.readLine();
						
						try {
							mm.updateMemberEmail(id, email);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					default:
						return;
					}
					break;
				case 3:
					// 회원 삭제
					System.out.println("삭제할 회원의 ID를 입력해 주세요");
					String removeId = bf.readLine();
					
					try {
						mm.removeMember(removeId);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					mm.getMileageList(5000);
					
					int o = Integer.parseInt(bf.readLine());
					
					if(o == 1) {
						System.out.println("회원의 ID를 입력하세요:");
						String upgradeId = bf.readLine();
						mm.upgradeMemberGrade(upgradeId);
					}
					
					
					break;
				case 5:
					session = null;
					break;
				default:
					return;
				}
			}

		}
	}
}
