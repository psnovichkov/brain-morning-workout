package ds.binary_search_tree;

public class G_BinarySearchTree_11 {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int val) {
            this.data = val;
        }
    }


    Node root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node par, int val) {
        if (par == null) par = new Node(val);
        else if (val < par.data) par.left = insert(par.left, val);
        else if (val > par.data) par.right = insert(par.right, val);
        return par;
    }

    public Node get(int val) {
        return get(root, val);
    }

    private Node get(Node par, int val) {
        if (par == null) return null;
        else if (val < par.data) return get(par.left, val);
        else if (val > par.data) return get(par.right, val);
        return par;
    }
}
