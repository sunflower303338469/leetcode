/**
 * Created by xuanmao on 2020/10/13.
 */
public class leetcode24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode finalHead = head.next;
        ListNode before = null;
        while ((head != null) && (head.next != null)) {
            ListNode p = head.next;
            if (before != null) {
                before.next = p;
            }
            head.next = p.next;
            p.next = head;
            before = head;
            head = head.next;
        }
        return finalHead;
    }
}
