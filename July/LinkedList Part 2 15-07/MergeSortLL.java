
public class MergeSortLL {

    // Node Class
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find Middle Node
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge Two Sorted Linked Lists
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    // Merge Sort Function
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find Mid
        Node mid = getMid(head);

        // Divide List
        Node rightHead = mid.next;
        mid.next = null;

        // Recursive Sort
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge
        return merge(newLeft, newRight);
    }

    // Print Linked List
    public void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Insert at End
    public Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Main Method
    public static void main(String[] args) {
        MergeSortLL list = new MergeSortLL();

        Node head = null;

        head = list.insert(head, 5);
        head = list.insert(head, 2);
        head = list.insert(head, 8);
        head = list.insert(head, 1);
        head = list.insert(head, 9);
        head = list.insert(head, 3);

        System.out.println("Original Linked List:");
        list.printList(head);

        head = list.mergeSort(head);

        System.out.println("Sorted Linked List:");
        list.printList(head);
    }
}