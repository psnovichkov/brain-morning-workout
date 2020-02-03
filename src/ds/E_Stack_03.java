package ds;

import ds.node.Node;

/**
 * start  10:47
 * end    10:50
 * @author Elena Novichkova
 *
 */

public class E_Stack_03 {
    private Node top;

    public boolean isEmpty(){
        return top == null;
    }

    public int peek(){
        if(isEmpty())
            throw new RuntimeException("stack is empty");
        return top.data;
    }

    public int poll(){
        int data = top.data;
        top = top.next;
        return data;
    }

    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top= node;
    }
}
