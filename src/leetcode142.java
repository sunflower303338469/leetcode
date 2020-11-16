/**
 * Created by xuanmao on 2020/10/10.
 */
public class leetcode142 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode a = head;
        ListNode b=  head;
        ListNode c=  head;
        do {
            if ((a==null)||(b==null)){
                return null;
            }
            a=a.next;
            b=b.next;
            if(b==null){
                return null;
            }
            b= b.next;
        } while (a!=b);
        while (a!=c){
            a=a.next;
            c=c.next;
        }
        return c;
    }
}
