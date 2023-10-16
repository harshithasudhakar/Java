class Node{
    int value;
    Node next;
	
    Node(int value){
        this.value = value;
        this.next = null;
    }
}
class QueueImplementationUsingSinglyLinkedList{

    Node head;
	Node tail;
   
    public void insert(int value){
       
	   Node newNode = new Node(value);
	   
	   if(tail==null){
		   tail = newNode;
		   head = newNode;
	   }
	   tail = newNode.next;
	   tail = newNode;
        
    }
	
	public void remove(){
		
		Node temp = head;
		if(head==null){
			head = null;
			tail = null;
			return;
		}
		temp.value = null;
	}
	
	public void display(){
		
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.value + "->");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	
    public static void main(String[] args){
		
		QueueImplementationUsingSinglyLinkedList queue = new QueueImplementationUsingSinglyLinkedList();
		
		queue.insert(5);
		queue.insert(34);
		queue.insert(78);
		queue.insert(45);
		queue.insert(7);
		queue.insert(86);
		
		System.out.println("Original List:");
		queue.display();
		
		queue.remove();
		queue.remove();
		queue.remove();
		System.out.println("Queue after deleting elements:");
		list.display();
		
    }
}