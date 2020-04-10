import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/4/9.
 */
public class leetcode508 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        find(root);
        List<Integer> ansList =new ArrayList<>();
        int max = 0;
        for (Integer value:map.keySet()){
            Integer count = map.get(value);
            if (count == max){
                ansList.add(value);
            } else if (count>max){
                max = count;
                ansList.clear();
                ansList.add(value);
            }
        }
        int[] ans = new int[ansList.size()];
        for (int i=0;i<ans.length;i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    private int find(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftSum = find(root.left);
        int rightSum = find(root.right);
        int sum = leftSum+rightSum+root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        return sum;
    }


}
