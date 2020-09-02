/**
 * Created by xuanmao on 2020/5/31.
 */
public class leetcode101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right){
        if ((left==null) && (right==null)){
            return true;
        }
        if ((left==null) || (right==null)){
            return false;
        }
        return (left.val == right.val) && check(left.left, right.right) && check(left.right, right.left);
    }
}
