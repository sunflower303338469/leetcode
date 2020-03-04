import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/16.
 */
public class leetcode515 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<Integer> ans = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode root, int level){
        if (root == null){
            return;
        }
        if (ans.size()-1<level){
            ans.add(root.val);
        } else {
            ans.set(level, Math.max(ans.get(level), root.val));
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
