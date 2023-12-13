class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
        this.left = this.right = null;
    }
}
public class BinarySearchTree {
    
    Node root;
    
    public void insert(int value){
        Node node = new Node(value);

        if(root == null){
            root = node;
            System.out.println(node.value);
        }
        else{
            Node current = root;
            while(true){
                if(value<current.value){
                    if(current.left == null){
                        current.left = node;
                        System.out.println("Inserted " + value + " to the left of " + current.value);
                        break;
                    }
                    current = current.left;
                }
                if(value>current.value){
                    if(current.right == null){
                        current.right = node;
                        System.out.println("Inserted " + value + " to the right of " + current.value);
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }

    public void search(int value){
        Node current = root;
        Node parent = null;
        if(root == null){
            System.out.println("The BST is empty");
            return;
        }
        else{
            while(current != null){
                if(value == current.value){
                    System.out.println("Node found, its parent is " + (parent != null ? parent.value : "null"));
                    return;
                }
                if(value<current.value){
                    parent = current;
                    current = current.left;
                }
                if(value>current.value){
                    parent = current;
                    current = current.right;
                }
            }
            System.out.println("Node not found");
        }
    }

    public void delete(int value){
        Node current = root;
        if(root == null || (root.right == null && root.left == null)){
            root = null;
            System.out.println("BST is empty");
            return;
        }
        else{
            search(value);
            if(current.right == null && current.left == null){
                current = null;
                System.out.println(value + " deleted");
                return;
            }
            if(current.right == null && current.left != null || current.right !=null && current.left == null ){
                current.right = current.left = null;
                System.out.println(value + " deleted");
                return;
            }
            if(current.right != null && current.left != null){
                while(true){
                    if(current.right != null){
                        current = current.right;
                    }
                    break;
                }
                if(current.left!=null){
                    current.left = null;
                    System.out.println(value + " deleted");
                    return;
                }
                else{
                    current = null;
                    System.out.println(value + " deleted");
                    return;
                }
            }
        }
        System.out.println("Node not found");
    }

    public static void main(String[] args){
        
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(8);
        bst.insert(12);
        bst.insert(17);
        bst.insert(6);
        bst.insert(2);
        bst.insert(23);
        bst.insert(7);
        bst.insert(5);
        bst.insert(10);

        System.out.println();
        bst.search(10);
        bst.search(17);
        bst.search(2);
        bst.search(23);
        bst.search(48);
        System.out.println();

        bst.delete(23);
        bst.delete(2);
        bst.delete(6);
        bst.delete(12);
        System.out.println();
    }
}