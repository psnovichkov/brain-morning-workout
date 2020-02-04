package ds;

import ds.node.Node;

/**
 * start 11:34
 * end   11:35:44
 * @author psnovichkov
 *
 */
public class P_Stack_03 {
	Node top;
	
	public boolean isEampty() {
		return top == null;
	}
	
	public int peek() {
		if(isEampty()) throw new RuntimeException("Stack is empty");
		return top.data;
	}
	
	public int pop() {
		int data = peek();
		top = top.next;
		return data;
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
}
