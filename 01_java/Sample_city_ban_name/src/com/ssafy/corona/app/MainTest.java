package com.ssafy.corona.app;

import java.util.*;
import com.ssafy.corona.virus.*;

public class MainTest {
	public static void main(String[] args) {
	

		// 10.질병관리 문제 //
		//
		//	아래 11~13번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("10.질병관리(코로나,메르스) =================================");
		
		System.out.println();		
		
 //<- 주석 해제 후 작성 : start ////////////////////////////////
 		VirusMgr vmgr = VirusMgrImpl.getInstance();
 		// 싱글톤 패턴을 위한 인스턴스 생성 및 getInstance 함수 생성
		System.out.println("11.코로나19 등록");
		// 정상 출력 예: 
		// 11.코로나19 등록
		// 코로나19: 등록된 바이러스입니다.
		try {
			vmgr.add(new Mers(  "메르스15", 2, 1.5));
			vmgr.add(new Corona("코로나19", 3, 2));
			vmgr.add(new Corona("코로나19", 2, 2));
			// 생성자의 이름을 가진 함수가 void 타입으로 되어있어서 생성자 역할을 하지 못하는 문제 해결
		} catch (DuplicatedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		System.out.println("12.바이러스 전체검색");
		// 정상 출력 예: 
		// 12.바이러스 전체검색
		// 메르스15	2	1.5
		// 코로나19	3	2
		Virus[] virus=vmgr.search();
		for(Virus v:virus) {
			// 배열에 있는 빈 값들도 모두 출력하므로 null을 만나면 종료하도록 변경
			System.out.println(v);
		}
		System.out.println();
		
		
		

 //<- 주석 해제 후 작성 : end /////////////////////////////////
		
		

	}
}