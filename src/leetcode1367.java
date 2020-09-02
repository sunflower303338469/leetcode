/**
 * Created by xuanmao on 2020/6/12.
 */
public class leetcode1367 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root, true);
    }

    private boolean dfs(ListNode head, TreeNode root, boolean ishead){
        if ((head==null) && (root==null)){
            return true;
        }
        if ((head==null) || (root==null)){
            return false;
        }

        boolean ans = false;
        if (ishead){
            ans = ans || dfs(head,root.left, true) || dfs(head, root.right, true);
        }
        if (head.val==root.val){
            if (head.next==null){
                return true;
            }
            ans  = ans || dfs(head.next, root.left, false) || dfs(head.next,root.right, false);
        }
        return ans;
    }
}
