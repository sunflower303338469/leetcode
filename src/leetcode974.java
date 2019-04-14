import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/4/12.
 */
public class leetcode974 {
    public int subarraysDivByK(int[] A, int K) {
        int[] sumList = new int[A.length];
        int ans = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        sumList[0] = A[0];
        int t = sumList[0] % K;
        if (t < 0) {
            t = K+t;
        }
        hash.put(t, 1);

        for (int i = 1; i < A.length; i++) {
            sumList[i] = sumList[i - 1] + A[i];
            t = sumList[i] % K;
            if (t<0){
                t=K+t;
            }
            if (hash.containsKey(t)) {
                ans = ans + hash.get(t);
                hash.put(t, hash.get(t) + 1);
            } else {
                hash.put(t, 1);
            }
        }
        if (hash.containsKey(0)) {
            ans = ans + hash.get(0);
        }
        return ans;
    }
}
