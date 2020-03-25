package ds.binary_search_tree;

/**
 * Start 7:53
 * End   7:56:53
 * @author psnovichkov
 *
 */
public class P_BinarySearchTree_02 {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	private Node root;
	
	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if(node == null) {
			return new Node(data);
		}
		if(data <= node.data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	public Node search(int data) {
		return search(root, data);
	}
	
	private Node search(Node node, int data) {
		if(node == null) return null;
		if(data < node.data) return search(node.left, data);
		if(data > node.data) return search(node.right, data);
		return node;
	}
}
