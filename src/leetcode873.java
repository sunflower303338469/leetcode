import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/5/10.
 */
public class leetcode873 {
    public int lenLongestFibSubseq(int[] A) {

        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i=0;i<A.length;i++){
            valueMap.put(A[i],i);
        }
        int ans = 0;
        Map<Integer, Integer> savePath = new HashMap<>();
        for (int k = 0;k<A.length;k++){
            for (int j=0;j<k;j++){
                int i = valueMap.getOrDefault(A[k] - A[j],-1);
                //保证i,j,k的顺序
                if ((i>=0) && (i<j)){
                    int count = savePath.getOrDefault(i*A.length+j,2)+1;
                    savePath.put(j*A.length+k,count);
                    ans = Math.max(count, ans);
                }
            }
        }
        return ans;
    }
}
