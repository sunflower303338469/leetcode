/**
 * Created by xuanmao on 2020/2/21.
 */
public class leetcode492 {
    public int[] constructRectangle(int area) {
        int [] ans = new int[2];
        double n = Math.sqrt(area);
        for (int i=(int)n;i>=1;i--){
            if (area%i==0){
                ans[1] = i;
                ans[0] = area/i;
                return ans;
            }
        }
        return ans;
    }
}
