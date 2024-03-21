package com.ssafy.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

/**
 * Servlet implementation class BoardUpdateServlet
 */
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("debug: 글 수정 요청!!!");
		request.setCharacterEncoding("utf-8");
		int articleNo=Integer.parseInt(request.getParameter("articleNo"));
		BoardDto boardDto = BoardDaoImpl.getInstance().viewArticle(articleNo);
		
		request.setAttribute("boardDto", boardDto );
		RequestDispatcher nextView=request.getRequestDispatcher("board/modify_css.jsp");
		nextView.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug: 글 수정 하기!!!");
		request.setCharacterEncoding("utf-8");
		
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		int articleNo=Integer.parseInt(request.getParameter("articleNo"));
		
		BoardDto boardDto = BoardDaoImpl.getInstance().viewArticle(articleNo);
		
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		
		BoardDaoImpl.getInstance().updateArticle(boardDto);
		
		response.sendRedirect("/board/list");
		
		
	}

}
