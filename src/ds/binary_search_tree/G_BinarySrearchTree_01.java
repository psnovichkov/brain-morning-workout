package ds.binary_search_tree;

public class G_BinarySrearchTree_01 {

    static class Node{
        int data;
        int height;
        Node left;
        Node right;

        Node(int data, int height){
            this.data = data;
            this.height = height;
        }
    }

    Node root;

    public G_BinarySrearchTree_01(){
        this.root = null;
    }

    public Node search(int data){
        return search(data);
    }

    private Node search(Node parent, int data){
        if (parent == null) return null;
        else if (data < parent.data) return search(parent.left, data);
        else if (data > parent.data) return search(parent.right, data);
        return parent;
    }



    public void insert(int data){
        root = insert(root, data, 0);
    }

    private Node insert(Node parent, int data, int height){

        height ++;

        if(parent == null){
            parent = new Node(data, height);
        }
        else{
            if(data <= parent.data){
                parent.left = insert(parent, data, height);
            }
            else{
                parent.right = insert(parent, data, height);
            }
        }
        return parent;

    }



}
