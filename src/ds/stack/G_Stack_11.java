package ds.stack;

import ds.node.Node;

public class G_Stack_11 {

    Node top;


    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public int remove() {
        int data = peek();
        top = top.next;
        return data;
    }

    public void insert(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }
}
