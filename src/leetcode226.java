/**
 * Created by xuanmao on 2020/2/16.
 */
public class leetcode226 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode rootLeft = root.left;
        root.left = root.right;
        root.right = rootLeft;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
