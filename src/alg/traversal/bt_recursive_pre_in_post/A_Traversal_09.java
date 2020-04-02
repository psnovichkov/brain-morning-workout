package alg.traversal.bt_recursive_pre_in_post;

import alg.traversal.Visitor;
import ds.node.BTNode;

public class A_Traversal_09 {

	Visitor visitor;
	
	public A_Traversal_09(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void preOrder(BTNode node) {
		if(node == null) return;
		
		visit(node);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(BTNode node) {
		if(node == null) return;
		
		preOrder(node.left);
		visit(node);
		preOrder(node.right);
	}
	
	public void postOrder(BTNode node) {
		if(node == null) return;
		
		preOrder(node.left);
		preOrder(node.right);
		visit(node);
	}
	
	private void visit(BTNode node) {
		visitor.visit(node);
	}
	
}
