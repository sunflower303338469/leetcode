/**
 * Created by xuanmao on 2020/2/11.
 */
public class leetcode114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left!=null){
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            while (root.right!=null){
                root = root.right;
            }
            root.right = right;
        }
        flatten(root.right);

    }
}
