package ds.doubly_linked_list;

public class G_DoublyLinkedList_13 {


    static class DLNode {
        DLNode next;
        DLNode prev;
        int data;

        DLNode(int data) {
            this.data = data;
        }
    }

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

    public void insertFirst(int val) {
        DLNode node = new DLNode(val);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    public void insertLast(int val) {
        DLNode node = new DLNode(val);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    public int peek() {
        return peekFirst();
    }

    public int remove() {
        return removeFirst();
    }

    public void insert(int val) {
        insertLast(val);
    }
}
