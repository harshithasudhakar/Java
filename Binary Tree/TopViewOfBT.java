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

    static ArrayList<Integer> topView(Node root){ //needa incorporate depth tracking to ensure that shallower nodes are processed porperly and not overshadowed.
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
        //System.out.print(" " + root.val);
        dfs(root.right, hd+1, map);
    }

    static void preorder(Node root){ // Root -> Left -> Right
        if(root == null){
            return;
        }

        System.out.print(" " + root.val);
        preorder(root.left);
        preorder(root.right);
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
        System.out.println("Pre-order:");
        preorder(root);
        System.out.println();
        //System.out.println("DFS:");
        //dfs(root);
        System.out.println("Top view of a BT: ");
        topView(root);

        input.close();
    }
}
