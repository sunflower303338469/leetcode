import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/7/9.
 */
public class leetcode982 {
    public int countTriplets(int[] A) {
        int[] v = new int[100000];
        for (int i =0;i<A.length;i++){
            for (int j=0;j<A.length;j++){
                v[A[i] & A[j]] ++;
            }
        }
        Map<Integer, Integer> intMap = new LinkedHashMap<>();
        for (int i =0;i<100000;i++){
            if (v[i]>0){
                intMap.put(i, v[i]);
            }
        }
        int ans = 0;
        for (int i=0;i<A.length;i++){
            for (int j:intMap.keySet()){
                if ((A[i] & j) ==0){
                    ans+=intMap.get(j);
                }
            }
        }
        return ans;
    }
}
