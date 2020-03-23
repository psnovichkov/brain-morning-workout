package alg.traversal.bt_recursive_pre_in_post;

import alg.traversal.Visitor;
import ds.node.BTNode;

public class A_Traversal_04 {

	Visitor visitor;
	
	public A_Traversal_04(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void inOrder(BTNode node) {
		if(node == null) return;
		
		inOrder(node.left);
		visit(node);
		inOrder(node.right);
	}
	
	public void preOrder(BTNode node) {
		if(node == null) return;
		
		visit(node);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder(BTNode node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		visit(node);
	}
	
	private void visit(BTNode node) {
		visitor.visit(node);
	}
	
}
