package ds.trie;

public class A_Trie_25 {

    private final static int MIN_VALUE = 'a';
    private final static int MAX_VALUE = 'z';
    private final static int ALPHABET_SIZE = MAX_VALUE - MIN_VALUE + 1;

    static class Node{
        Node[] children;
        boolean isWordEnd;
    }

    private Node root = new Node();

    public void add(String word){
        Node node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - MIN_VALUE;
            if (node.children == null) {
                node.children = new Node[ALPHABET_SIZE];
            }
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }

        node.isWordEnd = true;
    }

    public boolean contains(String word){
        Node node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - MIN_VALUE;
            if(node.children == null) return false;
            if(node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isWordEnd;
    }
}
