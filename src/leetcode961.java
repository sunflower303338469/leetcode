import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2019/6/27.
 */
public class leetcode961 {
    public int repeatedNTimes(int[] A) {
        Set<Integer> hset = new HashSet<>();
        for(int i=0;i<A.length;i++){
            if (hset.contains(A[i])){
                return A[i];
            }
            hset.add(A[i]);
        }
        return 0;
    }
}
