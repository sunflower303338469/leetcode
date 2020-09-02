import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/7/22.
 */
public class leetcode1027 {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int i =1;i<A.length;i++){
            for (int j=0;j<i;j++){
                int key = getKey(j, A[i]-A[j]);
                int k = count.getOrDefault(key, 0);
                k++;
                count.put(getKey(i,A[i]-A[j]), k);
                ans = Math.max(ans, k);
            }
        }
        return ans+1;
    }

    private int getKey(int index, int value){
        return index*100000 + value;
    }
}
