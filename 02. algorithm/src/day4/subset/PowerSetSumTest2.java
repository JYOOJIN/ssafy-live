package day4.subset;

import java.util.*;

public class PowerSetSumTest2 {

	static int N,input[],target;
	static boolean isSelected[];
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		target=sc.nextInt(); //목표 합 
		input=new int[N]; //배열 생성
		isSelected=new boolean[N]; //원소 크기만큼 배열 생성. 자리 수만큼이 x
		
		for(int i=0;i<N;i++) {
			input[i]=sc.nextInt();
		}
		
		generateSubSet(0,0); //시작이므로 아직 한개도 고려되지 않았다
	}
	
	public static void generateSubSet(int n,int sum) { //n:원소 개수, sum: 기존 부분집합의 구성요소들의 합
		

		if(n==N) { //모든 원소가 고려되었다면(하나의 subset 생성) 부분집합을 구성하는 원소들의 합이 목표합이 되는지 체크
			if(sum==target) {
				for(int i=0;i<N;i++) {
					if(isSelected[i]) System.out.print(input[i]+" "); //선택되었다면 그 자리의 값을 출력
				}
				System.out.println();
			}
			return;
		}
		
		isSelected[n]=true; //부분 집합에 포함
		generateSubSet(n+1,sum+input[n]); //내 sum 그대로 두고 더한걸 태워서 더한다. 돌아올때 sum은 변하지 않았다
		
		isSelected[n]=false;//부분 집합에 비포함.
		generateSubSet(n+1,sum); // 누적합에 변화x
		
	}

}
