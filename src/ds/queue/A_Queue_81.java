package ds.queue;

import ds.node.Node;

public class A_Queue_81 {

    Node top;
    Node bottom;

    public boolean isEmpty(){
        return top == null;
    }

    public int peek(){
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return top.data;
    }

    public void add(int v){
        Node node = new Node(v);
        if (isEmpty()) {
            top = node;
            bottom = node;
        } else {
            bottom.next = node;
            bottom = node;
        }
    }

    public int remove(){
        int v = peek();
        if (top == bottom) {
            top = null;
            bottom = null;
        } else {
            top = top.next;
        }
        return v;
    }

}
