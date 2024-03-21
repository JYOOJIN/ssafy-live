package day5.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueAPITest {

	public static void main(String[] args) {
		
		Queue<String> queue = new ArrayDeque<String>();
		System.out.println(queue.isEmpty()+" // "+queue.size());
		queue.offer("김지온");
		queue.offer("정동화");
		queue.offer("박정원");
		queue.offer("박상혁");
		queue.offer("김종구");
		System.out.println(queue.isEmpty()+" // "+queue.size());
		queue.offer("정휘");
		System.out.println(queue.peek()); //맨 앞 확인.return만 원소 유지
		System.out.println(queue.isEmpty()+" // "+queue.size());
		System.out.println(queue.poll()); //맨 앞 삭제.return하고 원소 삭제
		System.out.println(queue.isEmpty()+" // "+queue.size());
		System.out.println(queue.peek()); //맨 앞 확인.return만 원소 유지
		System.out.println(queue.isEmpty()+" // "+queue.size());
		System.out.println();
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

}
