import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode5119 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    List<TreeNode> ans = new ArrayList<>();
    boolean[] isDelete = new boolean[1001];
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root==null){
            return ans;
        }
        for (int i=0;i<to_delete.length;i++){
            isDelete[to_delete[i]] = true;
        }

        tr(root, true);
        return ans;
    }
    private TreeNode delete(TreeNode root){
        if (root==null){
            return root;
        }
        if (isDelete[root.val]){
            ans.add(delete(root.left));
            ans.add(delete(root.right));
        }
        if ((root.left!=null) && (isDelete[root.left.val])){
            ans.add(delete(root.left));
            root.left = null;
        }
        if ((root.right!=null) && (isDelete[root.right.val])){
            ans.add(delete(root.right));
            root.right = null;
        }
        delete(root.left);
        delete(root.right);
        return root;
    }

    private void tr(TreeNode root, boolean tag){
        if ((root!=null) && (!isDelete[root.val]) && (tag)){
            ans.add(root);
        }
        if (root==null){
            return;
        }
        if (isDelete[root.val]){
            tr(root.left, true);
            tr(root.right, true);
        } else{
            tr(root.left, false);
            tr(root.right, false);
        }
        if ((root.left!=null) && (isDelete[root.left.val])){
            root.left = null;
        }
        if ((root.right!=null) && (isDelete[root.right.val])){
            root.right = null;
        }
    }
}
