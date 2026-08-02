public class SearchIterative {
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

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null){
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;

        }
        return -1;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    private int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }
    public int recSearch2(int key) {
        return helper2(head, key);
    }

    private int helper2(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper2(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static void main(String args[]) {
        SearchIterative ll = new SearchIterative();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(5);
        

        ll.print();
        System.out.println("Index of 3: " + ll.recSearch(3));
        System.out.println("Index of 7: " + ll.recSearch(7));
    }

    
}
