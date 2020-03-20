package ds.stack;

import ds.node.Node;

/**
 * Start 2:29
 * End   2:31:13
 * @author psnovichkov
 *
 */
public class P_Stack_05 {

	private Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peak() {
		if( isEmpty() ) throw new RuntimeException("Stack is empty");
		return top.data;
	}
	
	public int pop() {
		int data = peak();
		top = top.next;
		return data;
	}
	
	public void put(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
}
