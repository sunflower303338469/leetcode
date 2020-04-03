/**
 * Created by xuanmao on 2020/3/5.
 */
public class leetcode623 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d==1){
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;
        }
        dfs(root, 1, v, d);
        return root;
    }

    private void dfs(TreeNode root, int nowDepth, int value, int depth){
        if (root == null){
            return;
        }
        if (nowDepth==depth-1){
            TreeNode leftNode= new TreeNode(value);
            TreeNode rightNode = new TreeNode(value);
            leftNode.left = root.left;
            rightNode.right = root.right;
            root.left = leftNode;
            root.right = rightNode;
        }
        dfs(root.left, nowDepth+1, value, depth);
        dfs(root.right, nowDepth+1, value, depth);

    }
}
