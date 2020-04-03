package ds.binary_search_tree;

public class G_BinarySearchTree_06 {

    static class Node{
        int val;

        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    Node root;

    public void insert(int val){

        root = insert(root, val);
    }

    private Node insert(Node par, int val){
        if(par == null) par = new Node(val);
        else if(val < par.val) par.left = insert(par.left, val);
        else if(val > par.val) par.right = insert(par.right, val);

        return par;
    }


    public Node search(int val){
        return search(root, val);
    }

    private Node search(Node par, int val){

        if(par == null) return null;
        else if (val < par.val) return search(par.left, val);
        else if (val > par.val) return search(par.right, val);

        return par;
    }

}
