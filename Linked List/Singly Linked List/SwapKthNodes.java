import java.util.Scanner;

class SwapKthNodes {
     
  public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
  
  public ListNode swapNodes(ListNode head, int k) {

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode fast = head;

        for(int i = 1; i < k; i++){
            fast = fast.next;
        }

        ListNode firstK = fast;
        ListNode slow = head;

        fast = fast.next;
        while(fast != null){ //Iterates slow to LastK
            fast = fast.next;
            slow = slow.next;
        }

        int temp = slow.val;
        slow.val = firstK.val;
        firstK.val = temp;

        return head;
    }
  
  public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        head.val = arr[0];

        for(int i = 1; i<n; i++){
            arr[i] = input.nextInt();
        }

        for(int i = 0; i < arr.length; i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        SwapKthNodes swapKthNodes = new SwapKthNodes();

        int k = input.nextInt();
        ListNode newHead = swapKthNodes.swapNodes(head, k);

        current = newHead;

        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
            if(current != null) System.out.print(", ");
        }
        System.out.println("]");
    }
}
