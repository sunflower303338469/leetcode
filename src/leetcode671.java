/**
 * Created by xuanmao on 2019/8/12.
 */
public class leetcode671 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int findSecondMinimumValue(TreeNode root) {
        if ((root == null) || (root.left == null)){
            return -1;
        }
        int p = -1;
        if (root.left.val<root.right.val){
            p = findSecondMinimumValue(root.left);
            if (p==-1){
                return root.right.val;
            }
            if (p<root.right.val){
                return p;
            } else {
                return root.right.val;
            }
        } else if (root.right.val< root.left.val){
            p = findSecondMinimumValue(root.right);
            if (p==-1){
                return root.left.val;
            }
            if (p<root.left.val){
                return p;
            } else {
                return root.left.val;
            }
        } else {
            int x = findSecondMinimumValue(root.left);
            int y = findSecondMinimumValue(root.right);
            if (x==-1){
                return y;
            }
            if (y==-1){
                return x;
            }
            return Math.min(x,y);
        }
    }
}
