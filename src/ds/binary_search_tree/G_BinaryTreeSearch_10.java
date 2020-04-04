package ds.binary_search_tree;

public class G_BinaryTreeSearch_10 {

    static class Node{
        int val;

        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    private Node root;

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

        return val < par.val ? search(par.left, val) : val > par.val ? search(par.right, val) : par;

    }
}
