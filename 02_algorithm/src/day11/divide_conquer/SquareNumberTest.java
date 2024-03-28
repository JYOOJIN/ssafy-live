package day11.divide_conquer;

import java.util.Scanner;

public class SquareNumberTest {

	static int callCnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//x의 n승을 구하시오
		int x=sc.nextInt();
		int n=sc.nextInt(); //n<=10억
		
		System.out.println(exp1(x,n));
		System.out.println(callCnt);
		
	}
	
	static long exp1(long x, int n) {
		callCnt++;
		
		if(n==1) {
			return x;
		}
		
		int half=n/2;
		long res=exp1(x,half);
		res*=res;
		
		return n%2==0? res: res*x; //짝수면 res, 홀수면 res에 자기 자신 한번 더 곱하기
		
	}

}
