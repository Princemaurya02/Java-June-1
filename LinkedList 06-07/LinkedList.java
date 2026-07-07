public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

   public void addFirst(int data){
    Node newNode = new Node(data);
    if(head == null){
        head = tail = newNode;
        return;
    }
    // create a new node
    

    //step 2newNode.next = head;
    newNode.next = head;

    head = newNode;
   }

   public void addLast(int data){
    Node newNode = new Node(data);
    if(tail == null){
        head = tail = newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
   }

   public void print(){
    if(head == null){
        System.out.println("Linked list is empty");
        return;
    }
    Node temp = head;
    while(temp != null){
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    System.out.println("->null");

   }

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();

    }
}

// time is constant O(1) for addFirst method because we are adding the new node at the beginning of the linked list, which takes a constant amount of time regardless of the size of the list.
// First time complexity is O(1) for addLast method because we are adding the new node at the end of the linked list, which takes a constant amount of time regardless of the size of the list.
// Last time complexity is O(n) for addLast method because we have to traverse the entire linked list to find the last node, which takes linear time in proportion to the size of the list.