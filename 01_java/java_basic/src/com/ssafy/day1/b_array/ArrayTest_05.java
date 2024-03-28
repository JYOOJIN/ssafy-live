package com.ssafy.day1.b_array;

public class ArrayTest_05 {
    public static void main(String[] args) {
        String org = "1234567890";

        // TODO: String "1234567890" 의 자리 별 수를 1차원 배열에 저장하고 배열을 순회해서 그 합을 출력하시오.
        int[] arr = new int[org.length()];
        
        int sum = 0;
        for(int i = 0; i < org.length(); i++) {
        	arr[i] = Character.getNumericValue(org.charAt(i));
        	sum += arr[i];
        }
        // END
        System.out.println(sum);
    }
}