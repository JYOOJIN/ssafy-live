package com.ssafy.fia.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	public MainController() {
		log.info((new Date()).toString() + " ==> Controller ::: MainController Constructor");
	}

	@GetMapping("/")
	public String index() {
		log.info((new Date()).toString() + " : " + " => Controller ::: index()");
		return "index";
	}
	
}
