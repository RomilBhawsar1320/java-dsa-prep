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

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getSize();
        myLinkedList.printList();
    }

}
