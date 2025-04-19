import java.util.*;

class FindPathFromRootToNode{
    class Node{
        int val;
        Node right;
        Node left;
        Node(int val){
            this.val = val;
            this.right = this.left = null;
        }
    }

    static Node root;
    static Queue<Node> q = new LinkedList<>();

    static void buildtree(int[] nodes){
        if(nodes.length == 0){
            return;
        }
        root = new Node(nodes[0]);
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i<nodes.length){
            Node curr = q.poll();
            if(i < nodes.length && nodes[i] != -1){
                curr.left = new Node(nodes[i]);
                q.add(curr.left);
            }
            i++;
            if(i < nodes.length && nodes[i] != -1){
                curr.right = new Node(nodes[i]);
                q.add(curr.right);
            }
            i++;
        }
    }

    static ArrayList<Node> findPath(Node root, int target){
        ArrayList<Node> path = new ArrayList<>();
        dfs(root, target, path);
        Collections.reverse(path); // when the nodes are added, they are added leaf -> root. Reverse for root -> leaf path.
        return path;
    }

    static boolean dfs(Node root, int target, ArrayList<Nodes> path){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        if(dfs(root.left, target, path) || dfs(root.right, target, path)){
            path.add(root);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nodes = new int[n];
        for(int i = 0; i<n; i++){
            nodes[i] = input.nextInt();
        }
        buildtree(nodes);
        findPath(root, target);
    }
}
