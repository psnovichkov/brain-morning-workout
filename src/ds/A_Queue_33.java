package ds;

import ds.node.Node;

public class A_Queue_33 {

	Node top;
	Node bottom;
	
	public boolean isEmtpty() {
		return top == null;
	}
	
	public int peek() {
		if(isEmtpty()) throw new RuntimeException("Queue is emtpy");
		return top.data;
	}
	
	public int dequeue() {
		int v = peek();
		if(top == bottom) {
			top = null;
			bottom = null;
		}else {
			top = top.next;
		}
		return v;
	}
	
	public void enqueue(int v) {
		Node node = new Node(v);
		if(isEmtpty()) {
			top = node;
			bottom = node;
		}else {
			bottom.next = node;
			bottom = node;
		}
	}
	
}
