package ds.doubly_linked_list;

import ds.doubly_linked_list.G_DoublyLinkedList_11.DLNode;

public class A_DoublyLinkedList_54 {

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
			node.prev = head;
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
	
	public int remove() {
		return removeFirst();
	}
	
	public void add(int v) {
		addLast(v);
	}
}
