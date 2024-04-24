package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.good.GoodService;
import com.ssafy.hello.service.HelloService;


@Controller
public class HelloController {
	
	private final HelloService helloService;
	private final GoodService goodService;
	
	public HelloController(HelloService helloService,GoodService goodService) {
		super();
		this.helloService=helloService;
		this.goodService=goodService;
	}
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg1","안녕 스프링 부트야!!");
		model.addAttribute("msg2",helloService.getMsg());
		model.addAttribute("msg3",goodService.getMsg());
		return "hello";
	}
	
	
}
