package ds.stack;


import ds.node.Node;

public class G_Stack_10 {

    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack empty");
        return top.data;
    }

    public int pop() {
        int data = peek();
        top = top.next;
        return data;
    }

    public void push(int val) {
        Node node = new Node(val);
        node.next = top;
        top = node;
    }
}
