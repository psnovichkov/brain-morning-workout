package ds;


import ds.node.DLNode;

/**
 * time: 9:21
 *
 * @author georgezakharov
 */

public class G_DoublyLinkedList_01 {


    DLNode first;
    DLNode last;


    public boolean isEmpty() {
        return first == null;
    }

    public int peekFirst() {

        if (isEmpty()) throw new RuntimeException("Doubly LinkedList Empty");
        return first.data;
    }

    public int peekLast() {

        if (isEmpty()) throw new RuntimeException("Doubly LinkedList Empty");
        return last.data;
    }

    public int removeFirst() {

        int data = peekFirst();

        if (first.next == null) {
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

        if (first.next == null) {
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

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    public void addLast(int data) {

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


    public int peek() {
        return peekFirst();
    }

    public void add(int data) {
        addFirst(data);
    }

    public int remove() {
        return removeLast();
    }


}
