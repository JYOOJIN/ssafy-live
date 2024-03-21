package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardViewServlet
 */
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug: 글 상세 조회 요청!!!");
		request.setCharacterEncoding("utf-8");
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		
		BoardDto boardDto = BoardDaoImpl.getInstance().viewArticle(articleNo);
		
		if (boardDto != null) {
			// 성공 응답
			request.setAttribute("boardDto", boardDto );
			RequestDispatcher nextView=request.getRequestDispatcher("board/view_css.jsp");
			nextView.forward(request, response);
		} else {
			// 실패 응답
			request.setAttribute("error", "[오류] 해당 요청이 정상적으로 처리되지 않았습니다.");
			RequestDispatcher nextView=request.getRequestDispatcher("error/error.jsp");
			nextView.forward(request, response);
		}
		
		
	}

}
