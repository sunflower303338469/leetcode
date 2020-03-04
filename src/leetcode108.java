/**
 * Created by xuanmao on 2020/1/16.
 */
public class leetcode108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){
            return null;
        }
        int mid = nums[nums.length/2];
        TreeNode node= new TreeNode(mid);
        if (nums.length/2!=0){
            int[] leftNums = new int[nums.length/2];
            for (int i=0;i<leftNums.length;i++){
                leftNums[i] = nums[i];
            }
            node.left = sortedArrayToBST(leftNums);
        }
        if (nums.length/2+1<nums.length){
            int[] rightNums = new int[nums.length-nums.length/2-1];
            for (int i=0;i<rightNums.length;i++){
                rightNums[i] = nums[nums.length/2+1+i];
            }
            node.right = sortedArrayToBST(rightNums);
        }
        return node;
    }
}
