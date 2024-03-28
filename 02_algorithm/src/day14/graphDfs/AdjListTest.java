package day14.graphDfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
*/

//무향 그래프: 연결리스트
public class AdjListTest {

	static class Node{
		int to;
		Node next;
		
		//다음 노드 가리키는 주소 담아야한다
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		
		//마지막 노드 추가
		public Node(int to) {
			super();
			this.to = to;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int V=sc.nextInt(); //정점수
		int E=sc.nextInt(); //간선수
		
		Node[] adjList =new Node[V]; //각 정점의 인접리스트의 헤드 저장
		for(int i=0;i<E;i++) {
			int from =sc.nextInt();
			int to=sc.nextInt();
			
			//맨 앞부터 집어넣는다. 무향이므로 양쪽에 집어넣기.
			adjList[from]=new Node(to,adjList[from]);
			adjList[to]=new Node(from,adjList[to]);
			
		}
		
		dfs(adjList,new boolean[V],0);
		


	}
	


	static void dfs(Node[] adjList, boolean[] visited,int current) { //탐색 정점 정보 매개변수로 받는다

		visited[current]=true;
		System.out.println((char)(current+65));
		for(Node tmp=adjList[current]; tmp!=null; tmp=tmp.next) {
			if(!visited[tmp.to]) {
				dfs(adjList,visited,tmp.to);
			}
		}
		
		
	}
	

}
