import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuanmao on 2019/5/13.
 */
public class leetcode144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode nowNode = root;
        while (nowNode != null) {
            ans.add(nowNode.val);
            if (null != nowNode.right){
                stack.add(nowNode.right);
            }
            if (null != nowNode.left){
                nowNode = nowNode.left;
            } else if (!stack.empty()){
                    nowNode = stack.pop();
            } else {
                nowNode = null;
            }
        }
        return ans;
    }
}
