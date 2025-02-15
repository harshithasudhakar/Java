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
class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<Integer, List<int[]>>();
        dfs(root, map, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
            List<int[]> nodes = entry.getValue();
            Collections.sort(nodes, (a, b) -> 
                a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]) //comparing row first, then coloumn(leftmost comes first)
            );
            
            List<Integer> colValues = new ArrayList<>();
            for (int[] node : nodes) {
                colValues.add(node[1]); // Only adding value, not row
            }

            result.add(colValues);
        }
        return result;
    }

    void dfs(TreeNode root, TreeMap<Integer, List<int[]>> map, int row, int col){
        if(root == null){
            return;
        }
        
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, root.val});

        dfs(root.left, map, row+1, col-1);
        dfs(root.right, map, row+1, col+1);
    }
}
