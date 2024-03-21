package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ParameterTest() {
        
    }

    //request는 요청. response는 응답.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 이름,비번,과일 get
		//input의 name -> id는 js에서 사용한다. servlet에서는 name!!
		String name=request.getParameter("username"); 
		String pwd=request.getParameter("userpwd");
		String[] fruit=request.getParameterValues("fruit");
		
		//2. logic 처리
		
		
		//3. 응답페이지 작성(html)
		response.setContentType("text/html; charset=utf-8"); //encoding 설정
		PrintWriter out= response.getWriter(); //통로를 뚫었다
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1>과일 선호도 조사</h1>");
		out.println(name+"("+pwd+")"+"님이 좋아하는 과일은 ");
		
		if(fruit != null) { 
			for(int i=0;i<fruit.length;i++) {
				out.print(fruit[i]);
				if(i!=fruit.length-1) {
					out.print(", ");
				}
			}
			out.println(" 입니다.");
		}else {
			out.print("없습니다.");
		}
			
		out.println(" 	</body>");
		out.println("</html>");
	}

	
}