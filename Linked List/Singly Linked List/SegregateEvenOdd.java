class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SegregateEvenOdd {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void segregateEvenOdd() {
        if (head == null || head.next == null) {
            return;
        }

        Node evenHead = new Node(-1); // Dummy head for even list
        Node oddHead = new Node(-1);  // Dummy head for odd list

        Node evenTail = evenHead;
        Node oddTail = oddHead;

        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                evenTail.next = current;
                evenTail = evenTail.next;
            } else {
                oddTail.next = current;
                oddTail = oddTail.next;
            }
            current = current.next;
        }

        evenTail.next = null;
        oddTail.next = null;

        if (evenHead.next != null) {
            head = evenHead.next;
            evenTail.next = oddHead.next;
        } else {
            head = oddHead.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.append(4);
        sll.append(5);

        System.out.println("Original List:");
        sll.printList();

        sll.segregateEvenOdd();

        System.out.println("List after segregating even and odd nodes:");
        sll.printList();
    }
}
