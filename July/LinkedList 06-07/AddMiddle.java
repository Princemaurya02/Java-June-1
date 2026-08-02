public class AddMiddle {

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
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();

    }
}
    
