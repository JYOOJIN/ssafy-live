package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardDto> list = BoardDaoImpl.getInstance().listArticle();
		
		if (!list.isEmpty()) {
			// 성공 응답
			// 응답을 위한 정보 설정
			request.setAttribute("list", list); //key,val
			
			// forward(페이지 이동): board/list.jsp
			// forward: 현재 컨텍스트를 기준으로 상대 경로, 기존 요청/응답 가지고 이용
			// 컨텍스트 패스명 표기해서는 안됨, url 경로는 기존 경로로 보여짐
			RequestDispatcher nextView=request.getRequestDispatcher("board/list_css.jsp");
			nextView.forward(request, response);
		} else {
			// 실패 응답
			request.setAttribute("error", "[오류] 해당 요청이 정상적으로 처리되지 않았습니다.");//key,val
			request.getRequestDispatcher("error/error.jsp").forward(request,response);
		}
	}

}
