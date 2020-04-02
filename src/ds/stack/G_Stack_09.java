package ds.stack;

import ds.node.Node;

public class G_Stack_09 {
    Node top;

    public boolean isEmety(){
        return top == null;
    }

    public int peek(){
        if(isEmety()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public int pop(){
        int data = peek();
        top = top.next;
        return data;
    }

    public void push(int v){
        Node node = new Node(v);
        node.next = top;
        top = node;
    }

}

