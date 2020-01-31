package ds;

import ds.node.Node;

public class A_Queue_01 {

	Node top;
	Node bottom;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Queue is empty"); 
		return top.data;
	}
	
	public int remove() {
		int output = peek();
		if(top == bottom) {
			top = null;
			bottom = null;
		}else {
			top = top.next;
		}
		
		return output;
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		if(isEmpty()) {
			top = newNode;
			bottom = newNode;
		}else {
			bottom.next = newNode;
			bottom = newNode;
		}
	}
	
}
