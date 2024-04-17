package com.ssafy.hello.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.hello.model.HelloDto;


@Controller
public class HelloController {

	public HelloController() {
		System.out.println("helloController 생성자 호출");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	//web.xml : <welcome-file></welcome-file> 대체한 시작페이지 설정하기
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("name","정유진");
		mav.setViewName("index");
		
		return mav;
	}
	

}
