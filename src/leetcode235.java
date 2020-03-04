/**
 * Created by xuanmao on 2020/1/16.
 */
public class leetcode235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode ansNode = null;
    TreeNode pp, qq;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pp = p;
        qq = q;
        dfs(root);

        return ansNode;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int count = ((root == pp) || (root == qq)) ? 1 : 0;
        count += dfs(root.left);
        count += dfs(root.right);
        if ((count == 2) && (ansNode == null)){
            ansNode = root;
        }
        return count;
    }


}
