package src.ds.stack;

import ds.node.Node;

/**
 * start : 12:28
 * end   : 12:31
 *
 * @author georgezakharov
 */


public class G_Stack_02 {

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

        if (top.next == null) {

            top = null;
        } else {
            top = top.next;
        }

        return data;
    }

    public void push(int data){
        Node node = new Node(data);

        if(isEmpty()){
            top = node;
        }
        else{

            top.next = top;
            top = node;
        }

    }


}
