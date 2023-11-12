class Node{
	int value;
	Node next;
	
	public Node(int value){
		this.value = value;
		this.next = null;
	}
}

class LinkedListOperations{
	
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
		while(temp!=null){
			if(temp.value == value){
				return temp.value;
			}
			temp = temp.next;
		}
		return 0;
	}
	
	public void insertAtNextNode(int key, int value){
		
		Node temp = head;
		Node newNode = new Node(value);
		while(temp!=null && temp.value!=key){
			temp = temp.next;
		}
		if(temp.value == key){
			newNode.next = temp.next;
			temp.value = newNode;
		}
	}
	
	public void deletingElement(int value){
		
		Node temp = head;
		if(head == null){
			return;
		}
		while(temp!=null && temp.value!=value){
			temp = temp.next;
		}
		if(temp.next == value){
			temp.value = temp.next.next;
			temp.next = null;
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
		
		list.search(8);
		
		list.intesertAtNextNode(4, 47);
		list.display();
		
		System.out.println("List after deleting 11:");
		list.deletingElement(11);
		
		list.display();
		
	}
}






