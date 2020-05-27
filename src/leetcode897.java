import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/4/28.
 */
public class leetcode897 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    List<TreeNode> nodeList=  new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        if (nodeList.isEmpty()){
            return null;
        }
        nodeList.sort(Comparator.comparing(p->p.val));
        TreeNode head = nodeList.get(0);
        head.left=null;
        head.right=null;
        TreeNode now = head;
        for (int i=1;i<nodeList.size();i++){
            TreeNode next = nodeList.get(i);
            next.left=null;
            next.right=null;
            now.right=next;
            now=next;
        }
        return head;
    }

    private void dfs(TreeNode root){
        if (root == null){
            return;
        }
        nodeList.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
