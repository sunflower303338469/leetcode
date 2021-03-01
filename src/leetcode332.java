import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2021/1/26.
 */
public class leetcode332 {

    Map<String, List<Integer>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    boolean[] vis;
    int n = 0;
    List<List<String>> ticketList;

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();
        vis = new boolean[n];
        tickets.sort(Comparator.comparing((List<String> p) -> p.get(0)).thenComparing(q -> q.get(1)));
        ticketList = tickets;
        for (int i = 0; i < tickets.size(); i++) {
            List<String> slist = tickets.get(i);
            List<Integer> arrival = map.getOrDefault(slist.get(0), new ArrayList<>());
            arrival.add(i);
            map.put(slist.get(0), arrival);
        }
        dfs("JFK", 0);
        return ans;
    }

    private boolean dfs(String now, int x) {
        ans.add(now);
        if (x == n) {
            return true;
        }
        List<Integer> arrival = map.getOrDefault(now, new ArrayList<>());
        for (Integer v : arrival) {
            if (!vis[v]) {
                vis[v] = true;
                if (dfs(ticketList.get(v).get(1), x + 1)) {
                    return true;
                }
                vis[v] = false;
            }
        }
        ans.remove(ans.size()-1);
        return false;
    }
}
