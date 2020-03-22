package ds;

/**
 * 
 * @author psnovichkov
 *
 */
public class BinarySearchTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	private Node root;
		
	public Node search(int data) {
		return search(root, data);
	}
	
	private Node search(Node node, int data) {
		if(node == null) return null;
		if(data <  node.data) return search(node.left, data);
		if(data >  node.data) return search(node.right, data);
		return node;		
	}
	

	
	public void insert(int data) {
		root = insert(root, data);
	}
	
	private Node insert(Node parent, int data) {
		if(parent == null) {
			parent = new Node(data);
		} else {
			if(data <= parent.data) {
				parent.left = insert(parent.left, data);
			} else {
				parent.right = insert(parent.right, data);				
			}
		}
		return parent;
	}

		
}
