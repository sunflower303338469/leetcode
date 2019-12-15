import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/10/23.
 */
public class leetcode863 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    Map<Integer,List<Integer>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null){
            return new ArrayList<>();
        }
        buildMap(root);
        boolean[] visit = new boolean[1000];
        List<Integer> dis = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        queue.add(target.val);
        dis.add(0);
        visit[target.val] = true;
        int l =0;
        while (l<queue.size()){
            Integer now = queue.get(l);
            Integer nowDis = dis.get(l);
            if (nowDis == K){
                ans.add(now);
            }
            if (nowDis>K){
                return ans;
            }
            List<Integer> nodeList = map.getOrDefault(now, new ArrayList<>());
            for (Integer node:nodeList){
                if (!visit[node]){
                    visit[node] = true;
                    queue.add(node);
                    dis.add(nowDis+1);

                }
            }
            l++;
        }
        return ans;
    }

    private void buildMap(TreeNode root){
        List<Integer> value = map.getOrDefault(root.val, new ArrayList<>());
        if (root.left != null){
            value.add(root.left.val);
            map.put(root.val, value);
            List<Integer> childValue = map.getOrDefault(root.left.val, new ArrayList<>());
            childValue.add(root.val);
            map.put(root.left.val, childValue);
            buildMap(root.left);
        }
        if (root.right != null){
            value.add(root.right.val);
            map.put(root.val, value);
            List<Integer> childValue = map.getOrDefault(root.right.val, new ArrayList<>());
            childValue.add(root.val);
            map.put(root.right.val, childValue);
            buildMap(root.right);
        }
    }

}
