/**
 * Created by xuanmao on 2019/7/24.
 */
public class leetcode829 {
    public int consecutiveNumbersSum(int N) {
        int ans = 1;
        int p = 1;
        while (2*N - p*(p+1)>0){
            int k  = 2*N - p*(p+1);
            if (k%(2*(p+1)) == 0){
                ans ++;
            }
            p++;
        }
        return ans;
    }
}