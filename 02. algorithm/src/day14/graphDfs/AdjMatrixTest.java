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
		

		
		boolean[] visited=new boolean[V];
		
		dfs(adjMatrix,visited,0);

	}
	


	
	
	static void dfs(int[][] adjMatrix, boolean[] visited,int current) { //탐색 정점 정보 매개변수로 받는다

		int v=adjMatrix.length;
		visited[current]=true;
		System.out.println((char)(current+65));
		for(int i=0;i<v;i++) {
			if(adjMatrix[current][i] !=0 && !visited[i]) { //인접정점 체크, 방문여부 체크
				
				dfs(adjMatrix,visited,i);
				
			}
		}
		
		
	}
		
}


