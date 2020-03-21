package ds.stack;

import ds.node.Node;

public class A_Stack_54 {

	public Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
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
