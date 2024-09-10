/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for(int i = 1; i < n; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        RemoveElements removeElements = new RemoveElements();

        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }
        System.out.println("]");
    }
}
