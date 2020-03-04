/**
 * Created by xuanmao on 2019/12/31.
 */
public class leetcode998 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val<val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
