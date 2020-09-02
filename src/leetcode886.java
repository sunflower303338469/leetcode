import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/5/29.
 */
public class leetcode886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] f = new int[N + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            List<Integer> aList = map.getOrDefault(dislikes[i][0], new ArrayList<>());
            aList.add(dislikes[i][1]);
            map.put(dislikes[i][0], aList);
            List<Integer> bList = map.getOrDefault(dislikes[i][1], new ArrayList<>());
            bList.add(dislikes[i][0]);
            map.put(dislikes[i][1], bList);
        }
        if (N <= 1) {
            return true;
        }
        for (int k = 1; k <= N; k++) {

            if (f[k]!=0){
                continue;
            }
            f[k] = 1;
            List<Integer> p = new ArrayList<>();
            p.add(k);
            int l = 0;
            while (l < p.size()) {
                int now = p.get(l);
                List<Integer> connectList = map.getOrDefault(now, new ArrayList<>());
                for (int i = 0; i < connectList.size(); i++) {
                    int next = connectList.get(i);
                    if (f[next] == 0) {
                        f[next] = -f[now];
                        p.add(next);
                    } else if (f[next] == f[now]) {
                        return false;
                    }
                }
                l++;
            }
        }
        return true;
    }
}
