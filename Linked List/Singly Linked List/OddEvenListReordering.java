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
class OddEvenListReordering{

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while(even!= null && even.next!=null){ //only checking even cause even will hit the end before odd cause it's a step ahead always
            if(odd.next != null){
                odd.next = odd.next.next;
                odd = odd.next;
            }
        
            if(even.next != null){
                even.next = even.next.next;
                even = even.next;
            }
        }

        odd.next = evenHead;

        return head;
    }
}
