package ds.trie;

public class G_Trie_11 {

    private static final int FIRST = 'a';
    private static final int LAST = 'z';
    private static final int RANGE = LAST - FIRST + 1;


    static class Node {
        boolean isWord;
        Node[] choldren;
    }

    Node root = new Node();

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - FIRST;
            if (node.choldren == null) node.choldren = new Node[RANGE];
            if (node.choldren[index] == null) node.choldren[index] = new Node();
            node = node.choldren[index];
        }
        node.isWord = true;
    }


    public boolean contains(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - FIRST;
            if (node.choldren == null) return false;
            if (node.choldren[index] == null) return false;
            node = node.choldren[index];
        }
        return node.isWord;
    }
}
