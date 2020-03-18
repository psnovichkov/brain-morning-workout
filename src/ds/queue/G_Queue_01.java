package ds.queue;

import ds.node.Node;

public class G_Queue_01 {

    /**
     * start 12:37
     * end   12:46
     *
     * @author georgezakharov
     */


    Node first;


    boolean isEmpty() {
        return first == null;
    }


    int pop() {

        // if queue is empty
        if (isEmpty()) throw new RuntimeException("queue is empty");

        Node current = first;
        Node previous = first;
        // If queue has one element

        while (current.next != null) {

            previous = current;
            current = current.next;
        }

        previous.next = null;
        return current.data;
    }

    void push(int val) {

        Node node = new Node(val);


        // if originally empty
        if (isEmpty()) first = node;

        node.next = first;
        first = node;

    }

}
