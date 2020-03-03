package ds;

import ds.node.DLNode;

public class DoublyLinkedList {
	DLNode first;
	DLNode last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int peekFirst() {
		if(isEmpty()) throw new RuntimeException("LinkedList is empty");
		return first.data;
	}
	
	public int peekLast() {
		if(isEmpty()) throw new RuntimeException("LinkedList is empty");
		return last.data;
	}
	
	
	public void addFirst(int data) {
		DLNode node = new DLNode(data);
		if(isEmpty()) {			
			first = node;
			last = node;
		} else {
			first.prev = node;
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
			last.next = node;
			node.prev = last;
			last = node;
		}
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
	
		
	public int peek() {
		return peekFirst();
	}

	public void add(int data) {
		addLast(data);
	}
	
	public int remove() {
		return removeLast();
	}	

}
