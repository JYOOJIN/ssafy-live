
package com.ssafy.board;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.UnitTestConfig;
import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

	public class BoardServiceTest extends UnitTestConfig {
	
		private final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);
	
		@Autowired
		private BoardService boardService;

	@Test
	@Ignore
	public void testWriteArticle() {
		BoardDto boardDto = new BoardDto();
		boardDto.setUserId("ssafy");
		boardDto.setSubject("unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!unit test 제목입니다!!!");
		boardDto.setContent("unit test 내용입니다!!!");
		try {
			boardService.writeArticle(boardDto);
		} catch (Exception e) {
			fail("글 작성 실패!!");
		}
	}

	@Test
	@Ignore
	public void testListArticle() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pgno", "1");
		map.put("key", "");
		map.put("word", "");
		try {
			List<BoardDto> list = boardService.listArticle(map);
			assertEquals(20, list.size());
			log.debug("list : {}", list);
			log.debug("list size : {}", list.size());
		} catch (Exception e) {
			fail("글 목록 실패!!");
		}

	}

	@Test
	public void testGetArticle() {
		int no = 1000;
		try {
			BoardDto boardDto = boardService.getArticle(no);
			assertNotNull(no + "글 없음", boardDto);
		} catch (Exception e) {
			fail(no + "번 글 얻기 실패!!");
		}

	}

}
