package ds.stack;

import ds.node.Node;

/**
 * start 1:58
 * end   2:02
 *
 * @author georgezakharov
 */


public class G_Stack_01 {


    Node top;


    public boolean isEmpty() {

        return top == null;
    }

    public int peek() {

        if (isEmpty()) throw new RuntimeException("Stack empty");
        else {

            return top.data;
        }
    }


    public int remove() {

        int data = peek();

        if (top.next == null) {

            top = null;
        } else {

            top = top.next;
        }

        return data;
    }

    public void add(int data) {

        Node node = new Node(data);

        if (isEmpty()) {

            top = node;
        } else {

            top.next = top;
            top = node;
        }

    }

}
