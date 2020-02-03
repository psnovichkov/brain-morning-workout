package ds;

import ds.node.Node;

/**
 * Start  7:52
 * End    7:56:30
 * @author psnovichkov
 *
 */
public class P_Queue_01 {

	Node first;
	Node last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
	public int peek() {
		if( isEmpty() ) {
			throw new RuntimeException("Queue is empty");
		}
		return last.data;
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
