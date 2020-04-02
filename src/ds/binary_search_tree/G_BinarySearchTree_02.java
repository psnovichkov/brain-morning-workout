package ds.binary_search_tree;

public class G_BinarySearchTree_02 {

    static class Node {
        int height;
        int value;
        Node left;
        Node right;

        Node(int value, int height) {
            this.value = value;
            this.height = height;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    Node root;


    G_BinarySearchTree_02() {
        this.root = null;
    }

    public Node search(int data) {

        return search(root, data);
    }

    private Node search(Node parent, int data) {
        if (parent == null) return null;
        if (data == parent.value) {
            return parent;
        }
        if (data < parent.value) return search(parent.left, data);
        return search(parent.right, data);

    }


    public void insert(int data) {
        // Why root = insert?
        root = insert(root, data, 0);
    }

    private Node insert(Node parent, int data, int height) {


        if (parent == null) parent = new Node(data, ++height);
        else if (data < parent.value) parent.left = insert(parent.left, data, ++height);
        else if (data > parent.value) parent.right = insert(parent.right, data, ++height);

        return parent;
    }

    public static void main(String[] args) {

        G_BinarySearchTree_02 tree = new G_BinarySearchTree_02();

        tree.insert(3);
        tree.insert(1);
        tree.insert(5);
        tree.insert(2);

        System.out.println(tree.search(3));
    }

}
