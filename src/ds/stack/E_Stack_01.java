package src.ds.stack;

import ds.node.Node;

/**
 * start  10:20
 * end    10:31
 * @author Elena Novichkova
 *
 */

public class E_Stack_01 {
    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if( isEmpty() ) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public int poll() {
        int data = peek();
        top = top.next;
        return data;
    }

    public void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }
}
