package day5.stack_queue;

import java.util.Stack;

public class StackAPITest {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		System.out.println(stack.isEmpty()+" // "+stack.size());
		stack.push("김지온");
		stack.push("정동화");
		stack.push("박정원");
		stack.push("박상혁");
		stack.push("김종구");
		System.out.println(stack.isEmpty()+" // "+stack.size());
		stack.push("정휘");
		System.out.println(stack.peek()); //return만 원소 유지
		System.out.println(stack.isEmpty()+" // "+stack.size());
		System.out.println(stack.pop()); //return하고 원소 삭제
		System.out.println(stack.isEmpty()+" // "+stack.size());
		System.out.println(stack.peek()); //return만 원소 유지
		System.out.println(stack.isEmpty()+" // "+stack.size());
		System.out.println();
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
