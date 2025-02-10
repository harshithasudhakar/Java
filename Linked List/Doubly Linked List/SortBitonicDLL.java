class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class SortBitonicDLL {
    private Node head;
    private Node tail;

    public SortBitonicDLL() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node findPeak() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public DoublyLinkedList splitAtNode(Node peak) {
        DoublyLinkedList secondList = new DoublyLinkedList();
        if (peak == null || peak.next == null) {
            return secondList;
        }

        secondList.head = peak.next;
        secondList.head.prev = null;

        peak.next = null;
        this.tail = peak;

        Node current = secondList.head;
        while (current.next != null) {
            current = current.next;
        }
        secondList.tail = current;

        return secondList;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public static DoublyLinkedList mergeSortedLists(DoublyLinkedList list1, DoublyLinkedList list2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.append(current1.data);
                current1 = current1.next;
            } else {
                mergedList.append(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.append(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.append(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    public void sortBitonicList() {
        Node peak = findPeak();
        if (peak == null) {
            System.out.println("The list is not bitonic.");
            return;
        }

        DoublyLinkedList secondList = splitAtNode(peak);
        secondList.reverse();

        DoublyLinkedList sortedList = mergeSortedLists(this, secondList);

        this.head = sortedList.head;
        this.tail = sortedList.tail;
    }
}

public class Main {
    public static void main(String[] args) {
        SortBitonicDLL dll = new SortBitonicDLL();

        dll.append(1);
        dll.append(3);
        dll.append(5);
        dll.append(7);
        dll.append(6);
        dll.append(4);
        dll.append(2);

        System.out.println("Original Bitonic List:");
        dll.printList();

        dll.sortBitonicList();

        System.out.println("Sorted List:");
        dll.printList();
    }
}
