class LinkedListOperations{
	class Node{
	int value;
	Node next;
	
	public Node(int value){
		this.value = value;
		this.next = null;
	}
}
	
	Node head;
	
	public void insertingAtBeginning(int value){
		
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		
	}
	
	public void deletingAtEnd(){
		
		if(head == null || head.next == null){
			head = null;
			return;
		}
		Node temp = head;
		while(temp.next.next!=null){
			temp = temp.next;
		}
		temp.next = null;
	}
	
	public void display(){
		
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	public int search(int value){
		
		Node temp = head;
		int index = 0;
		while(temp!=null){
			if(temp.value == value){
				System.out.println(value + " found at index: " + index);
				return index;
			}
			temp = temp.next;
			index++;
		}
		System.out.println(value + " not found in the list");
		return -1; // if element not found in the list
	}
	
	public void insertAtNode(int key, int value){
		
		Node temp = head;
		int index = 0;
		Node newNode = new Node(value);
		if(key==0){
			insertingAtBeginning(value);
			return;
		}
		while(temp!=null && index != key-1){
			temp = temp.next;
			index++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void deletingElement(int value){
		
		Node temp = head;
		if(head == null){
			return;
		}
		while(temp!=null && temp.next.value!=value){
			temp = temp.next;
		}
		if(temp.next != null && temp.next.value == value){
			temp.next = temp.next.next;
		}
	}
	
	public static void main(String[] args){
		LinkedListOperations list = new LinkedListOperations();
		
		list.insertingAtBeginning(3);
		list.insertingAtBeginning(54);
		list.insertingAtBeginning(7);
		list.insertingAtBeginning(11);
		list.insertingAtBeginning(101);
		list.insertingAtBeginning(8);
		list.insertingAtBeginning(23);
		
		System.out.println("Original List:");
		list.display();
		
		list.deletingAtEnd();
		list.deletingAtEnd();
		System.out.println("List after deleting the end elements:");
		list.display();
		
		System.out.println("Searching for 8 and 50:");
		list.search(8);
		list.search(50);
		
		list.insertAtNode(4, 47);
		list.display();
		
		System.out.println("List after deleting 11:");
		list.deletingElement(11);
		
		list.display();
		
	}
}
