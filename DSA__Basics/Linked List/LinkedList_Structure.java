public class LinkedList_Structure { // Outer Class
    static class Node{ // Inner class
        private int data;
        private Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }

    private Node head;

    public LinkedList_Structure(){
        head=null;
    }

    public void addLast(){}
    public void addFirst(){}
    public void addPosition(){}
    public void deleteFirst(){}
    public void deleteLast(){}
    public void display(){}
}
