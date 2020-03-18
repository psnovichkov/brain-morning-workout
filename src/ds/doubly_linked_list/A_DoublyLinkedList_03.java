package ds.doubly_linked_list;

import ds.node.DLNode;

// 3:28

public class A_DoublyLinkedList_03 {

	DLNode head;
	DLNode tail;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int peekFirst() {
		if(isEmpty()) throw new RuntimeException("Linked list is empty");
		return head.data;
	}
	
	public int peekLast() {
		if(isEmpty()) throw new RuntimeException("Linked list is empty");
		return tail.data;
	}
	
	public void addFirst(int v) {
		DLNode node = new DLNode(v);
		
		if(isEmpty()) {
			head = node;
			tail = node;
		}else {
			head.prev = node;
			node.next = head;
			head = node;
		}
	}
	
	public void addLast(int v) {
		DLNode node = new DLNode(v);
		
		if(isEmpty()) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}
	
	public int removeFirst() {
		int v = peekFirst();
		
		if(head == tail) {
			head = null;
			tail = null;
		}else {
			head.next.prev = null;
			head = head.next;
		}
		return v;
	}
	
	public int removeLast() {
		int v = peekLast();
		
		if(head == tail) {
			head = null;
			tail = null;
		}else {
			tail.prev.next = null;
			tail = tail.prev;
		}
		return v;
	}
	
	public int peek() {
		return peekFirst();
	}
	
	public void add(int v) {
		addLast(v);
	}
	
	public int remove() {
		return removeLast();
	}
	
	
	
}
