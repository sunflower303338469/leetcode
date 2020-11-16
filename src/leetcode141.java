/**
 * Created by xuanmao on 2020/10/9.
 */
public class leetcode141 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode a = head;
        ListNode b=  head.next;
        while (a!=b){
            if ((a==null)||(b==null)){
                return false;
            }
            a=a.next;
            b=b.next;
            if(b==null){
                return false;
            }
            b= b.next;
        }
        return true;
    }
}
