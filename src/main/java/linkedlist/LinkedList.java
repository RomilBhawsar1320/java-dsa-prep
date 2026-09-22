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

    public Node kthFromEnd(int k) {
        if (k <= 0 || k > size) return null;
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public void removeDuplicates() {
        if (head == null) return;
        Node current = head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
        tail = current; // Update tail to the last unique node/
    }
    /*
    REMOVE DUPLICATES EXPLANATION:
1. Check if the head is null. If it is, return immediately as there are no duplicates to remove.
2. Initialize a pointer current to the head of the list.
3. Traverse the list using a while loop that continues as long as current and current.next are not null.
4. Inside the loop, compare the value of the current node with the value of the next node (current.next).
5. If the values are equal, it means there is a duplicate. In this case, update the next pointer of the current node to skip the next node (
current.next = current.next.next), effectively removing the duplicate node from the list. Decrement the size of the list by 1.
6. If the values are not equal, move the current pointer to the next node (current = current.next).
7. After the loop, update the tail pointer to point to the last unique node in the list (tail = current). This ensures that the tail correctly reflects the end of the
    list after duplicates have been removed.
     */

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
        System.out.println("Kth from end (k=1): " + myLinkedList.kthFromEnd(2).value);


        /*
         Explanation of the Code (Line by Line)

We first check if k is less than or equal to zero. If so, there is no valid "k-th from end" node, so we return null.

We create two pointers, slow and fast, and set them both to the head of the list.

We advance the fast pointer k times. This creates a gap of k nodes between fast and slow.

If fast becomes null before we finish moving it k times, that means the list has fewer than k nodes. We return null.

After the gap is established, we move slow and fast together, one node at a time.

When fast reaches the end (null), slow will be pointing to the node that is k positions from the end.

We return the node referenced by slow.





Code with inline comments:



public Node findKthFromEnd(int k) {

    // If k is zero or negative, not valid
    if (k <= 0) {
        return null;
    }

    // Both pointers start at the head
    Node slow = head;
    Node fast = head;

    // Move the fast pointer k steps ahead
    for (int i = 0; i < k; i++) {
        // If fast hits null before k steps,
        // the list has fewer than k nodes
        if (fast == null) {
            return null;
        }
        fast = fast.next;
    }

    // Move both pointers until fast hits the end
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }

    // Slow is now at the k-th node from the end
    return slow;
}

         */



    }

}
