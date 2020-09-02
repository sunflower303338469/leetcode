/**
 * Created by xuanmao on 2020/6/16.
 */
public class leetcode1026 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int min, int max){
        if (root==null){
            return;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        ans = Math.max(ans, max-min);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
