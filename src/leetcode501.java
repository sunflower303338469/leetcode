import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/9/24.
 */
public class leetcode501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        dfs(root);
        int [] a = new int[ans.size()];
        for (int i  =0;i<a.length;i++){
            a[i] = ans.get(i);
        }
        return a;
    }


    private void dfs(TreeNode root){
        Integer c = map.getOrDefault(root.val,0);
        c++;
        map.put(root.val, c);
        if (c==count){
            ans.add(root.val);
        }
        if (c>count){
            count = c;
            ans = new ArrayList<>();
            ans.add(root.val);
        }
        if (root.left!=null){
            dfs(root.left);
        }
        if (root.right!=null){
            dfs(root.right);
        }
    }
}
