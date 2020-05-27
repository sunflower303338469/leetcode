/**
 * Created by xuanmao on 2020/5/26.
 */
public class leetcode1457 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int[] count = new int[10];
    int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        count[root.val]++;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if ((root.left == null) && (root.right == null)) {
            int odd = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] % 2 != 0) {
                    odd++;
                }
            }
            if (odd <= 1) {
                ans++;
            }
        }
        if (root.left != null) {
            count[root.left.val]++;
            dfs(root.left);
            count[root.left.val]--;
        }
        if (root.right != null) {
            count[root.right.val]++;
            dfs(root.right);
            count[root.right.val]--;
        }
    }
}
