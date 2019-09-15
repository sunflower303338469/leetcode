/**
 * Created by xuanmao on 2019/6/18.
 */
public class leetcode61 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode h = head;
        int l = 1;
        if (h==null || k==0){
            return h;
        }
        while (h.next !=null){
            l = l+1;
            h= h.next;
        }
        h.next = head;
        h = head;
        int move = l-k;
        while (move<0){
            move = move+l;
        }
        for (int i=0;i<move;i++){
            head = head.next;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }
}
