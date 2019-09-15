/**
 * Created by xuanmao on 2019/4/19.
 */
public class leetcode83 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = head;
        if (head == null){
            return head;
        }
        while (now.next != null){
            if (now.next.val == now.val){
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
        return head;
    }

}
