package ds.stack;

import ds.node.Node;

public class G_Stack_04 {

    Node top;


    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {

        if (isEmpty()) throw new RuntimeException("Stack Empty");
        return top.data;

    }

    public int pop() {

        int data = peek();
        top = top.next;
        return data;
    }

    public void push(int data) {

        Node node = new Node(data);
        node.next = top;
        top = node;
    }


}
