package day12.graph;

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
		
		bfs(adjList,0);
		
//		for(Node node:adjList) {
//			System.out.println(node);
//		}

	}
	
	// 큐에 넣을때 방문처리 버전
	static void bfs(Node[] adjList,int start) {
		int v=adjList.length;
		
		//1. 큐와 방문관리 배열 준비
		Queue<Integer> q=new ArrayDeque<>();
		boolean[] visited=new boolean[v];
		
		//2. 시작 정점(정점 start) 큐에 넣고 방문체크
		q.offer(start); 
		visited[start]=true;
		
		//3. 큐로 방문관리
		while(!q.isEmpty()) {
			int current= q.poll(); //4. 탐색해야 하는 정점 꺼내기
			// 탐색 정점에 관련된 로직 처리
			System.out.println((char)(current+65));
			// 5. 탐색정점의 주변 인접정점들 탐색될수 있도록 처리하기
			for(Node temp=adjList[current]; temp!=null ; temp=temp.next) {
				if(!visited[temp.to]) { //방문여부 체크
					q.offer(temp.to);
					visited[temp.to]=true;
				}
			}
			
			
		}
		
		
	}
	
	
	
	

}
