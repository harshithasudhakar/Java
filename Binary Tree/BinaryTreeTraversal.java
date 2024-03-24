import java.util.Scanner;

public class BinaryTreeTraversal{
    class Node{
        int value;
        Node right;
        Node left;
        public Node(int value){
            this.value = value;
            this.right = this.left = null;
        }
    }

    static Node root;
    Node current = root;

    public void insert(int[] array, int length){
        if (length == 0) {
            return;
        }
        root = new Node(array[0]);
        System.out.println("Root is: " + root.value);
        
        Node[] nodes = new Node[length];
        nodes[0] = root;

        for(int i = 0; i<length; i++){
            if (2 * i + 1 < length) {
                nodes[2 * i + 1] = new Node(array[2 * i + 1]);
                nodes[i].left = nodes[2 * i + 1];
                System.out.println(nodes[i].left.value + " inserted to the left of " + nodes[i].value);
            }
            if (2 * i + 2 < length) {
                nodes[2 * i + 2] = new Node(array[2 * i + 2]);
                nodes[i].right = nodes[2 * i + 2];
                System.out.println(nodes[i].right.value + " inserted to the right of " + nodes[i].value);
            }
        }
    }
    
    public void preorder(Node current){
        if(current != null){
            System.out.print(current.value + " ");
            preorder(current.left);
            preorder(current.right);
        }
    }

    public void inorder(Node current){
        if(current != null){
            inorder(current.left);
            System.out.print(current.value + " ");
            inorder(current.right);
        }
    }

    public void postorder(Node current){
        if(current != null){
            postorder(current.left);
            postorder(current.right);
            System.out.print(current.value + " ");
        }
    }

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        BinaryTreeTraversal bbt = new BinaryTreeTraversal();
        System.out.println("Enter the size of array: ");
        int n = input.nextInt();
        System.out.println("Enter the elements: ");
        int[] array = new int[n];
        for(int i = 0; i<n; i++){
            array[i] = input.nextInt();
        }

        System.out.println("Building the binary tree: ");
        bbt.insert(array,n);

        System.out.println("Pre-order Traversal: ");
        bbt.preorder(root);

        System.out.println();
        System.out.println("In-order Traversal: ");
        bbt.inorder(root);

        System.out.println();
        System.out.println("Post-order Traversal: ");
        bbt.postorder(root);
    }
}
