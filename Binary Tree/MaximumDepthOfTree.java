/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;
class MaximumDepthOfTree {
    public int maxDepth(TreeNode root) {
        return postorder(root);
    }

    public static int postorder(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftDepth = postorder(root.left);
        int rightDepth = postorder(root.right);
        return 1+Math.max(leftDepth, rightDepth);
    }
}
