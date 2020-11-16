/**
 * Created by xuanmao on 2020/10/18.
 */
public class leetcode19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = null;
        while (node1 != null) {
            if (n == 0) {
                node2 = head;
            } else {
                if (node2 != null) {
                    node2 = node2.next;
                }
            }
            n--;
            node1 = node1.next;
        }
        if (node2 == null) {
            head = head.next;
        } else {
            node2.next = node2.next.next;
        }

        return head;
    }
}
