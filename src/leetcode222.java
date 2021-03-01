/**
 * Created by xuanmao on 2020/11/24.
 */
public class leetcode222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode n = root;
        int nn = 1;
        while (n != null) {
            n = n.left;
            nn = nn * 2;
        }
        int l = nn / 2;
        int r = nn - 1;
        while (l < r) {
            int k = (l + r + 1) / 2;
            if (check(k, root, nn)) {
                l = k;
            } else {
                r = k - 1;
            }
        }
        return l;
    }

    private boolean check(int value, TreeNode root, int nn) {
        int l = nn / 2;
        int r = nn - 1;
        while (root != null) {
            int k = (l+r)/2;

            if (k>=value){
                root = root.left;
                r = k;
            } else {
                root = root.right;
                l = k+1;
            }
            if ((l==r) && (root!=null)){
                return true;
            }
        }
        return false;
    }
}
