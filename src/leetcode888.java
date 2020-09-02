import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            map.put(A[i], i);
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int value = (sumA - sumB) / 2;
        for (int i =0;i<B.length;i++){
            Integer index = map.get(B[i]+ value);
            if (index!=null){
                int[] ans = new int[2];
                ans[0] = B[i]+value;
                ans[1] = B[i];
                return ans;
            }
        }
        return new int[2];
    }
}
