/**
 * Created by xuanmao on 2019/2/11.
 */
public class leetcode404 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, false);
    }

    private int getSum(TreeNode root, Boolean isLeft){
         if (root == null){
             return 0;
         }
         if ((root.right == null) && (root.left == null)){
             if (isLeft){
                 return root.val;
             }
             return 0;
         }
         int ans = 0;
         if (root.right != null){
             ans += getSum(root.right, false);
         }
         if (root.left != null){
             ans += getSum(root.left, true);
         }
         return ans;
    }
}
