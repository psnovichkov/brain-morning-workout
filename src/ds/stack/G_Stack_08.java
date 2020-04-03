package ds.stack;

import ds.node.Node;

public class G_Stack_08 {
    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is Empty");
        return top.data;
    }

    public int pop() {
        int data = peek();
        top = top.next;
        return data;
    }

    public void push(int v) {
        Node node = new Node(v);
        node.next = top;
        top = node;
    }
}
