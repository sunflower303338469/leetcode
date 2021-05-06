/**
 * Created by xuanmao on 2021/3/18.
 */
public class leetcode92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode h = head;
        int count = 1;
        ListNode cutHead = null;
        ListNode cutTail = null;
        ListNode reNode = h;
        while (h != null) {
            if (count == left - 1) {
                cutHead = h;
                reNode = cutHead.next;
            }
            if (count == right) {
                cutTail = h.next;
                h.next = null;
            }
            h = h.next;
            count++;
        }
        ListNode re = reverse(reNode);
        ListNode rr = re;
        while (rr != null) {
            System.out.println(rr.val);

            if (rr.next == null) {
                rr.next = cutTail;
                break;
            }
            rr = rr.next;
        }
        if (cutHead != null) {
            cutHead.next = re;
            return head;
        } else {
            return re;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode a = null;
        ListNode b = head;
        while (b!=null){
            ListNode c = b.next;
            b.next = a;
            a = b;
            b=  c;
        }
        return a;
    }
}
