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
class BTfromPreAndInorder {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return construct(preorder, inorder);
    }

    TreeNode construct(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootInd = 0; 

        for(int i = 0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                rootInd = i;
                break;
            }
        }

        int[] leftInorder = new int[rootInd];
        int[] rightInorder = new int[inorder.length - rootInd - 1];

        for(int i = 0; i<rootInd; i++){
            leftInorder[i] = inorder[i];
        }

        for(int i = 0; i<rightInorder.length; i++){
            rightInorder[i] = inorder[i+rootInd + 1];
        }

        int[] leftPre = new int[rootInd];
        int[] rightPre = new int[preorder.length - rootInd - 1];

        for(int i = 0; i<rootInd; i++){
            leftPre[i] = preorder[i+1];
        }

        for(int i = 0; i<rightPre.length; i++){
            rightPre[i] = preorder[i+rootInd + 1];
        }

        root.left = construct(leftPre, leftInorder);
        root.right = construct(rightPre, rightInorder);

        return root;
    }
}
