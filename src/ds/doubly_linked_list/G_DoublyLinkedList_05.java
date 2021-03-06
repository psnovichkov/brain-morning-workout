package ds.doubly_linked_list;


import ds.node.DLNode;

public class G_DoublyLinkedList_05 {

    private DLNode first;
    private DLNode last;


    public boolean isEmpty(){
        return first == null;
    }

    public int peekFirst() {
        if (isEmpty()) throw new RuntimeException("DLL is empty");
        return first.data;
    }

    public int peekLast(){
        if (isEmpty()) throw new RuntimeException("DLL is empty");
        return last.data;
    }

    public void addFist(int val){
        DLNode node = new DLNode(val);
        if(isEmpty()){
            first = node;
            last = node;
        }
        else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    public void addLast(int val){
        DLNode node = new DLNode(val);
        if(isEmpty()) {
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
        if(first == last){
            first = null;
            last = null;
        }
        else{
            first.next.prev = null;
            first = first.next;
        }
        return data;
    }

    public int removeLast(){
        int data = peekLast();
        if (first == last){
            first = null;
            last = null;
        }
        else{
            last.prev.next = null;
            last = last.prev;
        }
        return data;
    }

    public int peek(){
        return peekFirst();
    }

    public int remove(){
        return removeFirst();
    }

    public void add(int val){
        addLast(val);
    }



}
