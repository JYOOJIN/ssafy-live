package com.ssafy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.member.model.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@SuppressWarnings("deprecation")
//public class ConfirmInterceptor extends HandlerInterceptorAdapter {
//spring 5.3 부터는 HandlerInterceptor implements
public class ConfirmInterceptor implements HandlerInterceptor { 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto == null) {
			//login 안되어있으면 login 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/user/login"); 
			return false;
		}
		return true;
	}
	
}