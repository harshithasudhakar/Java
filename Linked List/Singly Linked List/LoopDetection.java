/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

class LoopDetection {
    public static Node detectCycle(Node head){
        
        Node meetingpoint = pointerMeet(head);
        Node slow = meetingpoint;
        Node fast = head;
        
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
    static Node pointerMeet(Node head){
        
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
}
