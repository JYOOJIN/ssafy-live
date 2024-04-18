package com.ssafy.fia.filter;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@Component // 모든 http 메소드 처리.
@WebFilter(urlPatterns = "/") // 특정 url만 처리.
@Order(1) // Filter가 두개 이상이 될 경우 실행 순서 결정.
public class FiaFilter1 implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(FiaFilter1.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		log.info((new Date()).toString() + " ==> Filter ::: FiaFilter1 Constructor");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info((new Date()).toString() + " ==> Filter111 ::: doFilter pre(1)");
		chain.doFilter(request, response);
		log.info((new Date()).toString() + " ==> Filter111 ::: doFilter after(1)");
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
