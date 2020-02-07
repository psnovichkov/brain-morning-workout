package ds;


import ds.node.Node;


/**
 *
 * time: 3:22
 *
 * @author georgezakharov
 */

public class G_Queue_04 {

    Node first;
    Node last;


    public boolean isEmpty() {
        return first == null;
    }


    public int peek() {

        if (isEmpty()) throw new RuntimeException("Queue is Empty");

        return first.data;
    }

    public int remove() {

        int data = first.data;

        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return data;
    }

    public void add(int data) {
        Node node = new Node(data);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

    }


}
