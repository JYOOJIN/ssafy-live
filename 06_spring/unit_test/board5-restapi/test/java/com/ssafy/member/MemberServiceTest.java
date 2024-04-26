package com.ssafy.member;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.UnitTestConfig;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

public class MemberServiceTest extends UnitTestConfig {

	private final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	@Autowired
	private MemberService memberService;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("----- Class Test Start!!! -----");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("----- Class Test End!!! -----");
	}

	@Before
	public void beforeMethod() {
		System.out.println("----- Method Test Start!!! -----");
	}

	@After
	public void afterMethod() {
		System.out.println("----- Method Test Snd!!! -----");
	}

	@Test
	@Ignore
	public void testIdCheck() {
		String checkId = "ssafy";
		try {
			int cnt = memberService.idCheck(checkId);
			assertEquals(0, cnt);
		} catch (Exception e) {
			fail("아이디 중복 검사 시 에러!!!");
		}
	}

	@Test
	public void testLoginMember() {
		Map<String, String> map = new HashMap<>();
		map.put("userid", "ssafy");
		map.put("userpwd", "1234");
		try {
			MemberDto memberDto = memberService.loginMember(map);
			assertNotNull("로그인 성공", memberDto);
		} catch (Exception e) {
			fail("로그인 시 에러!!!");
		}
	}

}
