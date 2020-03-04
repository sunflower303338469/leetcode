/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode111 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if ((root.left == null) && (root.right==null)) {
            return 1;
        }
        if (root.left==null){
            return minDepth(root.right)+1;
        }
        if (root.right == null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
