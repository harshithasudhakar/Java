import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
        this.left = this.right = null;
    }
}

class BinaryTreeImplementationUsingQueue{
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

    static void preorder(Node root){ // Root -> Left -> Right
        if(root == null){
            return;
        }

        System.out.println(" " + root.val);
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
            nodes[i] = input.nextInt(); //10 5 -1 3 7 13 20
        }
        insert(nodes);
        preorder(root);

        input.close();
    }
}
