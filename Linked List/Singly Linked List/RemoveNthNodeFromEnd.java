class RemoveNthNodeFromEnd {
  
  public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
  public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        // Move fast ahead by n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast is null after moving n steps, that means we need to remove the head node
        if (fast == null) {
            return head.next;
        }

        // Move both fast and slow until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
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

        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();

        int nodeToRemove = input.nextInt();
        ListNode newHead = solution.removeNthFromEnd(head, nodeToRemove);

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
