import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/11/19.
 */
public class leetcode1382 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> nodeList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        getNodeList(root);
        return getBalance(0, nodeList.size()-1);
    }

    private void getNodeList(TreeNode node) {
        if (node == null) {
            return;
        }
        getNodeList(node.left);
        nodeList.add(node);
        getNodeList(node.right);
    }

    private TreeNode getBalance(int l ,int r){
        if (l>r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode midNode = nodeList.get(mid);
        midNode.left = getBalance(l, mid-1);
        midNode.right = getBalance(mid+1, r);
        return midNode;
    }
}
