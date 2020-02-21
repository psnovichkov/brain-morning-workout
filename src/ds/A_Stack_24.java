package ds;

import ds.node.Node;

// Time: 0:54

public class A_Stack_24 {

	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Stack is emptu");
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
