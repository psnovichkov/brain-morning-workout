package ds.binary_search_tree;

public class G_BinarySearchTree_03 {

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

    G_BinarySearchTree_03(){
        this.root = null;
    }


    public void insert(int data){
        root = insert(root, data, 0);
    }


    private Node insert(Node parent, int data, int height){

        if(parent == null) parent = new Node(data, ++height);
        else if(data < parent.val) parent.left = insert(parent.left, data, ++height);
        else if(data > parent.val) parent.right = insert(parent.right, data, ++height);

        return parent;
    }


    public Node search(int data){
        return search(root, data);
    }

    private Node search(Node parent, int data){

        if (parent == null) return null;
        else if(data < parent.val) return search(parent.left, data);
        else if(data > parent.val) return search(parent.right, data);
        return parent;
    }

}
