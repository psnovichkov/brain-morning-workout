package ds;

import ds.node.Node;

/**
 * start : 12:32
 * end   : 12:36
 *
 * @author georgezakharov
 */


public class G_Queue_03 {

    Node top;
    Node bottom;


    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {

        if (isEmpty()) throw new RuntimeException("Queue Empty");

        return top.data;
    }

    public int remove() {

        int data = peek();

        if (top == bottom) {

            top = null;
            bottom = null;
        } else {
            top = top.next;
        }

        return data;
    }

    public void add(int data) {

        Node node = new Node(data);

        if (isEmpty()) {
            top = node;
            bottom = node;
        } else {
            bottom.next = node;
            bottom = node;
        }

    }

}
