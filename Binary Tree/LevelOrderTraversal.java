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
class LevelOrderTraversal { //Using queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null){
            return result;
        }
      
        q.add(root);
        TreeNode ele;

        while(!q.isEmpty()){

            List<Integer> innerList = new ArrayList<Integer>();
            int size = q.size();

            for(int i = 0; i<size; i++){
                ele = q.poll();
                innerList.add(ele.val);
                if(ele.left != null){
                    q.add(ele.left);
                }
                if(ele.right != null){
                    q.add(ele.right);
                }
            }
            result.add(innerList);
        }
        return result;
    }
}
