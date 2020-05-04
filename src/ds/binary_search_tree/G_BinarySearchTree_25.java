package ds.binary_search_tree;

import ds.node.BTNode;

public class G_BinarySearchTree_25 {

    BTNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private BTNode insert(BTNode node, int data) {
        if (node == null) node = new BTNode(data);
        else if (data < node.data) node.left = insert(node.left, data);
        else if (data > node.data) node.right = insert(node.right, data);

        return node;
    }

    public BTNode search(int data) {
        return search(root, data);
    }

    private BTNode search(BTNode node, int data) {
        if (node == null) return null;
        else if (data < node.data) return search(node.left, data);
        else if (data > node.data) return search(node.right, data);
        return node;
    }

}
