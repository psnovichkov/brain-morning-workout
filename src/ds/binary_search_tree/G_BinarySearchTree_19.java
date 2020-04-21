package ds.binary_search_tree;

public class G_BinarySearchTree_19 {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node par, int data) {
        if (par == null) par = new Node(data);
        else if (data < par.data) par.left = insert(par.left, data);
        else if (data > par.data) par.right = insert(par.right, data);

        return par;
    }

    public Node search(int data) {
        return search(root, data);
    }

    private Node search(Node par, int val) {
        if (par == null) return null;
        else if (val < par.data) return search(par.left, val);
        else if (val > par.data) return search(par.right, val);

        return par;
    }

}
