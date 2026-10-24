import java.util.LinkedList;
import java.util.Queue;

// Implementing Stack Using Queue
// TC -> O(1) for every opertion except push() as it takes O(N) because we need move all existing elements behind the new element, 
// as we need to make queue as stack

// SC -> O(N), because the queue stores all n elements

// In this Approach the most important or tricky thing is how we perform the push operation

public class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    public StackUsingQueue() {}


//          _________________________________________________
//         |      10   |      20    |            |           |
//         |___________|____________|____________|___________|
// 

//         1) Add 30 into the queue 
//          _________________________________________________
//         |      10   |      20    |     30     |           |
//         |___________|____________|____________|___________|
// 


//         2) Remove 10 and add it to the rare
//          _________________________________________________
//         |      20   |      30    |     10     |           |   
//         |___________|____________|____________|___________|
// 

//         3) Remove 20 and add it to the rare
//          _________________________________________________
//         |      30   |      10    |     20     |           |
//         |___________|____________|____________|___________|
//
//         ** Now 30 is at the front, so the queue behaves like a stack **



    void push(int element){
        q.offer(element); // Insert an element into the stack

        // Move all previous elements behind the new element[10,20]
        int n = q.size()-1;

        for(int i=0;i<n;i++){
            q.offer(q.remove());  // removing the peek element or top element and now when it will be added back it will be behind the new element
                                  // so, here we can see that our queue works like a stack
        }
    }

    int pop(){
        if(q.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return q.remove();
    }
    
    int top(){
        if(q.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return q.peek();
    }

    boolean isEmpty(){
        return q.isEmpty();
    }


    public static void main(String args[]){
        StackUsingQueue st = new StackUsingQueue(); // why error coming here
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.isEmpty());
    }
}
