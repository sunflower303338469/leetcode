import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/10/6.
 */
public class leetcode834 {
    int[] ans;
    boolean[] visit;
    int[] count;
    int NN;
    Map<Integer, List<Integer>> edgeMap = new HashMap<>();

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        visit = new boolean[N];
        count = new int[N];
        NN = N;
        for (int i = 0; i < edges.length; i++) {
            List<Integer> list = edgeMap.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);
            edgeMap.put(edges[i][0], list);
            list = edgeMap.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(edges[i][0]);
            edgeMap.put(edges[i][1], list);
        }
        ans[0] = dfs(0);
        visit = new boolean[N];
        fall(0, 0);
        return ans;
    }

    private int dfs(Integer node) {
        visit[node] = true;
        List<Integer> list = edgeMap.getOrDefault(node, new ArrayList<>());
        int sum = 0;
        count[node] = 1;
        for (Integer nextNode : list) {
            if (!visit[nextNode]) {
                int value = dfs(nextNode);
                count[node] += count[nextNode];
                sum += value + count[nextNode];
            }
        }
        return sum;
    }

    private void fall(Integer node, Integer value) {
        visit[node] = true;
        List<Integer> list = edgeMap.getOrDefault(node, new ArrayList<>());
        int leftNodeCount = NN - count[node];
        if (node != 0) {
            ans[node] = value - count[node] + leftNodeCount;

        }
        for (Integer nextNode : list) {
            if (!visit[nextNode]) {
                fall(nextNode, ans[node]);
            }
        }
    }
}
