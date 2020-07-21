package ds.queue;

import ds.node.Node;

public class A_Queue_86 {

    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return head.data;
    }

    public void add(int v) {
        Node node = new Node(v);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public int remove() {
        int v = peek();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return v;
    }
}
