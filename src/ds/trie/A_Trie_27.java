package ds.trie;

public class A_Trie_27 {

    private final static int MIN_INDEX = 'a';
    private final static int MAX_INDEX = 'z';
    private final static int ALPHABET_SIZE = MAX_INDEX - MIN_INDEX;

    static class Node{
        Node[] children;
        boolean isWordEnding;
    }

    private Node root = new Node();

    public void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            int index = ch-MIN_INDEX;
            if (node.children == null) {
                node.children = new Node[ALPHABET_SIZE];
            }
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }

        node.isWordEnding = true;
    }

    public boolean contains(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - MIN_INDEX;
            if(node.children == null) return false;
            if(node.children[index] == null) return false;
            node = node.children[index];
        }
    }
}
