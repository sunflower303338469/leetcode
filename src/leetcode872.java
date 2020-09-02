import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/29.
 */
public class leetcode872 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1!=null){
            midOrder(root1, 1);
        }
        if (root2!=null){
            midOrder(root2, 2);
        }
        if (list1.size()!=list2.size()){
            return false;
        }
        for (int i=0;i<list1.size();i++){
            if (!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    private void midOrder(TreeNode root, int type){
        if ((root.left == null) && (root.right==null)){
            if (type == 1){
                list1.add(root.val);
            } else {
                list2.add(root.val);
            }
            return;
        }
        if (root.left!=null){
            midOrder(root.left, type);
        }
        if (root.right!=null){
            midOrder(root.right, type);
        }
    }
}
