/**
 * Created by xuanmao on 2020/11/17.
 */
public class leetcode328 {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        boolean isOdd = true;
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = null;
            if (isOdd) {
                if (oddHead == null) {
                    oddHead = head;
                } else {
                    oddTail.next = head;
                }
                oddTail = head;
            } else {
                if (evenHead == null) {
                    evenHead = head;
                } else {
                    evenTail.next = head;
                }
                evenTail = head;
            }
            isOdd = !isOdd;
            head = nextHead;
        }
        oddTail.next = evenHead;
        return oddHead;
    }
}
