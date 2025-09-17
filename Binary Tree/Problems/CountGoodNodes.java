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
class CountGoodNodes {
    int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        int max = Integer.MIN_VALUE;
        preOrder(root, max);
        return count;
    }

    void preOrder(TreeNode node, int max){
        if(node == null){
            return;
        }

        if(node.val >= max){
            count += 1;
            max = node.val;
        }
        preOrder(node.left, max);
        preOrder(node.right, max);
    }
}
