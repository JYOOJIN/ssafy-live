package com.ssafy.hello.di4.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class HelloMain {
	
		public static void main(String[] args) {
			System.out.println("프로그램 시작");
//			TODO :com/ssafy/hello/di4/xml/applicationContext.xml를 사용하여 ApplicationContext 생성
			ApplicationContext context=new ClassPathXmlApplicationContext(
					"com/ssafy/hello/di4/xml/applicationContext.xml");
			System.out.println("xml 읽기 완료");
			
			
			HelloMessage helloMessage = context.getBean("eng",HelloMessage.class);
			String greeting = helloMessage.hello("안효인");
//			String greeting = helloMessage.hello("Mr. An");
			
			System.out.println(greeting);
			
			System.out.println("----------------------------------------");
			
			HelloMessage kor1 = context.getBean("kor", HelloMessage.class);
			HelloMessage kor2 = context.getBean("kor", HelloMessage.class);
			System.out.println(kor1 + " ::::: " + kor2);
		}
		
	}
