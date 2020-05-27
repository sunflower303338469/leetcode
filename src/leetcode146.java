import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/5/25.
 */
public class leetcode146 {
    class LRUCache {

        class Node {
            Node next;
            Node before;
            int key;
            int value;
        }

        Map<Integer, Node> map = new HashMap<>();

        int count = 0;
        int capacity;
        Node head = null;
        Node tail = null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node now = map.get(key);
            if (now == null) {
                return -1;
            }
            putToHead(now, false);

            pr();
            return now.value;
        }

        public void put(int key, int value) {
            Node now = map.get(key);
            if (now != null) {
                now.value = value;
                putToHead(now, false);
                pr();
                return;
            }

            if (count == capacity) {
                if (count == 1) {
                    map.remove(tail.key);
                    tail = null;
                    head = null;
                } else {
                    tail.before.next = null;
                    map.remove(tail.key);
                    tail = tail.before;
                }
            } else {
                count++;
            }
            Node node = new Node();
            node.value = value;
            node.key = key;
            putToHead(node, true);
            map.put(key, node);
            pr();
        }

        private void putToHead(Node node, boolean newNode) {
            if (newNode) {
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    head.before = node;
                    node.next = head;
                    head = node;
                }
                return;
            }

            if (node.before != null) {
                node.before.next = node.next;
                if (node.next == null) {
                    tail = node.before;
                } else {
                    node.next.before = node.before;
                }
                head.before = node;
                node.next = head;
                head = node;
                node.before = null;
            }
        }

        private void pr() {
            Node h = head;
            while (h != null) {
                System.out.print("("+ h.key+"."+h.value + ") ");
                h = h.next;
            }
            System.out.println();
        }
    }


}
