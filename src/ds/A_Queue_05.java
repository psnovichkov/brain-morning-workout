package ds;

import ds.node.Node;

// Time: 1:42

public class A_Queue_05 {

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
		int val = top.data;
		if(top == bottom) {
			top = null;
			bottom = null;
		}else {
			top = top.next;
		}
		return val;
	}
	
	public void add(int val) {
		Node node = new Node(val);
		if(isEmpty()) {
			top = node;
			bottom = node;
		}else {
			bottom.next = node;
			bottom = node;
		}
	}
	
}
