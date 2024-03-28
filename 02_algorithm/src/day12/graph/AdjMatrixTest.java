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

/*
7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6
 */
//무향 그래프
public class AdjMatrixTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int V=sc.nextInt();
		int E=sc.nextInt();
		
		int[][] adjMatrix =new int[V][V]; //0으로 초기화(인접되지 않은 상태로 초기화)
		for(int i=0;i<E;i++) {
			int from =sc.nextInt();
			int to=sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to]=1; //무향이므로 간선 양방향 처리	
		}
		
		bfs(adjMatrix,0);
		//bfs2(adjMatrix,0);
		
//		for(int[] row:adjMatrix) {
//			System.out.println(Arrays.toString(row));
//		}

	}
	
	// 큐에 넣을때 방문처리 버전
	static void bfs(int[][] adjMatrix,int start) {
		int v=adjMatrix.length;
		
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
			for(int i=0;i<v;i++) {
				if(adjMatrix[current][i] !=0 && !visited[i]) { //인접정점 체크, 방문여부 체크
					q.offer(i); 
					visited[i]=true;
					
				}
			}
			
			
		}
		
		
	}
	
	static void bfs2(int[][] adjMatrix,int start) { //나와서 방문처리
		int v=adjMatrix.length;
		
		//1. 큐와 방문관리 배열 준비
		Queue<Integer> q=new ArrayDeque<>();
		boolean[] visited=new boolean[v];
		
		//2. 시작 정점(정점 start) 큐에 넣기
		q.offer(start); 
		
		//3. 큐로 방문관리
		while(!q.isEmpty()) {
			int current= q.poll(); //4. 탐색해야 하는 정점 꺼내기
			// 탐색 정점에 관련된 로직 처리
			visited[current]=true; //나와서 방문처리
			System.out.println((char)(current+65));
			// 5. 탐색정점의 주변 인접정점들 탐색될수 있도록 처리하기
			for(int i=0;i<v;i++) {
				if(adjMatrix[current][i] !=0 && !visited[i]) { //인접정점 체크, 방문여부 체크
					q.offer(i); 
					
				}
			}
			
			
		}
		
		
	}

}
