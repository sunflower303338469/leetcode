import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/4.
 */
public class leetcode257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> ansList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, ""+root.val);
        return ansList;
    }

    private void dfs(TreeNode root, String s){
        if ((root.left==null) &&(root.right==null)){
            ansList.add(s);
        }
        if (root.left!=null){
            dfs(root.left, s+"->"+root.left.val);
        }
        if (root.right!=null){
            dfs(root.right, s+"->"+root.right.val);
        }

    }
}
