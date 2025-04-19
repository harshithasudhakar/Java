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
class KthSmallestElementInBST {
    public int Findkth(TreeNode root, int k) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return nodes.get(k-1);
    }

    static void inorder(TreeNode root, ArrayList<Integer> nodes){
        if(root == null){
            return;
        }

        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }
}
