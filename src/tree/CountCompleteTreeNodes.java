package tree;

import global.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
    	if (root == null) return 0;
        int num1 = countNodes(root.left);
        int num2 = countNodes(root.right);
        return num1 + num2 + 1;
    }
}
