package ds;

public class A_BinarySearchTree_01 {

	static class Node {
		int data;
		int height;
		
		Node left;
		Node right;
		
		Node(int data, int height){
			this.data = data;
			this.height = height;
		}
	}
	
	private Node root;
	
	public Node search(int data) {
		return search(root, data);
	}
	
	public Node search(Node node, int data) {
		if(node == null) return null;
		if(data < node.data) return search(node.left, data);
		if(data > node.data) return search(node.right, data);
		return node;
	}
	
	public void insert(int data) {
		root = insert(root, data, -1);
	}
	
	public Node insert(Node parent, int data, int height) {
		height++;
		if(parent == null) {
			parent = new Node(data, height);
		}else {
			if(data <= parent.data) {
				parent.left = insert(parent.left, data, height);
			}else {
				parent.right = insert(parent.left, data, height);
			}
		}
		
		return parent;
	}
	
}
