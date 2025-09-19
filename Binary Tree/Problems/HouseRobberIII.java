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
class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] result = postorder(root);
        return Math.max(result[0], result[1]);
    }

    int[] postorder(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }

        int[] left = postorder(node.left);
        int[] right = postorder(node.right);

        int robLeft = left[0];
        int skipLeft = left[1];

        int robRight = right[0];
        int skipRight = right[1];

        return new int[]{node.val+skipLeft+skipRight, Math.max(robLeft, skipLeft)+Math.max(robRight, skipRight)};
    }
}
