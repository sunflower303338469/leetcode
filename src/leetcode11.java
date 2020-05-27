/**
 * Created by xuanmao on 2020/5/7.
 */
public class leetcode11 {
    public int maxArea(int[] height) {
        int ans = 0;
        int l =0;
        int r =height.length-1;
        while (l<r){
            ans = Math.max(ans, (r-l)*Math.min(height[l],height[r]));
            if (height[l]<height[r]){
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
