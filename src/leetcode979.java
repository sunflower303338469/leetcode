/**
 * Created by xuanmao on 2019/6/27.
 */
public class leetcode979 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int sum = 0;

    public int distributeCoins(TreeNode root) {
        recursive(root);
        return sum;
    }

    private int recursive(TreeNode root){
        if (null == root){
            return 0;
        }

        int left = recursive(root.left);
        int right = recursive(root.right);
        sum += Math.abs(left)+ Math.abs(right);
        return left+right+root.val-1;
    }
}
