package ds.queue;

import ds.node.Node;

/**
 * 
 * start 2:35
 * end   2:38:15
 * 
 * @author psnovichkov
 *
 */
public class P_Queue_03 {
	private Node first;
	private Node last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Queue is empty");		
		return first.data;
	}
	
	public int remove() {
		int data = peek();
		if(first == last) {
			first = null;
			last = null;
		} else {
			first = first.next;
		}
		return data;
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if(isEmpty()) {
			first = node;
			last = node;		 
		} else {
			last.next = node;
			last = node;
		}
	}
	
}
