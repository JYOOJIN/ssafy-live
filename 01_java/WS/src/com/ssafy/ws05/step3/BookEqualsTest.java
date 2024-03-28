package com.ssafy.ws05.step3;

public class BookEqualsTest {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = new String("Hello");

		if(s1 == s2) System.out.println("잠시");
		if(s1 == s3) System.out.println("잠시");
		if(s1 == s4) System.out.println("잠시");
		
		if(s1.equals(s2)) System.out.println("gg");
		if(s1.equals(s3)) System.out.println("gg");
		if(s1.equals(s4)) System.out.println("gg");
		
		Book b1 = new Book();
		Book b2 = new Book("100", "자바");
		Book b3 = new Book("100", "자바");
		Book b4 = new Book("100", "웹");
		Book b5 = b1;
		
		System.out.println(b1 == b2);
		System.out.println(b1 == b3);
		System.out.println(b1 == b4);
		System.out.println(b1 == b5);
		System.out.println();
		
		System.out.println(b1.equals(b2));
		System.out.println(b1.equals(b3));
		System.out.println(b1.equals(b4));
		System.out.println(b1.equals(b5));
		System.out.println();
		
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());
		System.out.println(b3.hashCode());
		System.out.println(b4.hashCode());
		System.out.println(b5.hashCode());
		System.out.println();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Object o1 = new Object();
//		Object o2 = new Object();
//		Object o3 = o1;
//		
//		System.out.println(o1 == o2);
//		System.out.println(o1 == o3);
//		
//		System.out.println(o1.equals(o2));
//		System.out.println(o1.equals(o3));
//		
//		System.out.println("o1 = " +  o1.hashCode());
//		System.out.println("o2 = " +  o2.hashCode());
//		System.out.println("o3 = " +  o3.hashCode());
//	}

}
