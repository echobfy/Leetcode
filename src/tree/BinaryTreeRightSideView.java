package tree;

import global.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> ans = new ArrayList<Integer>();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	if (root == null) return ans;
    	
    	queue.offer(root);
    	queue.offer(null);
    	
    	while (!queue.isEmpty()) {
    		TreeNode front = queue.poll();
    		if (front == null) {
    			if (queue.isEmpty()) break;
    			queue.offer(null);
    			continue;
    		}
    		// If the head is null, means that the currrent node is rightest.
    		if (queue.peek() == null) ans.add(front.val);
    		if (front.left != null) queue.offer(front.left);
    		if (front.right != null) queue.offer(front.right);
    	}
        return ans;
    }
}
