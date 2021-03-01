import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/11/19.
 */
public class leetcode1379 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> originalList = new ArrayList<>();
    List<TreeNode> clonedList = new ArrayList<>();

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        getNodeList(original, originalList);
        getNodeList(cloned, clonedList);
        for (int i = 0; i < originalList.size(); i++) {
            TreeNode node = originalList.get(i);
            if (node == target) {
                return clonedList.get(i);
            }
        }
        return null;
    }

    private void getNodeList(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }
        getNodeList(root.left, nodeList);
        nodeList.add(root);
        getNodeList(root.right, nodeList);
    }
}
