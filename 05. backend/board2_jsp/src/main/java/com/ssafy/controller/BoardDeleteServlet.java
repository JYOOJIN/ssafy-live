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


public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("debug: 글 삭제 요청!!!");
		request.setCharacterEncoding("utf-8");
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		
		BoardDaoImpl.getInstance().deleteArticle(articleNo);
		
		// servlet 으로 가야한다.
		response.sendRedirect("/board/list");
	
	
	}


}