/**
 * Created by xuanmao on 2021/1/10.
 */
public class leetcode445 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode ans = null;
        int x = 0;
        while(l1!=null || l2!=null || x!=0){
            ListNode now = new ListNode(x);
            if (l1!=null){
                now.val+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                now.val+=l2.val;
                l2=l2.next;
            }
            x = now.val/10;
            now.val=now.val%10;
            now.next= ans;
            ans = now;
        }
        return ans;
    }

    private ListNode reverse(ListNode head) {
        ListNode re = null;
        while (head != null) {
            ListNode temp = head;
            head  = head.next;
            temp.next= re;
            re = temp;
        }
        return re;
    }
}
