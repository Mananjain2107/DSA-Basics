// TC --> O(1),because every method have time complexity -->O(1)
// SC --> O(N),because we store n nodes in the linked list
class Stack{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }

    Node top = null; // Tracking the topmost Node by the top

    //        Top
    //         |
    //         |
    //        \/
    //  _______________             _______________
    // |   10  |  200  |  ------>  |   20  |  NUll |  ------> Null
    // |_______|_______|           |_______|_______|
    // 100                         200


    // Insert 30 

    //        Top
    //         |
    //         |
    //        \/
    //  _______________             _______________            _________________
    // |   30  |  100  |  ------>  |   10  |  200  |  ------>  |   20  |  Null | -----> Null
    // |_______|_______|           |_______|_______|           |_______|_______|
    // 300                         100                         200  (NewNode)

    // Insertion(Same as addFirst() in singular linked list)
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }



    //                                     Top
    //                                      |
    //                                      |
    //  (Not considering                    |
    //    this Node)                       \/
    //  _______________             _______________            _________________
    // |   30  |  200  |  ------>  |   10  |  300  |  ------>  |   20  |  Null | -----> Null
    // |_______|_______|           |_______|_______|           |_______|_______|
    // 300  

    // Deletion(Same as deleteFirst())
    public int pop(){
        if(top==null){
            System.out.println("Stack is Empty!");
            return -1;
        }
        int value = top.data;
        top = top.next;

        return value;
    }

    public int peek(){
        if(top==null){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public void display(){
        Node temp = top;

        while(temp!=null){
            System.out.print(temp.data+ " -> ");
            temp=temp.next;
        }
        System.out.print("null");
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        // st.pop();
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
        st.display();
    }
}
