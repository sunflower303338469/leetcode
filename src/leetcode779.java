/**
 * Created by xuanmao on 2019/3/6.
 */
public class leetcode779 {
    public int kthGrammar(int N, int K) {
        int ans = 0;
        int h = 1;
        int l=1;
        int r=(int)Math.pow(2,N-1);
        while (h<N){
            int mid = (l+r)/2;
            h+=1;
            if (K>mid){
                ans = 1 - ans;
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return ans;
    }
}
