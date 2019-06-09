/**
 * Created by xuanmao on 2019/6/6.
 */
public class leetcode817 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        boolean flag = false;
        boolean[] num = new boolean[10010];
        for (int i = 0; i < G.length; i++) {
            num[G[i]] = true;
        }
        int ans = 0;
        while (head != null) {
            if (flag) {
                if (!num[head.val]) {
                    ans++;
                    flag = false;
                }
            } else {
                if (num[head.val]) {
                    flag = true;
                }
            }
            head = head.next;
        }
        if (flag) {
            ans++;
        }
        return ans;
    }
}
