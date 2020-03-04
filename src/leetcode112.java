/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if ((root.left == null) && (root.right==null)) {
            return root.val == sum;
        }

        if (root.left==null){
            return hasPathSum(root.right, sum-root.val);
        }
        if (root.right==null){
            return hasPathSum(root.left, sum-root.val);
        }
        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
    }
}
