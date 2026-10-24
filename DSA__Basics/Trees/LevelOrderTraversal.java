import java.util.*;

// Level Order Traversal (BFS)
// TC -> O(N) SC-> O(N)

public class LevelOrderTraversal {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public List<List<Integer>> bfs(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> q = new LinkedList<>(); // using queue data structure to store the nodes
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size(); //levelSize stores the number of nodes at the current level
            List<Integer> ls = new ArrayList<>();

            for (int i=0;i<levelSize;i++) {

                Node curr = q.poll(); // Remove front node from queue

                ls.add(curr.data);

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            result.add(ls);
        }

        return result;
    }

    public static void main(String[] args) {

        LevelOrderTraversal n = new LevelOrderTraversal();

        Node root = n.new Node(1);
        root.left = n.new Node(2);
        root.right = n.new Node(3);
        root.left.left = n.new Node(4);
        root.left.right = n.new Node(5);
        root.right.left = n.new Node(6);
        root.right.right = n.new Node(7);

        List<List<Integer>> result = n.bfs(root);

        System.out.println(result);
    }
}
