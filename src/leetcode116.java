import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xuanmao on 2019/2/17.
 */
public class leetcode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        List<Node> nodeList = new ArrayList<>();
        int head = 0;
        int jumpNum = 0;
        nodeList.add(root);
        while (head<nodeList.size()){
            Node nowNode = nodeList.get(head);
            if (nowNode.right != null){
                nodeList.add(nowNode.right);
            }
            if (nowNode.left != null){
                nodeList.add(nowNode.left);
            }
            if (jumpNum == head){
                nowNode.next = null;
                jumpNum = jumpNum *2 +1;
            } else {
                nowNode.next = nodeList.get(head-1);
                System.out.println("root:"+ nowNode.val + " next:"+nowNode.next.val);
            }
            head = head +1;
        }
        return root;
    }
}
