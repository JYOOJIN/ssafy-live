package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//implements servlet이 원칙이긴하지만 그러면 method를 다 override 해주는게 불편하다
public class HelloSsafy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloSsafy() {
        super();
        System.out.println("호출");
    }


    //요청: request, 응답: response
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("utf-8"); //encoding 설정
		response.setContentType("text/html; charset=utf-8"); //encoding 설정
		PrintWriter out= response.getWriter(); //통로를 뚫었다
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1>hello this is servlet</h1>");
		out.println("		<h2>백엔드 시작해봅시다</h2>");
		out.println(" 	</body>");
		out.println("</html>");
		
	}
	

}