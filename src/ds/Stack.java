package ds;

import ds.node.Node;

/**
 * 
 * @author psnovichkov
 *
 */
public class Stack {
	Node top;
		
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if(top == null) throw new RuntimeException("Stack is empty");
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
