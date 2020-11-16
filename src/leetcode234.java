/**
 * Created by xuanmao on 2020/10/25.
 */
public class leetcode234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            count++;
        }
        if (count <= 1) {
            return true;
        }
        if (count == 2) {
            return head.val == head.next.val;
        }
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;
        a.next=null;
        for (int i = 0; i < count / 2-1; i++) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        if (count%2!=0){
            b = b.next;
        }
        while ((a!=null) && (b!=null)){
            if (a.val != b.val){
                return false;
            }
            a =a.next;
            b=b.next;
        }
        return true;
    }
}
