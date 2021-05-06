/**
 * Created by xuanmao on 2021/4/29.
 */
public class leetcode1261 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class FindElements {

        TreeNode root;

        public FindElements(TreeNode root) {
            this.root = root;
            setTree(root, 0);
        }

        public boolean find(int target) {
            return dfs(root, target);
        }

        private void setTree(TreeNode root, int x) {
            root.val = x;
            if (root.left != null) {
                setTree(root.left, x * 2 + 1);
            }
            if (root.right != null) {
                setTree(root.right, x * 2 + 2);
            }
        }

        private boolean dfs(TreeNode root, int target){
            if (root == null){
                return false;
            }
            if (root.val == target){
                return true;
            }
            if (root.val>target){
                return false;
            }
            return dfs(root.left, target) || dfs(root.right, target);
        }
    }

}
