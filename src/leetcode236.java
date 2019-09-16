/**
 * Created by xuanmao on 2019/8/27.
 */
public class leetcode236 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    TreeNode ans;
    int left = 2;
    TreeNode p,q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        find(root);
        return ans;
    }

    private void find(TreeNode root){
        int begin = left;

        if (root.left!=null){
            find(root.left);
        }
        int afterL = left;
        if (root.right!=null){
            find(root.right);
        }
        int afterR = left;
        if ((root.val == p.val)|| (root.val == q.val)){
            left--;
        }
        int fi = left;
        if ((begin==2) && (fi ==0 ) && (afterL!=0) && (afterL-afterR!=2)){
            ans = root;
        }
    }
}
