package alg.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ds.node.BTNode;

/**
 * 
 * @author psnovichkov
 *
 */
public class BTIterative {
	Visitor visitor;
	public BTIterative(Visitor visitor) {
		this.visitor = visitor;
	}


	public void preorder(BTNode root) {
		Stack<BTNode> s = new Stack<BTNode>();
		s.push(root);
		
		while(!s.empty()) {
			BTNode node = s.pop();
			visit(node);
			if( node.right != null) s.push(node.right);			
			if( node.left != null) s.push(node.left);
		}
	}
	
	public void inorder(BTNode root) {
		Stack<BTNode> s = new Stack<BTNode>();
		s.add(root);

		boolean exploreLeft = true;
		while(!s.isEmpty()) {
			
			if(exploreLeft) {
				exploreLeft = false;
				while(s.peek().left != null) {
					s.push(s.peek().left);
				}
			}
			
			BTNode node = s.pop();
			visit(node);
			
			if(node.right != null) {
				s.push(node.right);
				exploreLeft = true;
			}
		}
	}	
	
	
	public void inorder_original(BTNode root) {
		Stack<BTNode> s = new Stack<BTNode>();
		s.push(root);
		
		BTNode cNode = root;
		BTNode hNode = null;
		while(!s.isEmpty()) {			
			if( cNode != null ) {				
				// Go to left
				hNode = cNode;
				while(hNode.left != null) {
					s.push(hNode.left);
					hNode = hNode.left;
				}				
			}
			cNode = s.pop();
			visit(cNode);
			
			if(cNode.right != null) {
				s.push(cNode.right);
				cNode = cNode.right;
			} else {
				cNode = null;
			}			
		}		
	}
	
	
	public void postorder(BTNode root) {
		Stack<BTNode> s = new Stack<>();
		if(root.right != null) {
			s.push(root.right);
		}
		s.push(root);
		
		boolean exploreLeft = true;
		boolean exploreRight = true;
		
		while(!s.isEmpty()) {
			if(exploreLeft) {
				exploreLeft = false;
				while( s.peek().left != null ) {
					BTNode node = s.peek().left;
					if(node.right != null) {
						s.push(node.right);
					}
					s.push(node);
				}
			}
			BTNode node = s.pop();
			exploreRight = !s.isEmpty() && s.peek() == node.right;  
			if(exploreRight) {
				BTNode rNode = s.pop();
				s.push(node);				
				
				if(rNode.right != null) {
					s.push(rNode.right);
				}
				s.push(rNode);
				exploreLeft = true;
			} else {
				visit(node);
			}
		}
	}
	

	public void postorder_original(BTNode root) {
		Stack<BTNode> s = new Stack<BTNode>();
		BTNode cNode = root;
		BTNode hNode = null;
		do {
			// Go to left looking at the first right
			while(cNode != null) {
				if(cNode.right != null) {
					s.push(cNode.right);
				}
				s.push(cNode);
				
				if(cNode.left != null) {
					cNode = cNode.left;
				} else 	{
					cNode = null;
				}				
			}
			
			// Go back one step back and then try to go one step right
			cNode = s.pop();
			if(cNode.right != null && !s.isEmpty() &&  cNode.right == s.peek()) {
				//swap
				hNode = s.pop();
				s.push(cNode);
				cNode = hNode;					
				
			} else {
				visit(cNode);
				cNode = null;
			}
			
		} while( !s.empty() );			
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
