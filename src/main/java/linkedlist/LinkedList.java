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

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (size == 0) return;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= size) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index >= size) return null;
        if (index == 0) {
            Node temp = head;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return temp;
        }
        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = temp.next;
        size--;
        if (index == size) {
            tail = pre;
        }
        return temp;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            prepend(value);
            return;
        }
        if (index == size) {
            append(value);
            return;
        }
        Node newNode = new Node(value);
        Node pre = get(index - 1);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < size; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddle() {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Boolean hasCycle() {
        if (head == null) return false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getSize();

        myLinkedList.append(20);
        myLinkedList.prepend(13);
        myLinkedList.removeFirst();
        myLinkedList.printList();
        myLinkedList.reverse();
        Node middle = myLinkedList.findMiddle();
        System.out.println("Middle node value: " + middle.value);
        System.out.println("Has cycle: " + myLinkedList.hasCycle());



    }

}
