import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/9.
 */
public class t2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if (root==null){
            return 0;
        }
        List<Integer> deep = new ArrayList<>();
        int[] sum = new int[10002];
        List<TreeNode> que = new ArrayList<>();
        que.add(root);
        deep.add(1);
        sum[1] = root.val;
        int l=0;
        int maxDeep = 1;
        while (l<que.size()){
            TreeNode node = que.get(l);
            int d = deep.get(l);
            if (node.left!=null){
                que.add(node.left);
                deep.add(d+1);
                sum[d+1]+=node.left.val;
                maxDeep = Math.max(maxDeep, d+1);
            }
            if (node.right !=null){
                que.add(node.right);
                deep.add(d+1);
                sum[d+1]+=node.right.val;
                maxDeep = Math.max(maxDeep, d+1);
            }
            l++;
        }
        int maxValue = -100000000;
        int ans = 0;
        for (int i=1;i<=maxDeep;i++){
            if (maxValue<sum[i]){
                maxValue = sum[i];
                ans = i;
            }
        }
        return ans;
    }
}
