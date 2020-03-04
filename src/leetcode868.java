/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode868 {
    public int binaryGap(int N) {
        int max = 0;
        int now =1;
        while ((N>0) && (N%2==0)){
            N =N/2;
        }
        if (N<=1){
            return 0;
        }
        while (N>0){
            if (N%2==0){
                now++;
            } else {
                max = Math.max(max, now);
                now=1;
            }
            N=N/2;
        }
        return max;
    }
}
