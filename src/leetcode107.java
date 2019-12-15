import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/7.
 */
public class leetcode107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return ans;
        }
        dfs(root, 0);
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(TreeNode root, int level){
        if (level>=ans.size()){
            ans.add(new ArrayList<>());
        }
        List<Integer> list = ans.get(level);
        list.add(root.val);
        if (root.left!=null){
            dfs(root.left, level+1);
        }
        if (root.right!=null){
            dfs(root.right, level+1);
        }
    }
}
