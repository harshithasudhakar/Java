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
class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return zigzag;
        }
        q.add(root);
        TreeNode ele;
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i =0; i<size; i++){
                ele = q.poll();
                level.add(ele.val);
                if(ele.left!= null){
                    q.add(ele.left);
                }
                if(ele.right!=null){
                    q.add(ele.right);
                }
            }
            if(reverse == true){
                Collections.reverse(level);
            }
            zigzag.add(level);
            reverse = !reverse;           
        }
        return zigzag;
    }
}
