/**
 * Created by xuanmao on 2020/2/21.
 */
public class leetcode1006 {
    public int clumsy(int N) {
        Integer ans = null;
        while (N>0){
            int count = N;
            N--;
            if (N>0){
                count = count*N;
                N--;
            }
            if (N>0){
                count = count/N;
                N--;
            }
            if (ans ==null){
                ans = count;
            } else {
                ans = ans-count;
            }
            if (N>0){
                ans = ans + N;
                N--;
            }
        }
        return ans;
    }
}
