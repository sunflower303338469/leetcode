import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/4/12.
 */
public class leetcode82 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = head;
        ListNode start = null;
        boolean delete = false;
        while (now != null){
            if ((now.next != null) &&(now.next.val == now.val)){
                delete = true;
            } else {
                if (delete){
                    if (start == null){
                        head = now.next;
                    } else {
                        start.next = now.next;

                    }
                    delete = false;
                } else {
                    start = now;
                }
            }
            now = now.next;
        }
        return head;
    }
}
