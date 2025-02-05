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
class InsertionInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = root;
        TreeNode newNode = new TreeNode(val);
        if(root == null){
            return newNode;
        }
        while(temp!=null){
            if(val > temp.val){
                if(temp.right == null){
                    temp.right = newNode;
                    break;
                }
                temp = temp.right;
            }
            else{
                if(temp.left == null){
                    temp.left = newNode;
                    break;
                }
                temp = temp.left;
            }
        }
        return root;
    }
}
