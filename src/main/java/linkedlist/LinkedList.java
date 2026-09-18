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

    public void getHead() {
        System.out.println("Head: " + head.value);
    }
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getSize() {
        System.out.println("Size: " + size);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void append(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeLast() {
        if (size == 0) return;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        }
    }


    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getSize();
        myLinkedList.printList();
    }

}
