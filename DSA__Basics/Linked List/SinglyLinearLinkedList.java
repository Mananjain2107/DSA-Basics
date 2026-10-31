class LinkedList {

    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    // Insertion
    public void addFirst(int data) {
        Node newNode = new Node(data); //1. craete a newnode
        newNode.next = head; //2. add first node into next of newnode
        head = newNode; //3. move head on newnode
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if(head==null){
            head=newNode; // if list is empty add newnode into head
        }
        else{
            Node temp = head;
            while(temp.next!=null){ // Stops when you reach the last node
                temp=temp.next;
            }
            temp.next = newNode;
        }
    }

    // Deletion

    public void deleteFirst(){
        if(head==null){
            System.out.println("The list is Empty and also it will throw Null pointer Exception");
            return;
        }
        head=head.next; // deleting the first node
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        else if(head.next==null){ // if list have one element then delete it
            head=null;
        }
        else{ // we are not including the list with 1 element here because we are traversing till the second last node to remove the last node
             // in case of just 1 element we cannot traverse we simply delete it
            Node temp = head;

            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.print("null");
    }
}

public class SinglyLinearLinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(50);
        list.addLast(60);
        list.deleteFirst();
        list.deleteLast();

        list.display();
    }
}