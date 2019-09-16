/**
 * Created by xuanmao on 2019/8/4.
 */
public class leetcode1145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int xval = 0;
    int nval = 0;
    boolean flag = false;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (n<=2){
            return false;
        }
        xval =x;
        nval = n;
        treeSum(root);
        return flag;
    }

    public int treeSum(TreeNode root){
        if (root == null){
            return 0;
        }
        int lv =  treeSum(root.left);
        int rv = treeSum(root.right);
        int ans = 1 + lv+ rv;
        if (root.val == xval){
            System.out.println(ans+ " "+ lv + " "+ rv);
            if (ans < nval - ans){
                flag = true;
            }
            if (lv > nval - lv){
                flag = true;
            }
            if (rv > nval - rv){
                flag = true;
            }
        }
        return ans;
    }
}
