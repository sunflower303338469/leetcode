/**
 * Created by xuanmao on 2019/1/25.
 */
public class leetcode606 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public String tree2str(TreeNode t) {
        if (t == null){
            return "";
        }
        if ((t.left == null) && (t.right == null)){
            return String.valueOf(t.val);
        }
        if (t.left == null){
            return t.val + "()" + "(" + tree2str(t.right) + ")";
        }
        if (t.right == null){
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val +  "(" + tree2str(t.left) + ")" +  "(" + tree2str(t.right) + ")";
    }
}
