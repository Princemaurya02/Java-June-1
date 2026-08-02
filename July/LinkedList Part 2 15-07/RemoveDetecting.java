
public class RemoveDetecting {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public static void RemoveCycle() {
        // Detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // Find the starting point of the cycle

        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        if (prev == null) {
            while (fast != null && fast.next != slow) {
                fast = fast.next;
            }
            if (fast != null) {
                fast.next = null;
            }
        } else {
            prev.next = null; // Remove the cycle
        }

    }

    public static boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        head = new Node(1);
        Node temp;
        head.next = new Node(2);
        temp = head.next;

        head.next.next = new Node(3);
        head.next.next.next = temp;

        // 1 -> 2 -> 3

        // Print true or false
        System.out.println(hasCycle());
        RemoveCycle();
        System.out.println(hasCycle());
    }
}
