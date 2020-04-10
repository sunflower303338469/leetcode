/**
 * Created by xuanmao on 2020/4/6.
 */
public class leetcode437 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    int total = 0;
    public int pathSum(TreeNode root, int sum) {
        find(root, sum, new int[0]);
        return total;
    }

    private void find(TreeNode root, int sum, int[] arr){
        if (root == null){
            return;
        }
        int count = 0;
        for (int i =arr.length-1;i>=0;i--){
            count = count +arr[i];
            if (count+root.val == sum){
                total++;
            }
        }
        if (root.val == sum){
            total ++;
        }
        int[] nextArr = new int[arr.length+1];
        for (int i=0;i<arr.length;i++){
            nextArr[i]= arr[i];
        }
        nextArr[arr.length] = root.val;
        if (root.left != null){
            find(root.left, sum ,nextArr);
        }
        if (root.right != null){
            find(root.right, sum ,nextArr);
        }
    }
}
