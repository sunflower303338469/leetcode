import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/8/27.
 */
public class leetcode117 {
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
        if (root == null) {
            return null;
        }
        List<Node> lastList = new ArrayList<>();
        lastList.add(root);
        List<Integer> levelList = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        levelList.add(0);
        nodeList.add(root);
        int l = 0;
        while (l < nodeList.size()) {
            Node node = nodeList.get(l);
            Integer level = levelList.get(l);
            if (node.left != null) {
                nodeList.add(node.left);
                levelList.add(level + 1);
                if (lastList.size() <= level + 1) {
                    lastList.add(node.left);
                } else {
                    Node temp = lastList.get(level + 1);
                    temp.next = node.left;
                    lastList.set(level + 1, node.left);
                }
            }
            if (node.right != null) {
                nodeList.add(node.right);
                levelList.add(level + 1);
                if (lastList.size() <= level + 1) {
                    lastList.add(node.right);
                } else {
                    Node temp = lastList.get(level + 1);
                    temp.next = node.right;
                    lastList.set(level + 1, node.right);
                }
            }
            l++;
        }
        return root;
    }
}
