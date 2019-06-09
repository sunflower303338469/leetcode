/**
 * Created by xuanmao on 2019/5/22.
 */
public class leetcode337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        int ans = getRob(root, true);
        ans =Math.max(ans, getRob(root, false));
        return ans;
    }

    private int getRob(TreeNode root, boolean canGetRoot){
        if ((root.left == null) && (root.right==null)){
            if (canGetRoot){
                return root.val;
            }  else {
                return 0;
            }
        }
        int ans = 0;
        if (root.right != null){
            if (canGetRoot){
                ans = ans + getRob(root.right,false);
            } else {
                ans = ans + Math.max(getRob(root.right, true), getRob(root.right,false));
            }
        }
        if (root.left != null){
            if (canGetRoot){
                ans = ans + getRob(root.left,false);
            } else {
                ans = ans + Math.max(getRob(root.left, true), getRob(root.left,false));
            }
        }
        if (canGetRoot){
            ans = ans + root.val;
        }
        return ans;
    }
}
