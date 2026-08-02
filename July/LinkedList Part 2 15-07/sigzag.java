public class sigzag {
    static class Node {
        private final int data;
        Node next; 

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        int getData() {
            return data;
        }
    }

    static Node head;

    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // Reverse 2nd half


        // alt merge zig zag
    }
    
    
}
