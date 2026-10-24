// Implementing Stack using an array , TC->O(1) SC->O(Size of the array)
// A stack implemented using an array provides fast operations, but its main disadvantage is its fixed capacity as arrays have fixed size
// they do not have dynamic size
//                 _________________________________________________
//    top =-1     |    1      |      2     |     3      |      4    |
//                |___________|____________|____________|___________|


public class StackByArray {
//     Declare an array and a top variable
//      --- Create an array to store stack elements.
//      --- Initialize top = -1, indicating that the stack is empty.
    int size;
    int arr[];
    int top;

    StackByArray(int size){
        this.size = size;
        arr = new int[size];
        this.top = -1;
    }


//     Push operation (Insertion): To insert an element into the stack:
//      --- 1. Check whether top == arr.length - 1. If true, the stack is full (overflow).
//      --- 2. Otherwise, increment top by 1.
//      --- 3. Insert the element at arr[top].

    void push(int element){
        if(top==arr.length-1){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top]=element;
    }


//       Pop operation (Deletion): To remove the top element:
//       --- 1. Check whether top == -1. If true, the stack is empty (underflow).
//       --- 2. Otherwise, retrieve the element at arr[top].
//       --- 3. Decrement top by 1.

    int pop(){
        if(top==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        int data = arr[top]; // step 2 first retrieve the element and then do top--
        top--;
        return data;
    }


//         Peek operation: To view the top element without removing it:
//         --- 1. Check whether top == -1.
//         --- 2. If not empty, return arr[top].

    int peek(){
        if(top==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top];
    }



//         Check whether the stack is empty
//          --- If top == -1, the stack is empty.
//          --- Otherwise, it contains at least one element
    boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    int size(){
        return top+1;
    }

    void display(){
        if(top==-1){
            System.out.println("Stack is Empty");
            return;
        }

        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        StackByArray s1= new StackByArray(5);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);
        System.out.println(s1.pop());
        System.out.println(s1.peek());
        System.out.println(s1.isEmpty());
        System.out.println(s1.size());
        s1.display();
    }
}
