package day15.MST;

import java.io.*;
import java.util.*;

public class MST_Test {
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight,o.weight); //오름차순
		}
		
	}

	static int V;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken()); //정점의 수
		int E=Integer.parseInt(st.nextToken()); //간선의 수
		edgeList=new Edge[E]; //간선 리스트
		
		for(int i=0;i<E;i++) { //간선 리스트에 값 입력받기
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken()); 
			int to=Integer.parseInt(st.nextToken()); 
			int weight=Integer.parseInt(st.nextToken()); 
			
			edgeList[i]=new Edge(from,to,weight); //무향 그래프지만 간선 리스트이기에 from/to 반전 필요 없다
		}
		
		//전처리: 간선리스트 오름차순 정렬
		Arrays.sort(edgeList);

		//1. make-set
		make();
		
		//2. 정렬된 간선 하나씩 꺼내어 신장트리 생성
		int weight=0;
		int cnt=0;
		
		for(Edge edge:edgeList) {
			if(!union(edge.from, edge.to)) continue; //사이클 발생
			weight+=edge.weight;
			if(++cnt==V-1) break; //최소신장트리를 만족하는 간선 선택 완료 -> 최소신장트리 완성
			
		}
		
		System.out.println(weight);
		

	}
	
	public static void make() {
		parents=new int[V]; //자신의 부모나 루트를 담는 배열(경로 압축으로 인해)
		for(int i=0;i<V;i++) {
			parents[i]=i; //모든 정점을 자신의 루트(대표자)로 설정
		}
	}
	
	public static int find(int a) { //a가 속한 트리의 루트 찾기
		if(a==parents[a]) return a;
		
		return parents[a]=find(parents[a]); //경로 압축
		
	}
	
	public static boolean union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return false; //a,b가 같은 트리에 존재한다 => union 불필요
		
		parents[bRoot]=aRoot; //대표자끼리 합친다
		return true;
	}

}







