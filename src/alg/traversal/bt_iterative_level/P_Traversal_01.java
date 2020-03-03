package alg.traversal.bt_iterative_level;

import java.util.LinkedList;
import java.util.Queue;

import alg.traversal.Visitor;
import ds.node.BTNode;

public class P_Traversal_01 {
	Visitor visitor;
	public P_Traversal_01(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void levelorder(BTNode root) {
		Queue<BTNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			BTNode node = q.remove();
			visit(node);
			if(node.left != null) q.add(node.left);
			if(node.right != null) q.add(node.right);			
		}		
	}

	private void visit(BTNode node) {
		visitor.visit(node);
	}

}
