/**
 * Created by xuanmao on 2019/8/14.
 */
public class leetcode86 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallhead = null;
        ListNode bighead = null;
        ListNode smalltail = null;
        ListNode bigtail = null;
        while (head != null) {
            if (head.val < x) {

                if (smalltail == null) {
                    smalltail = head;
                    smallhead = head;
                } else {
                    smalltail.next = head;
                    smalltail = head;
                }

            } else {
                if (bigtail == null) {
                    bigtail = head;
                    bighead = head;
                } else {
                    bigtail.next = head;
                    bigtail = head;
                }
            }
            head = head.next;
        }
        if ((smallhead == null) && (bighead==null)){
            return null;
        }
        if (smallhead == null){
            return bighead;
        }
        smalltail.next = bighead;
        if (bigtail !=null){
            bigtail.next = null;
        }
        return smallhead;
    }

}
