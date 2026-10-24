// Implementing Circular Queue using an array , TC->O(1) except display() which takes o(N),in worst case
// SC->O(Size of the array)

//                    _________________________________________________
//    front = -1     |    1      |      2     |     3      |      4    |
//    rear = -1      |___________|____________|____________|___________|


public class QueueByArray {
    int size ;
    int arr[];
    int front;
    int rear;

    public QueueByArray(int size) {
        this.size = size;
        arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

//          Before Enqeueue
//          _________________________________________________
//         |           |            |     3      |      4    |
//         |___________|____________|____________|___________|
//                                        ^             ^       
//                                        |             |
//                                  front = 2(index)  rear = 3(index)

//          After Enqeueue
//          _________________________________________________
//         |     5     |            |     3      |      4    |      rear = (rear + 1) % size
//         |___________|____________|____________|___________|      rear = (3+1) % 4 = 0 (so new element(5) will be added at index 0)
//                ^                        ^                  
//                |                        |             
//            rear=1(index)           front = 2(index)  

    void enqueue(int element){
        if((rear+1)%size==front){    // Full condition: (rear + 1) % size == front
            System.out.println("Stack Overflow");  
            return; 
        }

        if(front==-1){ // Empty condition: front == -1
            front =0; // Initally we have have front and rear as -1 but after first insertion we set front as 0
        }
        rear = (rear+1)%size; // Circular movement
        arr[rear] = element;
    }


//          Before Dequeue
//          _________________________________________________
//         |           |            |     3      |      4    |
//         |___________|____________|____________|___________|
//                                        ^             ^       
//                                        |             |
//                                  front = 2(index)  rear = 3(index)

//          After Dequeue
//          _________________________________________________
//         |           |            |     3      |      4    |      front = (front + 1) % size
//         |___________|____________|____________|___________|      front = (2+1) % 4 = 3
//                                                 ^       ^               
//                                                 |       |          
//                                      front = 3(index)  rear = 3(index)



    int dequeue(){
        if(front == -1){
            System.out.println("Stack Underflow");
            return -1;
        }

        int data = arr[front];

        if(front==rear){ // when front and rear are at same index then we set front and rear as -1, but front and rear should be at same index before pop if they are at different index and ater pop then come on same inde and above shown thn no need to set the values to -1 
            front = -1;
            rear = -1;
        }
        else{
            // Move front to the next index using circular movement
            front = (front+1)%size;
        }
        return data;
    }



    int peek(){
        if(front == -1){
            System.out.println("No element is the Stack");
            return -1;
        }
        return arr[front];
    }


    boolean isEmpty(){
        return front == -1;
    }

    boolean isFull(){
        return (rear+1) % size== front; // Full condition
    }

    void display(){
        if(front==-1){
            System.out.println("Queue is Empty!");
            return;
        }

        int i = front;
        while(true){
            System.out.print(arr[i]+" ");

            if(i == rear){
                break;
            }

            i = (i+1)%size;
        }
        System.out.println();
    }


    public static void main(String args[]){
        QueueByArray q = new QueueByArray(4);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.isEmpty();
        q.display();
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isFull());
    }


}
