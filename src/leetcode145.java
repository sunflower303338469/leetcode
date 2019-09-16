import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuanmao on 2019/8/14.
 */
public class leetcode145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> p = new ArrayList<>();
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            while (node != null) {
                p.add(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                node = node.right;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = p.size() - 1; i >= 0; i--) {
            ans.add(p.get(i));
        }
        return ans;
    }
}
