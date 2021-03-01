import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2021/1/6.
 */
public class leetcode399 {
    Map<String, Double> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            add(x, x, 1);
            add(y, y, 1);
            add(x, y, values[i]);
            add(y, x, 1 / values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = bfs(queries.get(i).get(0), queries.get(i).get(1));
        }
        return ans;
    }

    private void add(String x, String y, double value) {
        if (map.containsKey(getKey(x, y))) {
            return;
        }
        map.put(getKey(x, y), value);
        set.add(x);
        set.add(y);
    }

    private String getKey(String x, String y) {
        return x + '/' + y;
    }

    private double bfs(String x, String y) {
        if (!set.contains(x) || !set.contains(y)){
            return -1;
        }
        Set<String> visit = new HashSet<>();
        List<String> headList = new ArrayList<>();
        List<Double> valueList = new ArrayList<>();
        headList.add(x);
        valueList.add(1.0);
        visit.add(x);
        int l = 0;
        while (l < headList.size()) {
            String now = headList.get(l);
            if (now.equals(y)) {
                return valueList.get(l);
            }
            for (String next : set) {
                if ((!visit.contains(next)) && (map.containsKey(getKey(now, next)))) {
                    Double d = map.get(getKey(now, next));
                    visit.add(next);
                    headList.add(next);
                    valueList.add(valueList.get(l) * d);
                    add(x, next, valueList.get(l) * d);
                }
            }
            l++;
        }
        return -1.0;
    }
}
