package day3.permutation_combination;
import java.util.*;

public class DiceTest {

	
	static int N;
	static int[] numbers;
	static boolean[] isSelected;
	
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N= sc.nextInt(); //주사위 던지는 횟수
		numbers=new int[N]; //던져진 주사위 눈 저장할 배열
		int mode=sc.nextInt(); //주사위 던지기 모드
		
		switch(mode) {
		case 1: //중복 순열
			dice1(0);
			break;
		case 2:  //순열: 중복관리
			isSelected = new boolean[7]; //주사위 눈이 사용되었는지 여부 관라
			dice2(0);
			break;
		case 3:
			dice3(0,1);
			break;
		case 4:
			dice4(0,1);
			break;
		}
	}
 	
	public static void dice1(int cnt) { //주사위 던지기(cnt: 기존까지 던진 주사위 횟수)
	 		//isSelected를 관리할 필요가 없다!!
	 		if(cnt==N) {
	 			System.out.println(Arrays.toString(numbers));
	 			return;
	 		}
	 		
	 		
	 		for(int i=1;i<=6;i++) { //모든 주사위 눈의 수를 시도(i:주사위 눈의 수)
	 			numbers[cnt]=i;
	 			dice1(cnt+1); //다음 주사위 던지러 가기

	 		}
	 		
	 	}
 	
 	
 	public static void dice2(int cnt) { //주사위 던지기(cnt: 기존까지 던진 주사위 횟수)
 		
 		if(cnt==N) {
 			System.out.println(Arrays.toString(numbers));
 			return;
 		}
 		
 		
 		for(int i=1;i<=6;i++) { //모든 주사위 눈의 수를 시도(i:주사위 눈의 수)
 			if(isSelected[i]) continue;
 			numbers[cnt]=i;
 			isSelected[i]=true;
 			dice2(cnt+1); //다음 주사위 던지러 가기
 			isSelected[i]=false; //매우 중요하다!!!체크 풀어주지 않으면 이 주사위 수는 다시는 쓸수가 없다.
 			
 		}
 		
 	}
 	
 	//중복 조합
 	public static void dice3(int cnt, int start) { //자릿수(depth), 어디부터 뽑아야 하는지 시작점
 		
 		if(cnt==N) {
 			System.out.println(Arrays.toString(numbers));
 			return;
 		}
 		
 		//시작점부터 가능한 끝까지 선택하는 시도
 		for(int i=start;i<=6;i++) {
 			numbers[cnt]=i; //선택한 수를 저장
 			dice4(cnt+1,i); //자릿수 증가, 현재 선택한거 부터 시작점!!! 주의!!!
 		}
 	} 	
 	
 	//조합
 	public static void dice4(int cnt, int start) { //자릿수(depth), 어디부터 뽑아야 하는지 시작점
 		
 		if(cnt==N) {
 			System.out.println(Arrays.toString(numbers));
 			return;
 		}
 		
 		//시작점부터 가능한 끝까지 선택하는 시도
 		for(int i=start;i<=6;i++) {
 			numbers[cnt]=i; //선택한 수를 저장
 			dice4(cnt+1,i+1); //자릿수 증가, 현재 선택한거의 다음부터 시작해야한다. 주의!!!
 		}
 	}

}
