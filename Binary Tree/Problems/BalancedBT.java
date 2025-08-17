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
class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(dfs(root) == -1){
            return false;
        }

        return true;
    }

    int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == -1 || right == -1) return -1;

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return 1+Math.max(left, right);
    }
}
