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
class DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return postorder(root, target);
    }

    TreeNode postorder(TreeNode node, int target){
        if(node == null){
            return null;
        }

        node.left = postorder(node.left, target);
        node.right = postorder(node.right, target);
        if(node.val == target && node.left == null && node.right == null){
            return null;
        }
        else{
            return node;
        }
    }
}
