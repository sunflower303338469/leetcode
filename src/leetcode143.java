import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/10/20.
 */
public class leetcode143 {
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

    public void reorderList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodeList.add(temp);
            temp = temp.next;
        }
        if (!nodeList.isEmpty()) {
            int l = 0;
            int r = nodeList.size() - 1;
            ListNode p = null;
            while (l < r) {
                if (p != null) {
                    p.next = nodeList.get(l);
                }
                nodeList.get(l).next = nodeList.get(r);
                p = nodeList.get(r);
                p.next = null;
                l++;
                r--;
            }
            if (l==r){
                if (p!=null){
                    p.next = nodeList.get(l);
                    nodeList.get(l).next = null;
                }
            }
        }
    }
}
