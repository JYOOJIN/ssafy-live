package com.ssafy.test;

import java.io.IOException;

class A{
	void doA() throws Exception {
		System.out.println("AA");
		if(true) {
			throw new Exception("[예외] 테스트용 예외");
		}
	}
}
class B extends A{
	void doB() {
		System.out.println("BB");
	}
	
	@Override
	public void doA() throws IOException {
		
	}
}

public class ExceptionTest {
	public static void main(String[] args) throws Exception {
		A a1 = new A();
		a1.doA();
		B b1 = new B();
		b1.doB();
	}
		
	public static void main1() {
		String[] names = {"싸피11", "광주", "아니다"};
		
		for(int index = 0; index < 5; index++) {
			System.out.println(names[index]);
		}
		
		System.out.println("프로그램 정상 종료");
	}
	
	public static void main2() {
		String[] names = {"싸피11", "광주", "아니다"};
		
		for(int index = 0; index < 5; index++) {
			try {
				System.out.println(names[index]);
			}catch(ArrayIndexOutOfBoundsException e) {
				String ms= e.getMessage();
				System.out.println("[Error]" + ms);
				e.printStackTrace();
			}finally {
				System.out.println("반드시 처리되는 수행문!!!");
			}
		}
		
		System.out.println("프로그램 정상 종료");
	}
	
	public static void main3() {
		String[] names = {"싸피11", "광주", "아니다"};
		
		for(int index = 0; index < 5; index++) {
			try {
				System.out.println(names[index]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
				//System.exit(1);
				String msg = null;
				System.out.println(msg.length());
//				String ms= e.getMessage();
//				System.out.println("[Error]" + ms);
//				e.printStackTrace();
			}finally {
				System.out.println("반드시 처리되는 수행문!!!");
			}
		}
		
		System.out.println("프로그램 정상 종료");
	}
	
	public static void main4() {
		String[] names = {"싸피11", "광주", "아니다"};
		
		int no = 128;
		try {
			System.out.println(no / 0);
			System.out.println(names[-1]);
//		}catch(ArithmeticException e) {
//			System.out.println("A");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("B");
		}catch(ClassCastException e) {
			System.out.println("C");
		}catch(NullPointerException e) {
			System.out.println("D");
		}catch(Exception e) {
			String className= e.getClass().getName();
			System.out.println("[예외클래스]" + className);
		}finally {
			System.out.println("X");
		}
		
		System.out.println("프로그램 정상 종료");
	}
}
