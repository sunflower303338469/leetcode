import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/23.
 */
public class leetcode102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        List<Integer> levelList=  new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> nowLevelList = new ArrayList<>();
        int nowLevel  =0;
        levelList.add(0);
        nodeList.add(root);
        int l = 0;
        while (l<nodeList.size()){
            int level = levelList.get(l);
            TreeNode node = nodeList.get(l);
            if (level>nowLevel){
                nowLevel = level;
                ans.add(nowLevelList);
                nowLevelList=  new ArrayList<>();
            }
            nowLevelList.add(node.val);
            if (node.left!=null){
                levelList.add(level+1);
                nodeList.add(node.left);
            }
            if (node.right!=null){
                levelList.add(level+1);
                nodeList.add(node.right);
            }
            l++;
        }
        ans.add(nowLevelList);
        return ans;
    }
}
