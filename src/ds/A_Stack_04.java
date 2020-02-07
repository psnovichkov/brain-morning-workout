package ds;

import ds.node.Node;
public class A_Stack_04 {

	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Stack empty");
		return top.data;
	}
	
	public int pop() {
		int out = peek();
		top = top.next;
		return out;
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}
	
}
