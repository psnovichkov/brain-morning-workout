package ds;

import ds.node.Node;

public class J_Stack_00 {

    Node top;

    public void push(int data) {
        Node node = new Node(data);

        if (top == null) {
            top = node;
            return;
        }


        node.next = top;
        top = node;


    }

    public int pop() throws Exception{
        Node node;

        if (top == null){
            throw new Exception("The Stack is Empty");
        }

        node = top;
        top = top.next;

        return node.data;

    }

    public int peek(){
        return top.data;
    }
}
