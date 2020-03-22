package ds.binary_search_tree;

/**
 * Start  7:29
 * End    7:34:06
 * @author psnovichkov
 *
 */
public class P_BinarySearchTree_01 {

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
	
	public void insert(int data) {
		root = insert(root, data);
	}
	
	private Node search(Node parent, int data) {
		if(parent == null) return null;
		if(data < parent.data ) return search(parent.left, data);
		if(data > parent.data ) return search(parent.right, data);
		return parent;
	}
	
	private Node insert(Node parent, int data) {
		if(parent == null) {
			return new Node(data);			
		} 
			
		if(parent.data <= data) {
			parent.left = insert(parent.left, data);
		} else {
			parent.right = insert(parent.right, data);
		}
		return parent;
	}
}
