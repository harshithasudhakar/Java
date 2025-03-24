import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class LeftViewOfBTUsingDFS{

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
        if(nodes.length == 0|| nodes[0] == -1) return;
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

    static int maxLevel = -1;

    static void leftView(Node root, int level){ //DFS-Preorder approach
        if(root == null){
            return;
        }

        if(level>maxLevel){ //To ensure we are printing leftmost node of the level
            System.out.print(root.val+ " ");
            maxLevel = level;
        }

        leftView(root.left, level+1);
        leftView(root.right, level+1);
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
        System.out.println("Left view: ");
        leftView(root,0);
    }
}
