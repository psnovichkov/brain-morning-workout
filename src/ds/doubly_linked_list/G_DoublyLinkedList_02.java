package src.ds.doubly_linked_list;

import ds.node.DLNode;


/**
 *
 * time: 7:24
 *
 * @author georgezakharov
 */
public class G_DoublyLinkedList_02 {


    DLNode first;
    DLNode last;


    public boolean isEmpty() {

        return first == null;
    }


    public int peekFirst() {

        if (isEmpty()) throw new RuntimeException("DL is empty");

        return first.data;


    }

    public int peekLast() {

        if (isEmpty()) throw new RuntimeException("DL is empty");

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


}
