import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/5/12.
 */
public class leetcode5056 {
    Map<Integer, List<Integer>> m = new HashMap<>();
    public int[] gardenNoAdj(int N, int[][] paths) {
        int [] ans = new int[N];
        for (int i=0;i<N;i++){
            List<Integer> l = new ArrayList<>();
            m.put(i+1, l);
        }
        for (int i=0;i<paths.length;i++){
            int x = paths[i][0];
            int y = paths[i][1];
            List<Integer> l = m.get(x);
            l.add(y);
            m.put(x,l);
            List<Integer> r = m.get(y);
            r.add(x);
            m.put(y,r);
        }
        find(ans, 1, N);
        return ans;

    }

    private boolean find(int[] ans, int x, int N){
        if (x >=N+1){
            return true;
        }
        List<Integer> l = m.get(x);
        int [] flag = new int[5];
        for (int p:l){
            flag[ans[p-1]] = 1;
        }
        for (int i=1;i<=4;i++){
            if (flag[i] == 0){
                ans[x-1] = i;
                System.out.println(i+" "+x);
                if (find(ans, x+1, N)){
                    return true;
                }
            }
        }
        ans[x-1] = 0;
        return false;
    }
}
