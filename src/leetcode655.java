import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/26.
 */
public class leetcode655 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {

        Integer depth = getDepth(root);
        Integer num = 1;
        for (int i =1;i<=depth;i++){
            num = num *2;
        }
        num--;
        for (int i =0;i<depth;i++){
            List<String> sList = new ArrayList<>();
            for (int j =0;j<num;j++){
                sList.add("");
            }
            ans.add(sList);
        }
        fill(root, 0, num, 0);
        return ans;
    }

    private Integer getDepth(TreeNode root){
        if (root ==null){
            return 0;
        }
        int depth = 1;
        if (root.left!=null){
            depth = Math.max(depth, getDepth(root.left)+1);
        }
        if (root.right!=null){
            depth = Math.max(depth, getDepth(root.right)+1);
        }
        return depth;
    }

    private void fill(TreeNode root, int l, int r, int index){
        int pos = (l+r)/2;
        List<String> s = ans.get(index);
        s.set(pos , String.valueOf(root.val));
         if (root.left!=null){
             fill(root.left, l, pos ,index+1);
         }
         if (root.right!=null){
             fill(root.right, pos+1, r,index+1);
         }
    }
}
