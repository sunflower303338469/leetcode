import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/8/19.
 */
public class leetcode652 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> ans = new ArrayList<>();
    Map<String,Boolean> path = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getPath(root);
        return ans;
    }

    private String getPath(TreeNode root){
        if (root ==null){
            return "";
        }
        String leftStr = "";
        String rightStr = "";
        if (root.left != null){
            leftStr = getPath(root.left);
        }
        if(root.right!=null){
            rightStr = getPath(root.right);
        }
        String rootStr = "("+leftStr+")"+root.val+"("+rightStr+")";
        Boolean isExist = path.get(rootStr);
        if (isExist==null){
            path.put(rootStr, false);
        } else if (!isExist){
            path.put(rootStr,true);
            ans.add(root);
        }
        return rootStr;
    }
}
