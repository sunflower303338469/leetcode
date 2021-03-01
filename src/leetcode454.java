import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/11/27.
 */
public class leetcode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Long, Integer> count = new HashMap<>();
        int ans = 0;
        for (int i=0;i<A.length;i++){
            for (int j=0;j<B.length;j++){
                int c =  count.getOrDefault((long)(A[i]+B[j]),0);
                count.put((long)(A[i]+B[j]), c+1);
            }
        }

        for (int i=0;i<C.length;i++){
            for (int j=0;j<D.length;j++){
                Long x = (long)(C[i]+D[j]);
                int c = count.getOrDefault(-x, 0);
                ans +=c;
            }
        }
        return ans;
    }
}
