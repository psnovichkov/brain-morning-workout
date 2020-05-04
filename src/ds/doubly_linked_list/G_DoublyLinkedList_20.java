package ds.doubly_linked_list;

import ds.node.DLNode;

public class G_DoublyLinkedList_20 {

    DLNode first;
    DLNode last;

    public boolean isEmpty() {
        return first == null;
    }


    public int peekFirst() {
        if (isEmpty()) throw new RuntimeException("DLL empty");
        return first.data;
    }

    public int peekLast() {
        if (isEmpty()) throw new RuntimeException("DLL empty");
        return last.data;
    }

    public int removeFirst() {
        int data = peekFirst();
        if (first == last) {
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
        if (first == last) {
            first = null;
            last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
        return data;
    }

    public void insertFirst(int data) {
        DLNode node = new DLNode(data);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    public void insertLast(int data) {
        DLNode node = new DLNode(data);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
        }
    }


}
