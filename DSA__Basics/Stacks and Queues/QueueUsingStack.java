import java.util.Stack;

// Implementationof Queue using 2(Two) Stacks

public class QueueUsingStack {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public QueueUsingStack() {}

//         Step 1: Enqueue
//         --- Push all elements in s1
//          _________________________________________________
//   s1->  |      10   |      20    |     30     |           |
//         |___________|____________|____________|___________|
// 
    void enqueue(int element){
        st1.push(element);
    }

//         Step 2 : Transfer all elements from s1 to s2
//          _________________________________________________
//   s1->  |           |            |            |           | <-- Empty Stack
//         |___________|____________|____________|___________|
//                                  ^
//                                  |
//          _________________________________________________
//   s2->  |    30     |   20       |   10       |           | <-- The order is reversed. Now 10 is at the top of s2, so it will be removed first
//         |___________|____________|____________|___________|
//    

    int dequeue(){
        if(st1.isEmpty() && st2.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        
        // Transfer elements only when s2 is empty because all the elements in st2 are been added before new elements 
        // and we know that queue follows FIFO
        if(st2.isEmpty()){  // Very Important step
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }


    // Ques - Why we do not push element from st1 to st2 when st2 is not empty?

//          _________________________________________________
//   st1-> |     40    |            |            |           |
//         |___________|____________|____________|___________|
//                              
//          _________________________________________________
//   st2-> |    30     |   20       |   10       |           | 
//         |___________|____________|____________|___________|
//    
//   Now here we are implementing queue so (first in first out) so first all the elements will be popped out from st2 then st1 elements will be added in st2
//   Common Sense !!!!

    int peek(){ // Same pop logic here also
        if(st1.isEmpty() && st2.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        
        // Transfer elements only when s2 is empty because all the elements in st2 are been added before and we know that queue follows FIFO
        if(st2.isEmpty()){  // Very Important step
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    } 


    public static void main(String args[]){
        QueueUsingStack q = new QueueUsingStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println("Element popped Out: "+ q.dequeue());
        q.enqueue(60);
        System.out.println("Element popped Out: "+ q.dequeue());
        System.out.println("Peek Element: "+ q.peek());
        System.out.println("Element popped Out: "+ q.dequeue());
        System.out.println("Element popped Out: "+ q.dequeue());
        System.out.println("Element popped Out: "+ q.dequeue());
        System.out.println("Peek Element: "+ q.peek());
        System.out.println("Element popped Out: "+ q.dequeue());
        System.out.println("Element popped Out: "+ q.dequeue());
    }

}
