package ds.stack;

import ds.node.Node;

public class A_Stack_83 {

    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public void push(int v) {
        Node node = new Node(v);
        node.next = top;
        top = node;
    }

    public int pop() {
        int v = peek();
        top = top.next;
        return v;
    }

}
