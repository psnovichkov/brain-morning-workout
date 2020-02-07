package ds;

import ds.node.Node;

public class A_Stack_03 {
	
	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("stack is empty"); 
		return top.data;
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}
	
	public int pop() {
		int out = top.data;
		top = top.next;
		return out;
	}
	

}
