package com.ssafy.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// servlet에 url있으면 @webServlet 하면 안됨
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int REQEUST_COUNT;
	
	static {
		 System.out.println("서블릿 클래스 로딩...변경");
	}
   
    public LifeCycleServlet() {
        super();
        System.out.println("객체 생성자 수행...변경");
    }

	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * super.init(config); //부모가 만든거 수행
	 * System.out.println("서블릿 사용자 초기화 수행..."); 
	 * }
	 */
	
	public void init() {
		/*
		 * if(true) { throw new NumberFormatException("쉬는시간"); }
		 */
		System.out.println("서블릿 사용자 초기화 수행...변경");
	}

	public void destroy() {
		System.out.println("서블릿 자원 해제 수행 - 서비스 종료, 기존 서비스 변경시에 수행...변경");
	}

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("서비스 반복 수행 ... service()"); System.out.println("요청 카운트: "+
	 * ++REQEUST_COUNT); }
	 */

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("get 요청에 대한 서비스 반복 수행... doGet()");
	 * System.out.println("요청 카운트: "+ ++REQEUST_COUNT); }
	 */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 요청에 대한 서비스 반복 수행... doPost()");
		System.out.println("요청 카운트: "+ ++REQEUST_COUNT);
	}

}
