import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class TopViewOfBTUsingDFS{

    static class Node{
        int val;
        Node right;
        Node left;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;
    static Queue<Node> q = new LinkedList<>();

    static void buildTree(int[] nodes){
        root = new Node(nodes[0]);
        q.add(root);
        int i = 1;

        Node current = root;
        while(!q.isEmpty()){
            if(i<nodes.length){
                if(current.left == null){
                    current.left = new Node(nodes[i++]);
                    q.add(current.left);
                }
                if(current.right == null){
                    current.right = new Node(nodes[i++]);
                    q.add(current.right);
                }
            }
        }
    }

    static void topview(Node root){
        Map<Integer, int[]> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        System.out.print("Top view: ");
        for(int[] pairs : map.values()){
            System.out.print(pairs[0] + " ");
        }
    }

    static void dfs(Node root, Map<Integer, int[]> map, int hd, int l){
        if(root == null){
            return;
        }

        if(!map.containsKey(hd) || map.get(hd)[1] > l){
            map.put(hd, new int[]{root.val, l});
        }

        dfs(root.left, map, hd-1, l+1);
        dfs(root.right, map, hd+1, l+1);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        int[] nodes = new int[n];
        System.out.println("Enter the nodes: ");
        for(int i = 0; i<n; i++){
            nodes[i] = input.nextInt();
        }
        buildTree(nodes);
        topview(root);
    }
}
