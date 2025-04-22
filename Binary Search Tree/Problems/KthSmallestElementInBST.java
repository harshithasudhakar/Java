import java.util.*;

class KthSmallestElementInBST{
    static class Node{
        int val;
        Node right;
        Node left;
        Node(int val){
            this.val = val;
            this.right = this.left = null;
        }
    }

    static Node root;

    static void insert(int value){

        Node newNode = new Node(value);
        if(root == null){            
            root = newNode;
            return;
        }

        Node curr = root;
        while(true){
            if(value<curr.val){
                if(curr.left == null){
                    curr.left = newNode;
                    break;
                }
                curr = curr.left;
            }
            if(value>curr.val){
                if(curr.right == null){
                    curr.right = newNode;
                    break;
                }
                curr = curr.right;
            }
        }
    }

    static ArrayList<Integer> elements;

    static Integer kthElement(Node root, int k){
        elements = new ArrayList<Integer>();
        inorder(root);
        return elements.get(k-1); // k-1 for 1-based indexing, change to k if 0-based
    }
    

    static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        elements.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        for(int i = 0; i<n; i++){
            insert(input.nextInt());
        }
        System.out.println("The kth smallest element is: "+kthElement(root,3));
    }
}
