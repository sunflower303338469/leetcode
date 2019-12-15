/**
 * Created by xuanmao on 2019/10/10.
 */
public class leetcode45 {
    public int jump(int[] nums) {
        int[] f= new int[nums.length];
        if (nums.length<=1){
            return 0;
        }
        for (int i =nums.length-2;i>=0;i--){
            int min = 9999999;
            int endPoint =  Math.min(nums.length-1, i+nums[i]);
            for (int j=i+1;j<=endPoint;j++){
                min = Math.min(min, f[j]);
            }
            f[i] = min+1;
        }
        return f[0];
    }
}
