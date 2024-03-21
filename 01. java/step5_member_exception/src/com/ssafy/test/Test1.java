package com.ssafy.test;

public class Test1 {
	int no3;
	static int no4;
	public static void main(String[] args) {
		// static이라서 에러
		// System.out.println(no3);
		
		int no1 = 5; int no2 = 10;
		
		System.out.println(no1++); //5
		System.out.println(no1++); //6
		System.out.println(++no2 + no1--); //18
		System.out.println(no1); //6
		System.out.println(no2); //11
	}
}
