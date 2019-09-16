/**
 * Created by xuanmao on 2019/8/18.
 */
public class leetcode1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] f = new int [60];
        int ans= 0;
        for (int i =0;i<time.length;i++){
            int cha = time[i] % 60;
            ans += f[(60-cha) % 60];
            f[cha]++;
        }
        return ans;
    }
}
