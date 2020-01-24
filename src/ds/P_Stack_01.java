package ds;

import ds.node.Node;

/**
 * start  6:44
 * end    6:47:01
 * @author psnovichkov
 *
 */

public class P_Stack_01 {
	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if( isEmpty() ) {
			throw new RuntimeException("Stack is empty");
		}
		return top.data;
	}
	
	public int poll() {
		int data = peek();
		top = top.next;
		return data;
	}
	
	public void push(int value) {
		Node node = new Node(value);
		node.next = top;
		top = node;
	}

}
