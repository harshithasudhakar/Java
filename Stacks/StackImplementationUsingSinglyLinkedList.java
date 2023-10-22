class Node{
	int value;
	Node next;
	Node(int value){
		
		this.value = value;
		this.next = null;
	}
}

class StackImplementationUsingSinglyLinkedList{
	
	Node head; 
	
	public void push(int value){
		//Inserts element at the top of the stack
		Node temp = head;
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public int pop(){
		//Removes element from the top of the stack
		Node temp = head;
		int poppedValue = temp.value;
		if(head==null){
			return 0;
		}
		while(temp!=null){
			head = temp.next;
			temp = null;
		}
		return(poppedValue);
	}
	
	public void display(){
		//Displays the stack
		Node temp = head;
		System.out.println("The stack is:");
		while(temp!=null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		
		StackImplementationUsingSinglyLinkedList stack = new StackImplementationUsingSinglyLinkedList();
		
		stack.push(67);
		stack.push(36);
		stack.push(12);
		stack.push(9);
		stack.push(28);
		stack.push(49);
		stack.push(88);
		
		stack.display();
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.display();
		
	}
}
