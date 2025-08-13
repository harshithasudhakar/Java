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
class MinimumDepthBT {

    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        preOrder(root, 1);
        return min;
    }

    void preOrder(TreeNode node, int count){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){ // only update min when we reach a leaf node
            min = Math.min(min, count);
            return;
        }

        count+=1;
        preOrder(node.left, count);
        preOrder(node.right, count);
    }
}
