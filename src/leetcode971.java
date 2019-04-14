import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xuanmao on 2019/2/22.
 */
public class leetcode971 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<Integer> ans = new ArrayList<>();
    int h = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null) {
            return ans;
        }
        if (dfs(root, voyage)){
            return ans;
        } else {
            List<Integer> fail = new ArrayList<>();
            fail.add(-1);
            return fail;
        }
    }

    private Boolean dfs(TreeNode root, int[] voyage){
        if (root.val != voyage[h]) {
            return false;
        }
        Boolean re = true;
        if ((null != root.left) && (null != root.right)){
            if ((voyage[h+1] != root.left.val) && (voyage[h+2] != root.right.val)){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                ans.add(root.val);
            }
        }

        if (null != root.left){
            h = h+1;
            re = re && dfs(root.left, voyage);
        }
        if (null != root.right){
            h = h+1;
            re = re && dfs(root.right, voyage);
        }
        return re;
    }

}
