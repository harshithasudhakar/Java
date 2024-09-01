class FindMiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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

        FindMiddleNode findMiddleNode = new FindMiddleNode();
        ListNode middle = findMiddleNode.middleNode(head);

        System.out.print("[");
        while (middle != null) {
            System.out.print(middle.val);
            middle = middle.next;
            if (middle != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
