import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/8/27.
 */
public class leetcode932 {


    Map<Integer, List<Integer>> memMap = new HashMap<>();

    public int[] beautifulArray(int N) {
        dAndC(N);
        List<Integer> ansList = memMap.get(N);
        int[] ans = new int[N];
        if (ansList != null) {
            for (int i = 0; i < N; i++) {
                ans[i] = ansList.get(i);
            }
        }
        return ans;
    }

    private void dAndC(Integer n) {
        if ((n <= 0) || (memMap.get(n) != null)) {
            return;
        }
        if (n == 1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            memMap.put(n, ans);
            return;
        }
        dAndC((n+1)/2);
        dAndC(n/2);
        List<Integer> ans = new ArrayList<>();
        List<Integer> odd = memMap.get((n+1)/2);
        for (Integer value:odd){
            ans.add(value*2-1);
        }
        List<Integer> even = memMap.get(n/2);
        for (Integer value:even){
            ans.add(value*2);
        }
        memMap.put(n, ans);
    }


}
