package com.ssafy.fia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.fia.interceptor.FiaInterceptor1;
import com.ssafy.fia.interceptor.FiaInterceptor2;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ssafy.fia" })
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/styles/**").addResourceLocations("/WEB-INF/styles/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new FiaInterceptor1()).addPathPatterns("/").excludePathPatterns("/css/**", "/js/**");
		registry.addInterceptor(new FiaInterceptor2()).addPathPatterns("/").excludePathPatterns("/css/**", "/js/**");
	}

}
