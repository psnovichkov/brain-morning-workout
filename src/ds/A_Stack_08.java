package ds;

import ds.node.Node;

public class A_Stack_08 {
	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		return top.data;
		
	}
	
	public int pop() {
		int val = peek();
		top = top.next;
		return val;
	}
	
	public void push(int val) {
		Node node = new Node(val);
		node.next = top;
		top = node;
	}
}
