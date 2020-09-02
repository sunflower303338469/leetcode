/**
 * Created by xuanmao on 2020/7/9.
 */
public class leetcode450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode f = null;
    TreeNode d = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        find(null, root, key);
        if (d == null) {
            return root;
        }
        TreeNode newNode = null;
        if (d.left != null) {
            newNode = d.left;
            if ((newNode.right != null) && (d.right != null)) {
                TreeNode mLeft = d.right;
                while (mLeft.left != null) {
                    mLeft = mLeft.left;
                }
                mLeft.left = newNode.right;
                newNode.right = d.right;
            } else if (newNode.right == null) {
                newNode.right = d.right;
            }
        } else if (d.right != null) {
            newNode = d.right;
        }
        if (f == null) {
            root = newNode;
        } else if (f.left == d) {
            f.left = newNode;
        } else if (f.right == d) {
            f.right = newNode;
        }
        return root;
    }

    private void find(TreeNode father, TreeNode root, int key) {
        if (root == null) {
            return;
        }
        if (root.val == key) {
            f = father;
            d = root;
            return;
        }
        if (key < root.val) {
            find(root, root.left, key);
        } else {
            find(root, root.right, key);
        }
    }
}
