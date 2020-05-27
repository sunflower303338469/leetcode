/**
 * Created by xuanmao on 2020/4/10.
 */
public class leetcode908 {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++){
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        max = max -K;
        min = min+K;
        if (max<=min){
            return 0;
         } else {
            return max-min;
        }
    }
}
