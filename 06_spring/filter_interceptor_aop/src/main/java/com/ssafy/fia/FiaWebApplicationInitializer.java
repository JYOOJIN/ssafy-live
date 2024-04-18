package com.ssafy.fia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ssafy.fia.config.WebConfig;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class FiaWebApplicationInitializer implements WebApplicationInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(FiaWebApplicationInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.info("FiaWebApplicationInitializer.onStartup() call!!!!!!");
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class); // 단일 클래스만 등록
		// context.scan("basePackages..."); // 패키지를 통째로 스캔 가능.
		servletContext.addListener(new ContextLoaderListener(context));
		
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}

}