public class sample {
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
    newNode.next = head;
    head = newNode;
   }

   public void addLast(int data){
    Node newNode = new Node(data);
    if(head == null){
        head = tail = newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
   }

   public void add(int index, int data){
    if(index == 0){
        addFirst(data);
        return;
    }
    Node temp = head;
    for(int i = 1; i < index; i++){
        if(temp == null){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        temp = temp.next;
    }
    if(temp == null){
        throw new IndexOutOfBoundsException("Index: " + index);
    }
    Node newNode = new Node(data);
    newNode.next = temp.next;
    temp.next = newNode;
    if(newNode.next == null){
        tail = newNode;
    }
   }

   public void print(){
    Node temp = head;
    while(temp != null){
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }
    System.out.println("null");
   }

   public int removeFirst(){
    if(head == null){
        throw new IllegalStateException("List is empty");
    }
    int val = head.data;
    head = head.next;
    if(head == null){
        tail = null;
    }
    return val;
   }
    public static void main(String args[]){
        sample ll = new sample();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(5);
        ll.add(2, 5);

        ll.print();
        ll.removeFirst();
        ll.print();
    }
}

// time is constant O(1) for addFirst method because we are adding the new node at the beginning of the linked list, which takes a constant amount of time regardless of the size of the list.
// First time complexity is O(1) for addLast method because we are adding the new node at the end of the linked list, which takes a constant amount of time regardless of the size of the list.
// Last time complexity is O(n) for addLast method because we have to traverse the entire linked list to find the last node, which takes linear time in proportion to the size of the list.