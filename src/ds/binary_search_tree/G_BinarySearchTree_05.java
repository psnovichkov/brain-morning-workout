package ds.binary_search_tree;


/**
 *
 *
 * time : 4:06! :)
 *
 * @author georgezakharov
 */

public class G_BinarySearchTree_05 {

    static class Node {
        int data;

        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    Node root;

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

    private Node search(Node par, int data) {

        if (par == null) return null;

        else if (data < par.data) return search(par.left, data);
        else if (data > par.data) return search(par.right, data);

        return par;


    }


}

