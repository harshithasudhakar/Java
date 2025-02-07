import java.util.*;

class ReversingSLL{

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    static Node head;

    static void addNode(int val){
        Node current = head;
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        
        while(current!=null){

            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    static void printList(Node head){
        Node current = head;
        while(current!=null){
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of nodes: ");
        int n = input.nextInt();
        int[] nodes = new int[n];
        System.out.println("Enter the nodes: ");
        for(int i = 0; i<n; i++){
            nodes[i] = input.nextInt();
        }

        for(int i = 0; i<n; i++){
            addNode(nodes[i]);
        }

        head = reverse(head);
        printList(head);
    }
}
