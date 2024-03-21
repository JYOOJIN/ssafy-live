package day4.subset;

import java.util.*;

public class PowerSetTest {

	static int N,input[];
	static boolean isSelected[];
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		input=new int[N]; //배열 생성
		isSelected=new boolean[N]; //원소 크기만큼 배열 생성. 자리 수만큼이 x
		
		for(int i=0;i<N;i++) {
			input[i]=sc.nextInt();
		}
		
		generateSubSet(0); //시작이므로 아직 한개도 고려되지 않았다
	}
	
	public static void generateSubSet(int n) { //원소 개수 넘겨주는 인자
		
		if(n==N) { //모든 원소가 고려되었다면, 하나의 subset
			for(int i=0;i<N;i++) {
				System.out.print((isSelected[i]?input[i]:"")+" "); //선택되었다면 그 자리의 값을, 선택되지 않았다면 X를 출력
				
			}
			System.out.println();
			return;
		}
		
		isSelected[n]=true; //부분 집합에 포함
		generateSubSet(n+1);
		
		isSelected[n]=false;
		generateSubSet(n+1); //부분 집합에 비포함
		
	}

}
