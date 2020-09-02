/**
 * Created by xuanmao on 2020/6/2.
 */
public class leetcode513 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Level {
        int val;
        int level;
    }

    public int findBottomLeftValue(TreeNode root) {
        return getLevel(root).val;
    }

    private Level getLevel(TreeNode root) {
        Level level = new Level();
        if ((root.left == null) && (root.right == null)) {
            level = new Level();
            level.level = 0;
            level.val = root.val;
        }
        if ((root.left == null) && (root.right != null)) {
            Level rightLevel = getLevel(root.right);
            rightLevel.level++;
            level = rightLevel;
        }
        if ((root.left != null) && (root.right == null)) {
            Level leftlevel = getLevel(root.left);
            leftlevel.level++;
            level = leftlevel;
        }
        if ((root.left != null) && (root.right != null)) {
            Level leftlevel = getLevel(root.left);
            Level rightLevel = getLevel(root.right);
            if (leftlevel.level >= rightLevel.level) {
                leftlevel.level++;
                level = leftlevel;
            } else {
                rightLevel.level++;
                level = rightLevel;
            }
        }

        return level;
    }
}
