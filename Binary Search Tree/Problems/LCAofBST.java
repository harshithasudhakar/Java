/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return preOrder(root, p, q);
    }

    TreeNode preOrder(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return node;
        }

        if(p.val<node.val && q.val>node.val){
            return node;
        }
        else if(p.val<node.val && q.val<node.val){
            return preOrder(node.left, p, q);
        }

        else if(p.val>node.val && q.val>node.val){
            return preOrder(node.right, p, q);
        }

        else{
            return node;
        }
    }
}
