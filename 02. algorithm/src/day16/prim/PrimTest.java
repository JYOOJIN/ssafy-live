package day16.prim;

import java.io.*;
import java.util.*;

public class PrimTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V=Integer.parseInt(br.readLine()); //정점의 개수
		
		int[][] adjMatrix=new int[V][V]; //인접행렬
		boolean[] visited=new boolean[V]; //트리 정점 여부
		int[] minEdge=new int[V]; //비트리정점 기준으로 트리 정점들과 연결했을 경우 최소간선비용
		
		//인접행렬 값 입력받기
		for(int i=0;i<V;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<V;j++) {
				adjMatrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); //최솟값 갱신을 위해 max로 초기화
		
		minEdge[0]=0; //임의의 시작점 0을 위해 처리
		int result=0; //최소신장트리 비용
		int i;
		
		for(i=0;i<V;i++){ //정점만큼 반복
			
			//step1. 비트리 정점 중 최소간선비용의 정점 찾기
			int min=Integer.MAX_VALUE;
			int minVertex=-1;
			
			for(int j=0;j<V;j++) {
				if(!visited[j] && minEdge[j]<min) { //비트리정점이면서 
					min=minEdge[j];
					minVertex=j;
				}
			}
			
			if(minVertex==-1) break;
			
			result+=min; //간선 비용 누적
			visited[minVertex]=true; //트리 정점에 포함
			
			//step2. 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점ㄷ들과의 간선 비용 고려 최적 업데이트
			//minEdge 갱신만 하지, 트리 정점으로 확정짓는 거 아니다.
			for(int j=0;j<V;j++) {
				if(!visited[j] && adjMatrix[minVertex][j] != 0 && adjMatrix[minVertex][j] < minEdge[j]) {
					minEdge[j]=adjMatrix[minVertex][j];
				}
			}

		}
		
		System.out.println(i==V?result:-1); //모든 정점을 돌았다면 result, 아니라면 -1

	}

}
