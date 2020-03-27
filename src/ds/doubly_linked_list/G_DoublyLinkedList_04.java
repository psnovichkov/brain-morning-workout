package ds.doubly_linked_list;

import ds.node.DLNode;

public class G_DoublyLinkedList_04 {

    private DLNode first;
    private DLNode last;

    public boolean isEmpty(){
        return first == null;
    }

    public int peekFirst(){
        if(isEmpty()) throw new RuntimeException("DL is empty");
        return first.data;
    }

    public int peekLast(){
        if(isEmpty()) throw new RuntimeException("DL is emtpy");
        return last.data;
    }

    public void addFront(int val){
        DLNode node = new DLNode(val);
        if(isEmpty()){
            first = node;
            last = node;
        }
        else{
            node.next = first;
            first.prev = node;
            first = node;
        }

    }
    public void addLast(int val){
        DLNode node = new DLNode(val);
        if(isEmpty()){
            first = node;
            last = node;
        }
        else{
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    public int removeFirst(){
        int data = peekFirst();
        first.next.prev = null;
        first = first.next;
        return data;
    }

    public int removeLast(){
        int data = peekLast();
        last.prev.next = null;
        last = last.prev;
        return data;
    }


    public int peek(){return peekFirst();}

    public void add(int val){addLast(val);}

    public int remove(){return removeLast();}


}
