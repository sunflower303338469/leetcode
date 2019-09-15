/**
 * Created by xuanmao on 2019/6/27.
 */
public class leetcode106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0){
            return null;
        }
        int value = postorder[postorder.length-1];
        int pos = 0;
        for (int i =0;i<inorder.length;i++){
            if (value==inorder[i]){
                pos= i;
            }
        }
        TreeNode nowNode = new TreeNode(value);
        if (pos !=0){
            int[] newInorder = new int[pos];
            int[] newPostorder = new int[pos];
            for (int i =0;i<pos;i++){
                newInorder[i] = inorder[i];
                newPostorder[i] = postorder[i];
            }
            nowNode.left = buildTree(newInorder, newPostorder);
        }
        if (pos !=inorder.length-1){
            int[] newInorder = new int[inorder.length-pos-1];
            int[] newPostorder = new int[inorder.length-pos-1];
            for (int i=0;i<newInorder.length;i++){
                newInorder[i] = inorder[pos+i+1];
                newPostorder[i] = postorder[pos+i];
            }
            nowNode.right = buildTree(newInorder, newPostorder);
        }
        return nowNode;

    }
}
