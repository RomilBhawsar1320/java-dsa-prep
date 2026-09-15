package linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

}
