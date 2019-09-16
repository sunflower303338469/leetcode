import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/19.
 */
public class leetcode783 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> midOrder = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        mid(root);
        int ans =999999;
        for (int i=1;i<midOrder.size();i++){
            ans = Math.min(ans, midOrder.get(i)- midOrder.get(i-1));
        }
        return ans;
    }

    private void mid(TreeNode root){
        if (root.left!=null){
            mid(root.left);
        }
        midOrder.add(root.val);
        if (root.right!=null){
            mid(root.right);
        }
    }
}
