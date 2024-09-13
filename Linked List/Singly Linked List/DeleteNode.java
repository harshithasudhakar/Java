import java.util.Scanner;

class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        DeleteNode deleteNode = new DeleteNode();

        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
        System.out.println("]");

    }

}
