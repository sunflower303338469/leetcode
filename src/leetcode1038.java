/**
 * Created by xuanmao on 2019/5/5.
 */
public class leetcode1038 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode bstToGst(TreeNode root) {
        sum1(root,0);
        return root;
    }

    private int sum1(TreeNode root,int v){
        int sum = 0;
        int before = root.val;
        if (null != root.right){
            root.val = root.val+sum1(root.right,v);
        }
        sum = root.val;
        root.val = root.val +v;
        System.out.println(before+" "+root.val);
        if (null != root.left){
            sum = sum + sum1(root.left, root.val);
        }
        return sum;
    }
}
