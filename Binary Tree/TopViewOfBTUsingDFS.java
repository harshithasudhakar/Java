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
        if(nodes.length == 0) return;
        root = new Node(nodes[0]);
        q.add(root);
        int i = 1;

        while(!q.isEmpty() && i<nodes.length){
            Node current = q.poll();
            if(nodes[i] != -1){
                if(current.left == null){
                    current.left = new Node(nodes[i]);
                    q.add(current.left);
                }
            }
            i++;

            if(nodes[i] != -1){
                if(current.right == null){
                    current.right = new Node(nodes[i]);
                    q.add(current.right);
                }
            }
            i++;
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

    static void dfs(Node root, Map<Integer, int[]> map, int hd, int level){
        if(root == null){
            return;
        }

        if(!map.containsKey(hd) || map.get(hd)[1] > level){ // we are checking the level value at the same hd in the map. 
                                                            //if the level value we are processing is smaller than the one already in map, we will put in the map
            map.put(hd, new int[]{root.val, level});
        }

        dfs(root.left, map, hd-1, level+1);
        dfs(root.right, map, hd+1, level+1);
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
