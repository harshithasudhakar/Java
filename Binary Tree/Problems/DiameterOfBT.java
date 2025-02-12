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
import java.util.*;
class DiameterOfBT {
    public int diameterOfBinaryTree(TreeNode root) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        diameterOfNode(root,map);
        int max = 0;
        for (int diameter : map.values()) {
            max = Math.max(max, diameter);
        }
        return max;
    }

    static int diameterOfNode(TreeNode root, TreeMap<Integer,Integer> map){
        if(root == null){
            return 0;
        }
        
        int leftDepth = diameterOfNode(root.left, map);
        int rightDepth = diameterOfNode(root.right, map);
        int currentDiameter = leftDepth+rightDepth;
        map.put(System.identityHashCode(root), currentDiameter);
        return 1+Math.max(leftDepth, rightDepth);
    }
}
