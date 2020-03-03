package src.ds.stack;

import ds.node.Node;

// Time: 0:50

public class A_Stack_27 {

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
	
	public void add(int v) {
		Node node = new Node(v);
		node.next = top;
		top = node;
	}
	
}
