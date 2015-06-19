package tree;

import global.TreeNode;

public class InvertBinaryTree {
	
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return null;
    	
    	invertTree(root.left);
    	invertTree(root.right);
    	
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
		return root;
    }
    
    
}
