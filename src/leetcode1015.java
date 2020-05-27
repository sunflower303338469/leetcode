/**
 * Created by xuanmao on 2020/5/10.
 */
public class leetcode1015 {
    public int smallestRepunitDivByK(int K) {
        if ((K%2==0) || (K%5==0)){
            return -1;
        }
        long n = 1;
        int ans = 1;
        while (n%K!=0){
            n = n%K;
            n = n*10+1;
            ans++;
        }
        return ans;
    }
}
