package ds.stack;
import ds.node.Node;

public class A_Stack_01 {

	Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
		
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		return top.data;
	}
	
	public int poll() {
		int output = peek();
		top = top.next;
		return output;
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}
	
}
