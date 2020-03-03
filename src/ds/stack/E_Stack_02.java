package src.ds.stack;

import ds.node.Node;

/**
 * start  10:39
 * end    10:42
 * @author Elena Novichkova
 *
 */

public class E_Stack_02 {
    Node top;
    public Boolean isEmpty(){
        return top == null;
    }

    public int peek(){
        if(isEmpty())
            throw new RuntimeException("stack is empty");
        return top.data;
    }

    public int poll(){
        int data = peek();
        top = top.next;
        return data;
    }

    public void push(int data){
        Node node = new Node(data);
        node.next  = top;
        top = node;
    }
}
