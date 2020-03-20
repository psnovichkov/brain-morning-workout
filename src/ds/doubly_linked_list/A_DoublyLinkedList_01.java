package ds.doubly_linked_list;

import ds.node.DLNode;

public class A_DoublyLinkedList_01 {

	DLNode head;
	DLNode tail;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int peekHead() {
		if(isEmpty()) throw new RuntimeException("linked list is empty");
		return head.data;
	}
	
	public int peekTail() {
		if(isEmpty()) throw new RuntimeException("Linked list is empty");
		return tail.data;
	}
	
	public void addHead(int v) {
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
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}
	
	public int removeFirst() {
		int v = head.data;
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
		int v = tail.data;
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
		return peekHead();
	}
	
	public void add(int v) {
		addLast(v);
	}
	
	public int remove() {
		return removeLast();
	}
	
	
	
}
