/**
 * Created by xuanmao on 2021/1/8.
 */
public class leetcode566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length==0){
            return nums;
        }
        if (r*c!=nums.length*nums[0].length){
            return nums;
        }
        int[][] ans = new int[r][c];
        int rr =0;
        int cc = 0;

        for (int i =0;i<nums.length;i++){
            for (int j =0;j<nums[0].length;j++){
                ans[rr][cc] = nums[i][j];
                cc = cc +1;
                if (cc==c){
                    cc = 0;
                    rr+=1;
                }
            }
        }
        return ans;
    }
}
