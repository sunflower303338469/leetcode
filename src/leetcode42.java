/**
 * Created by xuanmao on 2019/12/31.
 */
public class leetcode42 {
    public int trap(int[] height) {
        if (height.length<=1){
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = 0;
        for (int i=1;i<height.length;i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        right[height.length-1] = 0;
        for (int i=height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int ans =0;
        for (int i =0;i<height.length;i++){
            int min = Math.min(left[i],right[i]);
            if (height[i]<min){
                ans+=min-height[i];
            }
        }
        return ans;
    }
}
