package alg.traversal.bt_recursive_pre_in_post;

import alg.traversal.Visitor;
import ds.node.BTNode;

public class P_Traversal_01 {
	Visitor visitor;
	public P_Traversal_01(Visitor visitor) {
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
	
	private void visit(BTNode node) {
		visitor.visit(node);
	}

}
