public class Palindrome {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print Linked List
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Find middle node
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Check Palindrome
    public boolean checkPalindrome() {

        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle
        Node mid = findMid(head);

        // Step 2: Reverse second half
        Node prev = null;
        Node curr = mid.next;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Compare both halves
        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Palindrome ll = new Palindrome();

        // Change these values to test
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);

        ll.print();

        boolean ans = ll.checkPalindrome();
        System.out.println(ans);
    }
}