package com.ssafy.fia.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FiaAop {
	
	private static final Logger log = LoggerFactory.getLogger(FiaAop.class);
	
	public FiaAop() {
		log.info((new Date()).toString() + " ==> AOP ::: FiaAop Constructor");
	}
	
	@Before("execution(* com.ssafy.fia.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		log.info((new Date()).toString() + " ==> AOP ::: before");
	}

	@After("execution(* com.ssafy.fia.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		log.info((new Date()).toString() + " ==> AOP ::: after");
	}

	@AfterReturning(pointcut = "execution(* com.ssafy.fia.controller.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		log.info((new Date()).toString() + " ==> AOP ::: afterReturning");
	}

	@AfterThrowing(pointcut = "execution(* com.ssafy.fia.controller.*.*(..))", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		log.info((new Date()).toString() + " ==> AOP ::: afterThrowing");
	}

	@Around("execution(* com.ssafy.fia.controller.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info((new Date()).toString() + " ==> AOP ::: around1");

		Object result = joinPoint.proceed();
		log.info((new Date()).toString() + " ==> AOP ::: around2");
		return result;
	}
}
