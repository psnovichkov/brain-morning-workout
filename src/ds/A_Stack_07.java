package ds;

import ds.node.Node;

public class A_Stack_07 {
	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		return top.data;
	}
	
	public void push(int val) {
		Node node = new Node(val);
		node.next = top;
		top = node;
	}
	
	public int pop() {
		int val = top.data;
		top = top.next;
		return val;
	}

}
