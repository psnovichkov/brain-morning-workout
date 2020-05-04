package alg.traversal.bt_recursive_pre_in_post;

import alg.traversal.Visitor;
import ds.node.BTNode;

public class G_Traversal_01 {
    Visitor visitor;

    G_Traversal_01(Visitor visotor) {
        this.visitor = visitor;
    }

    public void preorder(BTNode root) {
        if (root == null) return;

        visit(root);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(BTNode root) {
        if (root == null) return;

        inorder(root.left);
        visit(root);
        inorder(root.right);
    }

    public void postorder(BTNode root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        visit(root);
    }


    private void visit(BTNode node) {
        this.visitor.visit(node);
    }
}
