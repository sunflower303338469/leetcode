import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanmao on 2019/8/14.
 */
public class leetcode653 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        List<TreeNode> que = new ArrayList<>();
        que.add(root);
        int l = 0;
        while (l<que.size()){
            TreeNode node = que.get(l);
            if (set.contains(node.val)){
                return true;
            }
            set.add(k-node.val);
            if (node.left !=null){
                que.add(node.left);
            }
            if (node.right!=null){
                que.add(node.right);
            }
            l++;
        }
        return false;
    }
}
