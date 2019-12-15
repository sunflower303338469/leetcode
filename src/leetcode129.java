import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/11/12.
 */
public class leetcode129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        getLeafNumber(root,0);
        return sum;
    }

    private void getLeafNumber(TreeNode root, int num){
        if (root==null){
            return;
        }
        num = num*10+root.val;
        if (root.left!=null){
            getLeafNumber(root.left, num);
        }
        if (root.right!=null){
            getLeafNumber(root.right,num);
        }
        if ((root.left==null) && (root.right==null)){
            sum+=num;
        }
    }
}
