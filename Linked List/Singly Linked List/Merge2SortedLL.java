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
class Merge2SortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = merge(list1, list2);

        return merged;
    }

    static ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            list1.next = merge(list1.next, list2);
            return list1;
        }
        else{
            list2.next = merge(list1, list2.next);
            return list2;
        }

    }
}
