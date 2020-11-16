/**
 * Created by xuanmao on 2020/9/21.
 */
public class leetcode538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }


    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        root.val = root.val + max;
        max = root.val;
        dfs(root.left);
    }
}
