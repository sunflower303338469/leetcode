/**
 * Created by xuanmao on 2020/9/10.
 */
public class leetcode1375 {
    public int numTimesAllBlue(int[] light) {
        int max = -1;
        int ans = 0;
        for (int i =0;i<light.length;i++){
            max = Math.max(light[i],max);
            if (max == i+1){
                ans++;
            }
        }
        return ans;

    }
}
