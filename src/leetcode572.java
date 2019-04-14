/**
 * Created by xuanmao on 2019/1/27.
 */
public class leetcode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return check(s, t, true);
    }

    private Boolean check(TreeNode s, TreeNode t, Boolean isHead){
        if (null == s){
            return null == t;
        }
        if (null == t){
            return false;
        }

        Boolean re = false;
        if (s.val == t.val) {
            Boolean left = check(s.left, t.left,false);
            Boolean right = check(s.right, t.right, false);
            re = left && right;
        }
        if (isHead){
            if (s.left != null){
                re = re || check(s.left, t, true);
            }
            if (s.right != null){
                re = re || check(s.right, t, true);
            }
        }
        return re;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
