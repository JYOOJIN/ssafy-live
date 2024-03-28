package day7.tree;

import java.util.ArrayDeque;
import java.util.Queue;

//완전 이진 트리 - 배열 구현
//크기 고정 버전
public class CompleteBinaryTree<T> { //어떤걸 저장할지 모르니까 generic

	private Object[] nodes;
	private final int SIZE;
	private int lastIndex; //마지막으로 저장된 노드의 인덱스
	
	
	public CompleteBinaryTree(int size) {
		SIZE=size;
		nodes=new Object[size+1]; //0인덱스 사용하지 않음
	}
	
	public boolean isEmpty() {
		return lastIndex == 0; //아직 아무것도 넣지 않았으면 empty
	}
	
	public boolean isFull() {
		return lastIndex==SIZE; //lastIndex가 size 만큼이면 full
	}
	
	public void add(T e) {
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		Queue<Integer> q=new ArrayDeque<>(); //노드 번호를 넣을 Queue
		q.offer(1); //방문할 노드를 관리할 값 넣기(노드 번호 인덱스)
		
		while(!q.isEmpty()) { //방문할 대상이 있는 동안 반복
			
			int current=q.poll();
			System.out.println(nodes[current]); //방문한 노드 처리
			
			//왼쪽 자식노드
			if(current*2<=lastIndex) {
				q.offer(current*2);
			}
			//오른쪽 자식노드
			if(current*2+1<=lastIndex) {
				q.offer(current*2+1);
			}
			
		}
		
	}
	
	public void bfs2() {
		
	}
	
	public void bsf3() {
		
	}
	
	//이 메소드를 public으로 풀어놓고 empty인지 체크
	public void dfsByPreorder() {
		if(isEmpty()) return;
		System.out.println("====preorder====");
		dfsByPreorder(1);
		System.out.println();
	}
	
	//전위 순회
	//private으로 감춰놓음
	private void dfsByPreorder(int current) {
		
		//방문한 노드 처리
		System.out.print(nodes[current]+" "); 
		
		//왼쪽 자식노드
		if(current*2<=lastIndex) {
			dfsByPreorder(current*2);
		}
		//오른쪽 자식노드
		if(current*2+1<=lastIndex) {
			dfsByPreorder(current*2+1);
		}
	}
	
	
	//이 메소드를 public으로 풀어놓고 empty인지 체크
	public void dfsByInorder() {
		if(isEmpty()) return;
		System.out.println("====inorder====");
		dfsByInorder(1);
		System.out.println();
	}
	
	//중위 순회
	//private으로 감춰놓음
	private void dfsByInorder(int current) {
		
		
		//왼쪽 자식노드
		if(current*2<=lastIndex) {
			dfsByInorder(current*2);
		}
		
		//방문한 노드 처리
		System.out.print(nodes[current]+" "); 
		
		//오른쪽 자식노드
		if(current*2+1<=lastIndex) {
			dfsByInorder(current*2+1);
		}
	}
	
	//이 메소드를 public으로 풀어놓고 empty인지 체크
	public void dfsByPostorder() {
		if(isEmpty()) return;
		System.out.println("====postorder====");
		dfsByPostorder(1);
		System.out.println();
	}
	
	//중위 순회
	//private으로 감춰놓음
	private void dfsByPostorder(int current) {
		
		//기저조건. 한번더 타고 들어갔다 나오긴한다.
		if(current>lastIndex) return;
		
		//왼쪽 자식노드
		if(current*2<=lastIndex) {
			dfsByPostorder(current*2);
		}

		//오른쪽 자식노드
		if(current*2+1<=lastIndex) {
			dfsByPostorder(current*2+1);
		}
		
		//방문한 노드 처리
		System.out.print(nodes[current]+" "); 
	}
	

}
