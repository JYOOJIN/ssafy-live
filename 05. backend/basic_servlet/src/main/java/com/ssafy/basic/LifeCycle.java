package com.ssafy.basic;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/life") //이게 web.xml에서 주석처리한 <servlet> 부분을 모두 대체한다
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LifeCycle() {
        super();
        System.out.println("생성자 호출");
    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init 호출");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출");
	}

}
