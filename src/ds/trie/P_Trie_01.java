package ds.trie;

/**
 * Start  8:17
 * End    8:22:19
 * @author psnovichkov
 *
 */
public class P_Trie_01 {
	public static final int MIN_VALUE = 'a';
	public static final int MAX_VALUE = 'z';
	public static final int ALPHABET_SIZE = MAX_VALUE - MIN_VALUE + 1;
	
	static class Node{
		Node[] children;
		boolean isWordEnd;
	}
	
	private Node root = new Node();  
	
	public void add(String word) {
		Node node = root;
		for(char ch: word.toCharArray()) {
			int index = ch - MIN_VALUE;
			if(node.children == null) {
				node.children = new Node[ALPHABET_SIZE];
			}
			if(node.children[index] == null) {
				node.children[index] = new Node();
			}
			node = node.children[index];
		}
		node.isWordEnd = true;
	}
	
	public boolean contains(String word) {
		Node node = root;
		for(char ch: word.toCharArray()) {
			int index = ch - MIN_VALUE;
			if(node.children == null) return false;
			if(node.children[index] == null) return false;
			node = node.children[index];
		}
		return node.isWordEnd;
	}
}
