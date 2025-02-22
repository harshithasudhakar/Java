import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.TreeMap;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
        this.left = this.right = null;
    }
}

class Pair{
    Node node;
    int hd;
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

class TopViewOfBT{
    static Node root;
    static Queue<Node> queue = new LinkedList<>(); //queue is only responsible for tracking nodes whose children need processing.
    
    static void insert(int[] nodes){
        
        root = new Node(nodes[0]);
        queue.add(root);
        int i = 1;

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            if(i<nodes.length){
                currentNode.left = new Node(nodes[i++]);
                queue.add(currentNode.left);
            }
            if(i<nodes.length){
                currentNode.right = new Node(nodes[i++]);
                queue.add(currentNode.right);
            }
        }
    }

    /*
    DFS Approach, needa incorporate depth tracking
    static ArrayList<Integer> topViewOfBT(Node root){
        int hd = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); //TreeMap over HashMap at it sorts the hd
        dfs(root, hd, map);
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : map.keySet()){
            System.out.println(map.get(ele));
            list.add(map.get(ele));
        }
        return list;
    }

    static void dfs(Node root, int hd, TreeMap<Integer, Integer> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(hd)){
            map.put(hd, root.val);
        }
        dfs(root.left, hd-1, map);
        // System.out.print(" " + root.val);
        dfs(root.right, hd+1, map);
    }
    */

    static ArrayList<Integer> topViewOfBT(Node root){

        int hd = 0; //Horizontal distance
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        bfs(root, q, hd, map);
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : map.keySet()){
            System.out.println(map.get(ele));
            list.add(map.get(ele));
        }
        return list;
    }

    static void bfs(Node root, Queue<Pair> q, int hd, TreeMap<Integer, Integer> map){

        if(root == null){
            return;
        }
        
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair ele = q.poll();

            if(!map.containsKey(hd)){
                map.put(ele.hd, ele.node.val);
            }

            if(ele.node.right != null){
                q.add(new Pair(ele.node.right, ele.hd+1));
            }
            if(ele.node.left != null){
                q.add(new Pair(ele.node.left, ele.hd-1));
                hd -= 1;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int numOfNodes = input.nextInt();
        System.out.println("Enter the nodes: ");
        int[] nodes = new int[numOfNodes];
        for(int i = 0; i<numOfNodes; i++){
            nodes[i] = input.nextInt(); //10 5 null 3 7 13 20
        }
        
        insert(nodes);
        
        //System.out.println("DFS:");
        //dfs(root);
        System.out.println("Top view of a BT: ");
        topViewOfBT(root);

        input.close();
    }
}
