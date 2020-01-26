package ds;

import ds.node.Node;

/**
 * start 2:05
 * stop  2:10
 *
 * @author georgezakharov
 */


public class G_Queue_02 {

    Node top;
    Node bottom;


    public boolean isEmpty() {

        return top == null;
    }

    public int peek() {

        if (isEmpty()) throw new RuntimeException("Queue empty");

        else {
            return top.data;
        }
    }

    public int pop() {

        int data = top.data;

        if (top == bottom) {
            top = null;
            bottom = null;
        } else {

            top = top.next;
        }

        return data;
    }

    public void push(int data) {
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
