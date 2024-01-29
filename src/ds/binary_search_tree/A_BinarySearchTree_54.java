package ds.binary_search_tree;

public class A_BinarySearchTree_54 {

    static class Node{
        int data;

        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public Node search(int data) {
        return search(root, data);
    }

    private Node search(Node node, int data) {
        if(node == null) return null;
        if(node.data < data) return search(node.left, data);
        if(node.data > data) return search(node.right, data);
        return node;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (node.data < data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

}