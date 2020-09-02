import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/29.
 */
public class leetcode199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        List<TreeNode> nodeList= new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        nodeList.add(root);
        levelList.add(0);
        int l = 0;
        while (nodeList.size()>l){
            int level = levelList.get(l);
            TreeNode node = nodeList.get(l);
            if (level<ans.size()){
                ans.set(level, node.val);
            } else {
                ans.add(node.val);
            }
            if (node.left!=null){
                nodeList.add(node.left);
                levelList.add(level+1);
            }
            if (node.right!=null){
                nodeList.add(node.right);
                levelList.add(level+1);
            }
            l++;
        }
        return ans;
    }
}
