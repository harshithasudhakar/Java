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
class MaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    int postorder(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = postorder(node.left);
        int right = postorder(node.right);
        maxSum = Math.max(maxSum, node.val+Math.max(0,left)+Math.max(0,right));
        return node.val+Math.max(Math.max(0,left), Math.max(0,right));
    }
}
