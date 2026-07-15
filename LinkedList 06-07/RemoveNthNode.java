public class RemoveNthNode {
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

    

    public void deleteNthFromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }


        if(n == sz) {
            head = head.next;
            return;
        }

        //sz - n
        int i = 1;
        int iTofind = sz - n;
        Node prev = head;
        while(i < iTofind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }
    public static void main(String args[]) {
        RemoveNthNode ll = new RemoveNthNode();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        ll.print();

        ll.deleteNthFromEnd(3);
        ll.print();
    }
}
