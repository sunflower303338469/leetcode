import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/8/19.
 */
public class leetcode447 {
    public int numberOfBoomerangs(int[][] points) {
        Map<Long, Integer> s = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                int euclideanPath = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                long x = i*10000*100000L + euclideanPath;
                Integer p = s.get(x);
                if (p==null) {
                    p=0;
                }
                long y = j*10000*100000L + euclideanPath;
                Integer q = s.get(y);
                if (q==null) {
                    q=0;
                }
                ans+=(p*2);
                ans+=(q*2);
                p++;
                q++;
                s.put(x, p);
                s.put(y, q);
            }
        }
        return ans;
    }
}
