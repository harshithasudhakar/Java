/*
public class Main {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }*/
public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
    

