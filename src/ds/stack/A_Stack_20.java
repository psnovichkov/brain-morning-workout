package src.ds.stack;

import ds.node.Node;

// 0:49

public class A_Stack_20 {

	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("stack is empty");
		return top.data;
	}
	
	public int pop() {
		int v = peek();
		top = top.next;
		return v;
	}
	
	public void push(int v) {
		Node node = new Node(v);
		node.next = top;
		top = node;
	}
	
}
