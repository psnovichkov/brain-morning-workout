package ds.queue;

import ds.node.Node;

public class A_Queue_54 {

	Node top;
	Node bottom;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Queue is empty");
		return top.data;
	}
	
	public int pop() {
		int v = peek();
		if(top == bottom) {
			top = null;
			bottom = null;
		}else {
			top = top.next;
		}
		return v;
	}
	
	public void push(int v) {
		Node node = new Node(v);
		if(isEmpty()) {
			top = null;
			bottom = null;
		}else {
			bottom.next = node;
			bottom = node;
		}
	}
	
}
