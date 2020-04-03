package ds.binary_search_tree;

public class G_BinarySearchTree_04 {


    static class Node{
        int height;
        int val;
        Node left;
        Node right;

        Node(int val, int height){
            this.val = val;
            this.height = height;
        }
    }


    Node root;

    G_BinarySearchTree_04 (){
        this.root = null;
    }


    public void insert(int data){
        root = insert(root, data, 0);
    }

    private Node insert(Node parent, int data, int height){

        if(parent == null) parent = new Node(data, ++height);
        else if(data < parent.val) parent.left = insert(parent.left, data,++ height);
        else if(data > parent.val) parent.right = insert(parent.right, data,++ height);

        return parent;
    }


    public Node search(int data){
        return search(root, data);
    }

    private Node search(Node par, int data){
        if(par == null) return  null;
        else if(data < par.val) search(par.left, data);
        else if(data > par.val) search (par.right, data);

        return par;
    }
}
