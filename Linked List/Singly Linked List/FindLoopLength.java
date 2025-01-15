// Node is defined as:
// class Node{
//     int val;
//     Node next;
//     Node(){
//         val =0;
//         next = null;
//     }
//     Node(int x){
//     	val = x; next = null;
//     }
// }

class FindLoopLength{
    
    static int solve(Node root){
        
        if (root == null) return -1;
        
        Node slow = root;
        Node fast = root;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return loopLength(slow);
            }
        }
        return -1;
    }
    
    static int loopLength(Node slow){
        int count = 1;
        Node ptr = slow.next;
        while(ptr != slow){
            count++;
            ptr = ptr.next;
        }
        return count;
    }
}
