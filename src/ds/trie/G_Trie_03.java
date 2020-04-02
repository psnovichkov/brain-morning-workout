package ds.trie;

public class G_Trie_03 {

    private static final int first = 'a';
    private static final int last = 'z';
    private static final int range = last - first + 1;

    static class Node{
        boolean isWord;
        Node[] children;
    }

    Node root = new Node();

    public void insert(String word){
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c - first;
            if(node.children == null) node.children = new Node[range];
            if(node.children[index] == null) node.children[index] = new Node();
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean contains(String word){
        Node node = root;
        for(char c : word.toCharArray()) {
            int index = c - first;
            if(node.children == null) return false;
            if(node.children[index] == null ) return false;
            node = node.children[index];
        }
        return node.isWord;
    }
}
