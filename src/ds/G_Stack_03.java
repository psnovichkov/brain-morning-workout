package ds;

import ds.node.Node;

/**
 * start :
 * end   :
 *
 * @author georgezakharov
 */


public class G_Stack_03 {

    Node top;


    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {

        if (isEmpty())
            throw new RuntimeException("Stack empty");

        return top.data;
    }

    public int pop() {

        int data = peek();

        if (top.next == null) {

            top = null;
        } else {

            top = top.next;
        }

        return data;
    }

    public void push(int data) {

        Node node = new Node(data);

        if (isEmpty()) {
            top = node;
        } else {
            top.next = top;
            top = node;
        }
    }


}
