package ds;

import ds.node.Node;

/**
 * start  11:01
 * end    10:08
 * @author Elena Novichkova
 *
 */

public class E_Queue_01 {
    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public int peek(){
        if(isEmpty())
            throw new RuntimeException("queue is empty");
        int data = first.data;
        return data;
    }

    public int remove(){
        int data = peek();
        if(last == first){
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return data;
    }

    public void add(int data){
        Node node = new Node(data);
        if(isEmpty()){
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }
}
