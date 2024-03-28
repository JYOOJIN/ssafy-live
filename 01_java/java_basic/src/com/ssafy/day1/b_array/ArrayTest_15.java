package com.ssafy.day1.b_array;

public class ArrayTest_15 {
    public static void main(String[] args) {
        // TODO: 문제에서 제시하는 2차원 배열을 생성하고 내용을 출력하시오.
    	String[] names = {"홍길동", "강감찬", "이순신"};
    	int[][] arr = {{70, 75, 80, 85}, {80, 85, 90, 95, 100}, {75, 80, 85}};
    	
    	for(int i = 0; i < arr.length; i++) {
    		int sum = 0;
    		double avg = 0.0;
    		
    		for(int j = 0; j < arr[i].length; j++) {
    			sum += arr[i][j];
    		}
    		avg = (double)sum / arr[i].length;
    		// END
    	
    		System.out.printf("%3d %5s %d %.2f\n", i+1, names[i], sum, avg);
    	}
    }
}
