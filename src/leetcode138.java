import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/8/14.
 */
public class leetcode138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public Node copyRandomList(Node head) {
        Node h = head;
        Map<Node, Node> yingshe = new HashMap<>();
        while (h!=null){
            Node newNode = new Node();
            newNode.val = h.val;
            yingshe.put(h, newNode);
            h= h.next;
        }
        h = head;
        while (h!=null){
            Node newNode = yingshe.get(h);
            if (h.next != null){
                Node p  = yingshe.get(h.next);
                newNode.next = p;
            }
            if (h.random!=null){
                Node p  = yingshe.get(h.random);
                newNode.random = p;
            }
            h= h.next;
        }
        return yingshe.get(head);
    }
}
