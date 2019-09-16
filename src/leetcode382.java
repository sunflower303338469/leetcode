/**
 * Created by xuanmao on 2019/8/18.
 * 水库抽样算法求随机
 */
public class leetcode382 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    class Solution {

        ListNode head;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int n = 0;
            ListNode node= head;
            int ans =0;
            while (node!=null){
                n++;
                double rand = Math.random();
                if (rand<(1.0/n)){
                    ans = node.val;
                }
                node = node.next;
            }
            return ans;
        }
    }
}
