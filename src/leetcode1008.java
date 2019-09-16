/**
 * Created by xuanmao on 2019/8/12.
 */
public class leetcode1008 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int x= 1;
        while ((x<preorder.length) && (preorder[x]<preorder[0])){
            x++;
        }
        if (x>1){
            int[] lList = new int[x-1];
            for (int i=1;i<x;i++){
                lList[i-1] = preorder[i];
            }
            root.left = bstFromPreorder(lList);
        }
        if (x<preorder.length){
            int[] rList=  new int[preorder.length-x];
            for (int i=x;i<preorder.length;i++){
                rList[i-x] = preorder[i];
            }
            root.right = bstFromPreorder(rList);
        }

        return root;
    }
}
