package ds.stack;

import ds.node.Node;

public class A_Stack_06 {

	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		return top.data;
	}
	
	public int pop() {
		int out = top.data;
		top = top.next;
		return out;
	}
	
	public void push(int value) {
		Node node = new Node(value);
		node.next = top;
		top = node;
	}
	
}
