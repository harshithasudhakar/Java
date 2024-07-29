class SinglyLinkedListImplementation{

    public class Node{
        int val; // Stores the value of the node
        Node next; // Stores address of the next element in the linkedlist
        
        public Node(int val, Node next){ // Constructor initializes the instance fields
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    
    public void addNode(int val, int pos){ // Insertion
    
        Node newNode = new Node(val, null);

        // Empty LL or insertion at head
        if(head == null || pos == 1){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node curr = head; // Pointer to the current node
        int count = 1;
        while(curr != null && count < pos - 1){ // Iterating to position
            curr = curr.next;
            count+=1;
        }
        if (curr == null) { // If pos is out of bounds
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void deleteNode(int pos){ // Deletion

        // Empty LL or insertion at head
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }

        if(pos == 1){ 
            head = head.next; // When the LL has just one node, head-> node1-> null. So, head = head.next will make it head -> null
            return;
        }

        Node curr = head; // Pointer to the current node
        int count = 1;
        while(curr != null && count < pos-1){ // Iterating to position
            curr = curr.next;
            count += 1;
        }
        if (curr == null) { // If pos is out of bounds
            System.out.println("Position out of bounds");
            return;
        }
        curr.next = curr.next.next;
    }

    public void display(){ // Displaying
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public int search(int val){ //Searching for an element
        Node curr = head;
        int index = 1;
        while(curr != null){
            if(curr.val == val){
				System.out.println(val + " found at index: " + index);
				return index;
			}
            curr = curr.next;
            index++;
        }
        System.out.println(val + " not found in the list");
		return -1; // If element not found in the list
    }

    public static void main(String[] args){
		SinglyLinkedListImplementation list = new SinglyLinkedListImplementation();
		
		list.addNode(3, 1);
		list.addNode(54, 2);
		list.addNode(7, 1);
		list.addNode(11, 3);
		list.addNode(101, 2);
		list.addNode(8, 4);
		list.addNode(23, 7);
		
		System.out.println("Original List:");
		list.display();
		
		list.deleteNode(1);
		list.deleteNode(1);
		System.out.println("List after deleting elements");
		list.display();
		
		System.out.println("Searching for 8 and 50:");
		list.search(8);
		list.search(50);
		
		list.addNode(4, 6);
		list.display();
		
		System.out.println("List after deleting 11:");
		list.deleteNode(3);
		
		list.display();
    }
}
