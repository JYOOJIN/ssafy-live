package com.ssafy.fia.interceptor;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FiaInterceptor2 implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(FiaInterceptor2.class);
	
	public FiaInterceptor2() {
		log.info((new Date()).toString() + " ==> Interceptor ::: FiaInterceptor2 Constructor");
	}
			
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info((new Date()).toString() + " ==> Interceptor222 ::: preHandle(2)");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info((new Date()).toString() + " ==> Interceptor222 ::: postHandle(2)");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info((new Date()).toString() + " ==> Interceptor222 ::: afterCompletion(2)");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
