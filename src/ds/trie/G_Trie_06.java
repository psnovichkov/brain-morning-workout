package ds.trie;

public class G_Trie_06 {


    private static final int FIRST = 'a';
    private static final int LAST = 'z';
    private static final int RANGE = LAST - FIRST + 1;

    static class Node {
        boolean isWord;
        Node[] children;
    }

    Node root = new Node();


    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - FIRST;
            if (node.children == null) node.children = new Node[RANGE];
            if (node.children[index] == null) node.children[index] = new Node();
            node = node.children[index];
        }
        node.isWord = true;
    }


    public boolean contains(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - FIRST;
            if (node.children == null) return false;
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isWord;
    }

}
