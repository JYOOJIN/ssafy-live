package day10.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomTest {

	static class Meeting implements Comparable<Meeting>{
		int start,end;
		
		public Meeting(int start,int end) {
			this.start=start;
			this.end=end;
		}

		@Override
		public int compareTo(Meeting o) {
			//종료 시간이 다르면 종료시간 기준으로 오름차순
			//종료 시간이 같으면 시작시간 기준으로 오름차순
			return this.end!=o.end? this.end-o.end : this.start - o.start;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Meeting[] meetings=new Meeting[N];
		
		for(int i=0;i<N;i++) {
			meetings[i]=new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(meetings); //새로 정의한 compareTo 기준으로 정렬
		
		//회의 선택을 최대로 하고 선택된 회의들의 내용을 출력
		List<Meeting> list=new ArrayList<>();
		list.add(meetings[0]); //첫 회의 선택
		for(int i=1;i<N;i++) { //i: 고려하료는 회의
			if(list.get(list.size()-1).end <=meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		
		System.out.println(list.size());
		for(Meeting m:list) {
			System.out.println(m);
		}
	}

}
