package src.ds.queue;

import ds.node.Node;

/**
 * Start  4:58 
 * End    5:01:13
 * @author psnovichkov
 *
 */
public class P_Queue_02 {
	
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
