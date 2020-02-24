package ds;

import ds.node.DLNode;

/**
 * 
 * Start 3:00
 * End   3:06:48
 * 
 * @author psnovichkov
 *
 */
public class P_DoublyLinkedList_01 {

	private DLNode first;
	private DLNode last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int peekFirst() {
		if(isEmpty()) throw new RuntimeException("Empty");
		return first.data;
	}
	
	public int peekLast() {
		if(isEmpty()) throw new RuntimeException("Empty");
		return last.data;
	}
	
	public int removeFirst() {
		int data = peekFirst();
		if(first == last) {
			first = null;
			last = null;
		} else {
			first.next.prev = null;
			first = first.next;
		}
		return data;
	}
	
	public int removeLast() {
		int data = peekLast();
		if(first == last) {
			first = null;
			last = null;
		} else {
			last.prev.next = null;
			last = last.prev;
		}
		return data;
	}
	
	public void addFirst(int data) {
		DLNode node = new DLNode(data);
		if(isEmpty()) {
			first = node;
			last = node;
		} else {
			first.next.prev = node;
			node.next = first;
			first = node;
		}
	}
	
	public void addLast(int data) {
		DLNode node = new DLNode(data);
		if(isEmpty()) {
			first = node;
			last = node;
		} else {
			last.prev.next = node;
			node.prev = last;
			last = node;
		}
	}
	
	public int peek() {
		return peekFirst();
	}
	
	public int remove() {
		return removeLast();
	}
	
	public void add(int data) {
		addLast(data);
	}
}

