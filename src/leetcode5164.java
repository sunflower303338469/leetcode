import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/8/25.
 */
public class leetcode5164 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode h = head;
        ListNode re = null;
        ListNode fore = null;
        while (h!=null){
            if (h.val != 0){
                int sum = h.val;
                ListNode r = re;
                while(r!=null){
                    sum = sum+ r.val;
                    if (sum ==0){
                        re = r.next;
                        break;
                    } else {
                        r = r.next;
                    }
                }
                if (sum !=0){
                    ListNode newRe = new ListNode(h.val);
                    newRe.next = re;
                    re = newRe;
                }
            }
            h = h.next;
        }
        ListNode ans = null;
        while (re!=null){
            ListNode newNode = new ListNode(re.val);
            newNode.next = ans;
            ans = newNode;
            re = re.next;
        }
        return ans;
    }
}
