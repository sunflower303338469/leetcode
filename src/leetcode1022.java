/**
 * Created by xuanmao on 2020/3/10.
 */
public class leetcode1022 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode root, int value){
        value = value *2+root.val;
        if ((root.left==null) && (root.right == null)){
            ans +=value;
            return;
        }
        if (root.left!=null){
            dfs(root.left,value);
        }
        if (root.right!=null){
            dfs(root.right,value);
        }
    }
}
