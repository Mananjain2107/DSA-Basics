import java.util.*;

public class Basics {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }

        // =======RECURSIVE APPROACHES=======
        // a) Preorder Traversal
        // TC-> O(N) , SC->O(height of the tree)[in worst case like skewed tree the height of the tree can be n]
        void preorder(Node n1){
            if(n1 == null){
                return;
            }
            System.out.print(n1.data);
            preorder(n1.left);
            preorder(n1.right);
        }

        // b) Inorder Traversal
        // TC-> O(N) , SC->O(height of the tree)[in worst case like skewed tree the height of the tree can be n]
        void inorder(Node n1){
            if(n1 == null){
                return;
            }
            inorder(n1.left);
            System.out.print(n1.data);
            inorder(n1.right);
        }

        //c) PostOrder Traversal
        // TC-> O(N) , SC->O(height of the tree)[in worst case like skewed tree the height of the tree can be n]
        void postorder(Node n1){
            if(n1 == null){
                return;
            }
            postorder(n1.left);
            postorder(n1.right);
            System.out.print(n1.data);
        }
    }

    // =======ITERATIVE APPROACHES=======
        // a) Preorder Traversal
        // TC-> O(N) , SC->O(height of the tree)[in worst case like skewed tree the height of the tree can be n]
    public static void iterativePreorder(Node root,ArrayList<Integer> ls){
        Stack<Node> st = new Stack<>();
        
        st.add(root);

        while(!st.isEmpty()){
            Node curr = st.pop();

            ls.add(curr.data);// Visit the current node by adding its data to ans

            // Push the right child first because the stack follows LIFO (Last In, First Out). This ensures the left child is processed first 
            if(curr.right!=null){  
                st.add(curr.right);
            }

            // Push the left child second so that it is popped and processed first.
            if(curr.left!=null){
                st.add(curr.left);
            }
        }
    }

     // a) Inorder Traversal
        // TC-> O(N) , SC->O(height of the tree)[in worst case like skewed tree the height of the tree can be n]
    public static void iterativeInorder(Node root,ArrayList<Integer> ls){
        Stack<Node> st = new Stack<>();

        Node curr = root;
        while(true){
            if(curr!=null){
                st.add(curr);
                curr=curr.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                curr=st.pop();
                ls.add(curr.data);
                curr=curr.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left= new Node(6);
        root.right.right = new Node(7);

        System.out.println("=======Recursive Traversals=======");
        System.out.println();

        System.out.print("Recursive Preorder: ");
        root.preorder(root);
        System.out.println();

        System.out.print("Recursive Inorder: ");
        root.inorder(root);
        System.out.println();

        System.out.print("Recursive Postorder : ");
        root.postorder(root);
        System.out.println();

        System.out.println();
        System.out.println("==========Iterative Traversal=========");
        System.out.println();

        ArrayList<Integer> preorder = new ArrayList<>();
        System.out.print("Preorder Iterative: ");
        iterativePreorder(root, preorder);
        System.out.println(preorder);

        ArrayList<Integer> inorder = new ArrayList<>();
        System.out.print("Inorder Iterative: ");
        iterativeInorder(root, inorder);
        System.out.println(inorder);
    }
}
