/**
 * Created by xuanmao on 2019/2/15.
 */


public class leetcode98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class CheckVO{
        Integer min;
        Integer max;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        return getMaxAndCheck(root) != null;
    }

    private CheckVO getMaxAndCheck(TreeNode root){
        CheckVO left = null;
        CheckVO right = null;
        if (root.left != null){
            left = getMaxAndCheck(root.left);
            if ((left == null) || (left.max>=root.val)){
                return null;
            }
        }
        if (root.right != null){
            right = getMaxAndCheck(root.right);
            if ((right == null) || (root.val >= right.min)){
                return null;
            }
        }
        CheckVO ret = new CheckVO();
        if (right != null) {
            ret.max = right.max;
        } else{
            ret.max = root.val;
        }
        if (left != null){
            ret.min = left.min;
        } else {
            ret.min = root.val;
        }
        return ret;

    }
}
