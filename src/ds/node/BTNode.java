package ds.node;


public class BTNode {
	
	public static enum NodeColor{
		Red, Black;
	}
	
	public int data;
	public BTNode left;
	public BTNode right;
	
	public int height;
	public int marked;
	public NodeColor color;
	
	public BTNode(int data) {
		this.data = data;
	}
}
