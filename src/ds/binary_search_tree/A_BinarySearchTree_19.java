package ds.binary_search_tree;

public class A_BinarySearchTree_19 {

	static class Node{
		int height;
		int data;
		
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
	
	private Node search(Node node, int data) {
		if(node == null) return null;
		if(data < node.data) return search(node.left, data);
		if(data > node.data) return search(node.right, data);
		return node;
	}
	
	public void insert(int data) {
		root = insert(root, data, -1);
	}
	
	private Node insert(Node node, int data, int height) {
		height++;
		if(node == null) {
			node = new Node(data, height);
		}else {
			if(data <= node.data) {
				node.left = insert(node.left, data, height);
			}else {
				node.right = insert(node.right, data, height);
			}
		}
		return node;
	}
	
	
	
}
