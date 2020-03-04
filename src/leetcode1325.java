/**
 * Created by xuanmao on 2020/2/21.
 */
public class leetcode1325 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null){
            return null;
        }
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if ((left == null) && (right == null) && (root.val==target)){
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
