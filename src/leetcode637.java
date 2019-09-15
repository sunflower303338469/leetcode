import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/4/27.
 */
public class leetcode637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> nodeLevel = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        Double sum = 0.0;
        nodeList.add(root);
        nodeLevel.add(0);
        int nowLevel = 0;
        int count = 0;
        int l = 0;
        while (l < nodeList.size()) {
            TreeNode nowNode =  nodeList.get(l);
            if (nowLevel == nodeLevel.get(l)){
                count = count +1;
                sum = sum + nowNode.val;
            } else {
                ans.add(sum/count);
                count = 1;
                sum = (double)nowNode.val;
                nowLevel = nodeLevel.get(l);
            }
            if (null !=nowNode.left){
                nodeList.add(nowNode.left);
                nodeLevel.add(nodeLevel.get(l)+1);
            }
            if (null!=nowNode.right){
                nodeList.add(nowNode.right);
                nodeLevel.add(nodeLevel.get(l)+1);
            }
            l++;
        }
        System.out.println(nodeLevel);
        ans.add(sum/count);
        return ans;
    }
}
