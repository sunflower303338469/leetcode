/**
 * Created by xuanmao on 2020/6/8.
 */
public class leetcode110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        check(root);
        return ans;
    }

    private int check(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = check(root.left);
        int right = check(root.right);
        if (Math.abs(left-right)>1){
            ans =false;
        }
        return Math.max(left,right)+1;
    }
}
