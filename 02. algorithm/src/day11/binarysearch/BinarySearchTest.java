package day11.binarysearch;

import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;

/*
 * input
 * 2,4,7,9,11,19,23
 * 
 * output
 * 7,23,20 검색.존 재하면1, 미존재하면0
 */

public class BinarySearchTest {
	
	public static void main(String[] args) throws IOException{
		int[] arr= {7,23,2,9,11,4,19}; //input 원본 데이터
		int[] key= {7,23,20}; //검색 데이터
		
		Arrays.sort(arr); //이진검색 데이터는 반드시 정렬되어 있어야한다.
		
		StringBuilder sb=new StringBuilder(); //결과 저장
		for(int i=0;i<key.length;i++) {
			//int res=binarySearch(arr, key[i]); //반복구조
			
			int res=binarySearch2(arr,0,arr.length-1,key[i]); //재귀구조
			if(res>=0) { //존재하면 1 출력
				sb.append(1).append("\n");
			}else { //미존재하면 0 출력
				sb.append(0).append("\n");
			}
			
			//3. Api: Arrays.binarySearch(int[] arr,int key)
//			if(Arrays.binarySearch(arr, key[i])>=0) {
//				sb.append(1).append("\n");
//			}else {
//				sb.append(0).append("\n");
//			}
			
			//4. Api: Arrays.binarySearch(int[] arr,int fromIndex,int toIndex, int key)
//			if(Arrays.binarySearch(arr, 0, arr.length,key[i])>=0) { //arr.length-1하면 toIndex는 포함을 안하므로 틀린.반드시 결과 확인
//				sb.append(1).append("\n");
//			}else {
//				sb.append(0).append("\n");
//			}
		}
		
		System.out.println(sb); //결과출력
		
 	}
	
	//1. 반복 구조: 이진 검색
	//args: 원본 데이터 배열 요소(정렬), 검색 key
	//return: 검색 요소 인덱스, 실패-1
	
	public static int binarySearch(int[] arr,int key) {
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) { //start가 end보다 커지기 전까지 반복
			
			int mid=(start+end)/2;
			
			if(arr[mid]<key) { //중간값이 key보다 작다면 up
				start=mid+1;
				
			}else if(arr[mid]>key) { //중간값이 key보다 크면 down
				end=mid-1;
				
			}else {
				return mid;
			}
			
		}
		
		return -1;
	}
	
	
	//2. 재귀 구조
	public static int binarySearch2(int[] arr,int start,int end,int key) {
		
		if(start<=end) {
			int mid=(start+end)/2;
			
			if(arr[mid]<key) { //중간값이 key보다 작다면 up
				binarySearch2(arr,mid+1,end,key);
				
			}else if(arr[mid]>key) { //중간값이 key보다 크면 down
				binarySearch2(arr,start,mid-1,key);
				
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	
}
