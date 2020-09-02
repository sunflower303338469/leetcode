import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/7/22.
 */
public class leetcode103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null){
            return Collections.emptyList();
        }
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        nodeList.add(root);
        levelList.add(0);
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        int l =0;
        while (l<nodeList.size()){
            TreeNode node = nodeList.get(l);
            int level = levelList.get(l);
            List<Integer> levelCount = levelMap.getOrDefault(level, new ArrayList<>());
            levelCount.add(node.val);
            levelMap.put(level, levelCount);

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
        List<List<Integer>> ans = new ArrayList<>();
        int p  =0;
        while (levelMap.containsKey(p)){
            if (p%2==0) {
                ans.add(levelMap.get(p));
            } else {
                List<Integer> count = levelMap.get(p);
                Collections.reverse(count);
                ans.add(count);
            }
            p++;
        }
        return ans;
    }
}
