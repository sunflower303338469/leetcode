import java.util.*;

public class leetcode5074 {

    class Way {
        Integer cost;
        Integer d;
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int index = 0;
        int minCost = 1000000;
        int ans = 0;
        Map<Integer, List<Way>> wayMap = new HashMap<>();
        for (int i = 0; i < pipes.length; i++) {
            List<Way> wayList = wayMap.get(pipes[i][0]);
            if (wayList == null) {
                wayList = new ArrayList<>();
            }
            Way w = new Way();
            w.cost = pipes[i][2];
            w.d = pipes[i][1];
            wayList.add(w);
            wayMap.put(pipes[i][0], wayList);

            wayList = wayMap.get(pipes[i][1]);
            if (wayList == null) {
                wayList = new ArrayList<>();
            }
            w = new Way();
            w.cost = pipes[i][2];
            w.d = pipes[i][0];
            wayList.add(w);
            wayMap.put(pipes[i][1], wayList);
        }
        Comparator<Way> com = new Comparator<Way>() {
            @Override
            public int compare(Way way, Way t1) {
                return way.cost.compareTo(t1.cost);
            }
        };
        PriorityQueue<Way> queue = new PriorityQueue<>(com);
        boolean[] vis = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            Way w = new Way();
            w.cost = wells[i];
            w.d = i+1;
            queue.add(w);
        }
        int left = n;

        while (left > 0) {
            Way now = queue.poll();
            if (vis[now.d]){
                continue;
            }
            System.out.println(now.d+ " "+now.cost);
            vis[now.d] = true;
            ans = ans + now.cost;
            List<Way> wayList = wayMap.get(now.d);
            if (wayList!=null){
                for (Way ww :wayList){
                    if (!vis[ww.d]){
                        System.out.println("add "+ww.d+ " "+ww.cost);
                        queue.add(ww);
                    }
                }
            }
            left--;
        }
        return ans;
    }
}
