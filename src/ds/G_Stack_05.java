package ds;

import ds.node.Node;

/**
 * time : 3:47
 *
 * @author georgezakharov
 */

public class G_Stack_05 {

    Node top;


    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is Empty");

        return top.data;
    }

    public int remove() {

        int data = top.data;

        top = top.next;
        return data;

    }

    public void add(int data) {

        Node node = new Node(data);

        node.next = top;
        top = node;

    }


}
