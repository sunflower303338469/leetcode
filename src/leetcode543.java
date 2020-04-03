/**
 * Created by xuanmao on 2020/3/10.
 */
public class leetcode543 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = 0;
        int count= 0;
        if (root.left!=null){
            int leftDepth = dfs(root.left);
            depth = Math.max(depth, leftDepth);
            count = leftDepth;
        }
        if (root.right!= null){
            int rightDepth = dfs(root.right);
            depth = Math.max(depth, rightDepth);
            count = count + rightDepth;
        }
        ans = Math.max(ans, count);
        return depth+1;

    }
}
