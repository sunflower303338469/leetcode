/**
 * Created by xuanmao on 2019/6/9.
 */
public class leetcode5084 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int l = 0;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null){
            return null;
        }
        l = limit;
        boolean t = del(root,root.val);
        if (t){
            return null;
        }
        return root;
    }

    private boolean del(TreeNode root, int sum){
        System.out.println(root.val+" "+sum);
        if (root.left==null && root.right ==null && sum<l){
            return true;
        }
        boolean ld = false;
        boolean rd = false;
        if (root.left!=null){
            ld = del(root.left, sum+root.left.val);
            if (ld) {
                System.out.println(root.val+" ld");
                root.left = null;
            }
        }
        if (root.right!=null){
            rd = del(root.right, sum+root.right.val);
            if (rd) {
                System.out.println(root.val+" rd"+sum);
                root.right = null;
            }
        }
        if (root.left==null && root.right ==null && sum<l){
            return true;
        }
        if (ld && rd){
            return true;
        }
        return false;
    }

}
