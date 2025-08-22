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
class InvertBT {
    public TreeNode invertTree(TreeNode root) {
        postOrder(root);
        return root;
    }

    static void postOrder(TreeNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
