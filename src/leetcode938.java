/**
 * Created by xuanmao on 2019/1/25.
 */



public class leetcode938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        if (R < root.val){
            return rangeSumBST(root.left, L, R);
        }
        if (L > root.val){
            return rangeSumBST(root.right, L, R);
        }
        int leftVal = 0;
        int rightVal = 0;
        if ((root.val > L) && (root.left != null)){
            leftVal = rangeSumBST(root.left, L, root.val);
        }
        if ((root.val < R) && (root.right != null)){
            rightVal = rangeSumBST(root.right, root.val, R);
        }
        return leftVal + rightVal + root.val;
    }
}
