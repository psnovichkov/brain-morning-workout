package alg.traversal;

import ds.node.BTNode;

/**
 * 
 * @author psnovichkov
 *
 */
public class BTRecursive {
	Visitor visitor;
	public BTRecursive(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void preorder(BTNode node) {
		if(node == null) return;
		
		visit(node);
		preorder(node.left);
		preorder(node.right);		
	}
	
	public void inorder(BTNode node) {
		if(node == null) return;
		
		inorder(node.left);
		visit(node);
		inorder(node.right);
	}
	
	public void postorder(BTNode node) {
		if(node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		visit(node);
	}
	
	public void levelorder(BTNode node) {
		
		int height = height(node);
		for(int i = 1 ; i <= height; i++) {
			levelorder(node, i);
		}
	}
	
	private void levelorder(BTNode node, int level) {
		if(node == null) return;
		if(level == 1) {
			visit(node);
		} else {
			levelorder( node.left, level-1 );
			levelorder( node.right, level-1 );
		}
	}
	
	private int height(BTNode node) {
		if(node == null) return 0;
		return Math.max(  height(node.left), height(node.right)) + 1;
	}	
	
	private void visit(BTNode node) {
		visitor.visit(node);
	}	
}
