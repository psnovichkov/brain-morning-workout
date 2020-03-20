package ds.queue;

// 1:27

import ds.node.Node;

public class A_Queue_19 {

	Node top;
	Node bottom;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Queue is emoty");
		return top.data;
	}
	
	public int remove() {
		int v = peek();
		if(top == bottom) {
			top = null;
			bottom = null;
		}else {
			top = top.next;
		}
		return v;
	}
	
	public void add(int v) {
		Node node = new Node(v);
		if(isEmpty()) {
			top = node;
			bottom = node;
		}else {
			bottom.next = node;
			bottom = node;
		}
	}
	
	
}
