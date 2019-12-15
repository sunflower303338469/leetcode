/**
 * Created by xuanmao on 2019/10/27.
 */
public class leetcode965 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    Integer value = null;
    public boolean isUnivalTree(TreeNode root) {
        return check(root);
    }

    private boolean check(TreeNode root){
        if (root == null){
            return true;
        }
        if (value == null){
            value = root.val;
        }
        if (root.val!=value){
            return false;
        }
        return check(root.left) && check(root.right);
    }
}
