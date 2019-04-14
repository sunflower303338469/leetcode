import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/2/22.
 */
public class leetcode802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> toWays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            toWays.add(graph[i].length);
        }
        List<List<Integer>> toNodesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> toNodes = new ArrayList<>();
            toNodesList.add(toNodes);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                List<Integer> arr = toNodesList.get(graph[i][j]);
                arr.add(i);
            }
        }

        Integer newEnd;
        while (ans.size() < n) {
            newEnd = null;
            for (int i = 0; i < n; i++) {
                if (toWays.get(i) == 0) {
                    newEnd = i;
                    toWays.set(i, -1);
                    break;
                }
            }
            if (null == newEnd) {
                break;
            }
            ans.add(newEnd);
            List<Integer> arr = toNodesList.get(newEnd);
            for (Integer node : arr) {
                toWays.set(node, toWays.get(node) - 1);
            }
        }
        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return ans;
    }
}
