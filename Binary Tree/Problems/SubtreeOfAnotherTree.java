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
class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return preOrder(root, subRoot);
    }

    boolean isEqual(TreeNode node, TreeNode subNode){
        if(node == null && subNode == null){
            return true;
        }

        if((node == null || subNode==null) || node.val != subNode.val){
            return false;
        }

        return isEqual(node.left, subNode.left) && isEqual(node.right, subNode.right);
    }

    boolean preOrder(TreeNode node, TreeNode subRoot){
        if(node == null){
            return false;
        }

        if(isEqual(node, subRoot)){
            return true;
        }

        // preOrder(node.left, subRoot);
        // preOrder(node.right, subRoot);

        return preOrder(node.left, subRoot) || preOrder(node.right, subRoot); // if it exists in either the left or right subtree of root
    }
}
